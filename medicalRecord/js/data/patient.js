/**
 * Created by sjh on 16/3/8.
 */
//病人信息表
var $table = $("#patientInfoTable");
var rowcontent = null;
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/patientinfo/getall/",
        dataType: "json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'patientId',
            visible: false,
            title: '病人ID'
        }, {
            field: 'patientName',
            title: '病人姓名'
        }, {
            field: 'patientSex',
            title: '病人性别'
        }, {
            field: 'patientAge',
            title: '病人年龄'
        }, {
            field: 'patientPhoneNumber',
            title: '手机号码'
        }, {
            field: 'patientIdentityCard',
            title: '身份证'
        }, {
            field: 'patientHeight',
            title: '病人身高',
            formatter: function (value) {
                return value + " cm";
            }
        }, {
            field: 'patientWeight',
            title: '病人体重',
            formatter: function (value) {
                return value + " kg";
            }
        }, {
            field: 'patientPosture',
            title: '病人体态'
        }, {
            field: 'patientProfessional',
            title: '病人职业'
        }, {
            field: 'patientAddress',
            title: '病人住址'
        }, {
            field: 'patientRemark',
            title: '备注'
        }]
    });
}

$("#add").click(function () {
    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
});

//阻止表单提交
$("form").submit(function (e) {
    e.preventDefault();
});
$('#cancel').click(function () {
    turnPage('patient.html');
});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$('#edit').click(function () {
    var jsonobject = eval('(' + rowcontent + ')');

    $('#patientId').val(jsonobject.patientId);
    $('#patientName').val(jsonobject.patientName);
    $('#patientSex').val(jsonobject.patientSex);
    $('#patientAge').val(jsonobject.patientAge);
    $('#patientPhoneNumber').val(jsonobject.patientPhoneNumber);
    $('#patientIdentityCard').val(jsonobject.patientIdentityCard);
    $('#patientHeight').val(jsonobject.patientHeight);
    $('#patientWeight').val(jsonobject.patientWeight);
    $('#patientPosture').val(jsonobject.patientPosture);
    $('#patientProfessional').val(jsonobject.patientProfessional);
    $('#patientAddress').val(jsonobject.patientAddress);
    $('#patientRemark').val(jsonobject.patientRemark);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
    $('#changepanel').html("病人信息编辑");
    $('#doit').html("确定");
});

$(function () {
    initTable();
    $('#doit').click(
        function () {
            var patientId = $('#patientId').val();
            var patientName = $('#patientName').val();

            var patientSex = $('#patientSex').val();
            var patientAge = $('#patientAge').val();
            var patientPhoneNumber = $('#patientPhoneNumber').val();
            var patientIdentityCard = $('#patientIdentityCard').val();
            var patientHeight = $('#patientHeight').val();
            var patientWeight = $('#patientWeight').val();
            var patientPosture = $('#patientPosture').val();
            var patientProfessional = $('#patientProfessional').val();
            var patientAddress = $('#patientAddress').val();
            var patientRemark = $('#patientRemark').val();

            $.ajax({
                url: baseAddress + "/patientinfo/saveorupdate",
                type: "post",
                dataType: "json",
                data: {
                    "patientId": patientId,
                    "patientName": patientName,
                    'patientSex': patientSex,
                    "patientAge": patientAge,
                    "patientPhoneNumber": patientPhoneNumber,
                    "patientIdentityCard": patientIdentityCard,
                    "patientHeight": patientHeight,
                    "patientWeight": patientWeight,
                    "patientPosture": patientPosture,
                    "patientProfessional": patientProfessional,
                    "patientAddress": patientAddress,
                    "patientRemark": patientRemark
                },
                success: function (msg) {
                    turnPage('patient.html');
                    console.log("patient_success:" + msg)
                },
                error: function (msg) {
                    turnPage('patient.html');
                    console.log("patient_error:" + msg)

                }
            });
        });
});

$('#remove').click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    //确认是否删除
    if (confirm("是否删除此条病人信息？")) {
        $.ajax({
            type: 'delete',
            url: baseAddress + "/patientinfo/deletebyid/" + jsonobject.patientId + "/",
            success: function (json) {
                turnPage('patient.html');
            }
        })
    }
});

$('#patientInfoEntity').bootstrapValidator({
    excluded: ':disabled',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },

    fields: {
        patientPhoneNumber: {
            validators: {
                notEmpty: {
                    message: '手机号不能为空'
                },
                regexp: {
                    regexp: /^1[3|4|5|8][0-9]\d{4,8}$/,
                    message: '不是完整的11位手机号或者正确的手机号前七位'
                }
            }
        },
        patientAge: {
            validators: {
                notEmpty: {
                    message: '年龄不能为空'
                },
                regexp: {
                    regexp: /^[1-9]\d?$|^1[01]\d$|^120$/,
                    message: '年龄1-120岁之间'
                }
            }
        },
        val50: {
            validators: {
                notEmpty: {
                    message: '不能为空'
                },
                stringLength: {
                    max: 50,
                    message: '不能超过50个字符'
                }
            }
        },
        val1024: {
            validators: {
                stringLength: {
                    max: 1024,
                    message: '不能超过1024个字符'
                }
            }
        }
    }
});




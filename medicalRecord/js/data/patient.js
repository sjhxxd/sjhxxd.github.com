/**
 * Created by sjh on 16/3/8.
 */
//病人信息表
var $table = $("#patientInfoTable");
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
            sortOrder: "desc",

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
            formatter: value20,
            title: '病人住址'
        }, {
            field: 'patientRemark',
            formatter: value20,
            title: '备注'
        }]
    });
}

$('#cancel').click(function () {
    turnPage('patient.html');
});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});
$('#edit').click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行修改操作!");
    }
    else if (n == 1) {
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
    }
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
                async: true,
                url: baseAddress + "/patientinfo/saveorupdate",
                type: "post",
                dataType: 'text',
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
                    console.log("patient_success:", msg);
                    turnPage('patient.html')
                },
                error: function (msg) {
                    console.log("patient_error:", msg)
                }
            });
        });
});
$('#remove').click(function () {
    checkboxFun();
    if (n == 0) {
        showTip();
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');
        //确认是否删除
        if (confirm("是否删除'" + jsonobject.patientName + "'这条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/patientinfo/deletebyid/" + jsonobject.patientId + "/",
                success: function (json) {
                    turnPage('patient.html');
                }
            })
        }
    }
});
$(document).ready(function () {
    $('#patientform').bootstrapValidator({
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },

        fields: {
            patientName: {
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    },
                    regexp: {
                        regexp: /^[\u4e00-\u9fa5]+$/,
                        message: '姓名只能包含中文'
                    }
                }
            },
            patientPhoneNumber: {
                validators: {
                    notEmpty: {
                        message: '手机号不能为空'
                    },
                    regexp: {
                        regexp: /^1[3|5|7|8|][0-9]{9}$/,
                        message: '请输入正确的手机号'
                    }
                }
            },
            patientIdentityCard: {
                validators: {
                    notEmpty: {
                        message: '身份证号不能为空'
                    },
                    regexp: {
                        regexp: /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,
                        message: '请输入正确的身份证号'
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
            patientWeight: {
                validators: {
                    regexp: {
                        regexp: /^\d{1,3}(\.\d{1,2})$/,
                        message: '限制最多三位整数以及两位小数'
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
                        message: '请输入不超过1024个字符的内容'
                    }
                }
            }
        }
    });

})




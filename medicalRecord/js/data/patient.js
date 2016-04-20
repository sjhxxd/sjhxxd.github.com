/**
 * Created by sjh on 16/3/8.
 */
//病人信息表
var $table = $("#patientInfoTable");

var $add = $("#add");
var rowcontent = null;
var tag = null;
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
            field: 'patientHeight',
            title: '病人身高',
            formatter: function (value, row, index) {
                return value + " cm";
            }
        }, {
            field: 'patientWeight',
            title: '病人体重',
            formatter: function (value, row, index) {
                return value + " kg";
            }
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

initTable();

$add.click(function () {
    tag = "add";
    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
});

//阻止表单提交
$("form").submit(function (e) {
    e.preventDefault();
});
$('#cancel').click(function () {
    $('.showpanel').css('display', 'block');
    $('.addpanel').css('display', 'none');
});

$('#edit').click(function () {
    tag = "edit";
    var jsonobject = eval('(' + rowcontent + ')');

    $('#patientId').val(jsonobject.patientId);
    $('#patientName').val(jsonobject.patientName);
    $('#patientSex').val(jsonobject.patientSex);
    $('#patientAge').val(jsonobject.patientAge);
    $('#patientPhoneNumber').val(jsonobject.patientPhoneNumber);
    $('#patientHeight').val(jsonobject.patientHeight);
    $('#patientWeight').val(jsonobject.patientWeight);
    $('#patientProfessional').val(jsonobject.patientProfessional);
    $('#patientAddress').val(jsonobject.patientAddress);
    $('#patientRemark').val(jsonobject.patientRemark);

    console.log(jsonobject);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');

    $('#changepanel').html("病人信息编辑");
    $('#doit').html("确定");
});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function () {
    $('#doit').click(
        function () {
            var patientId = $('#patientId').val();
            var patientName = $('#patientName').val();

            var patientSex = $('#patientSex').val();
            var patientAge = $('#patientAge').val();
            var patientPhoneNumber = $('#patientPhoneNumber').val();
            var patientHeight = $('#patientHeight').val();
            var patientWeight = $('#patientWeight').val();
            var patientProfessional = $('#patientProfessional').val();
            var patientAddress = $('#patientAddress').val();
            var patientRemark = $('#patientRemark').val();

            $.ajax({
                url: baseAddress+"/patientinfo/saveorupdate",
                type: "post",
                dataType: "json",
                data: {
                    "patientId":patientId,
                    "patientName": patientName,
                    'patientSex': patientSex,
                    "patientAge": patientAge,
                    "patientPhoneNumber": patientPhoneNumber,
                    "patientHeight": patientHeight,
                    "patientWeight": patientWeight,
                    "patientProfessional": patientProfessional,
                    "patientAddress": patientAddress,
                    "patientRemark": patientRemark
                },
                success: function (msg) {
                    turnPage('patient.html');
                    console.log("patient_success:"+msg)
                },
                error: function (msg){
                    turnPage('patient.html');
                    console.log("patient_error:"+msg)

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
            url: baseAddress+"/patientinfo/deletebyid/" + jsonobject.patientId + "/",
            success: function (json) {
                turnPage('patient.html');
            }
        })
    }
});




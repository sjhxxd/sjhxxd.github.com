/**
 * Created by sjh on 16/3/8.
 */
//处方表
var $table = $("#doctorPrescriptionTable");
var rowcontent = null;

function initTable() {
    $table.bootstrapTable({
        url: baseAddress+"/doctorprescription/getall",
        dataType: "json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'doctorPrescriptionId',
            visible: false,
            title: '处方ID'
        }, {
            field: 'prescriptionName',
            title: '处方名'
        }, {
            field: 'prescriptionInstructions',
            formatter: value20,
            title: '用法说明'
        }, {
            field: 'oralDoses',
            title: '服用剂量'
        }, {
            field: 'doctorPrescriptionRemark',
            formatter: value20,
            title: '备注'
        }, {
            field: 'prescriptionType',
            title: '处方类型'
        }, {
            field: 'prescriptionDate',
            title: '处方时间'
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
    turnPage('doctorPrescription.html');
});

$("#edit").click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行修改操作!");
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');
        $("#doctorPrescriptionId").val(jsonobject.doctorPrescriptionId);
        $("#prescriptionName").val(jsonobject.prescriptionName);
        $("#prescriptionInstructions").val(jsonobject.prescriptionInstructions);
        $("#oralDoses").val(jsonobject.oralDoses);
        $("#doctorPrescriptionRemark").val(jsonobject.doctorPrescriptionRemark);
        $("#prescriptionType").val(jsonobject.prescriptionType);
        $("#prescriptionDate").val(jsonobject.prescriptionDate);

        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
        $('#changepanel').html("医生处方信息编辑");
        $('#doit').html("确定");
    }
});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function () {
    //时间

    initTable();
    $("#doit").click(
        function () {
            var doctorPrescriptionId = $("#doctorPrescriptionId").val();
            var prescriptionName = $("#prescriptionName").val();
            var prescriptionInstructions = $("#prescriptionInstructions").val();
            var oralDoses = $("#oralDoses").val();
            var doctorPrescriptionRemark = $("#doctorPrescriptionRemark").val();
            var prescriptionType = $("#prescriptionType").val();
            var prescriptionDate = $("#prescriptionDate").val();

            $.ajax({
                url: baseAddress + "/doctorprescription/saveorupdate/",
                type: "post",
                dataType: "text",
                data: {
                    "doctorPrescriptionId": doctorPrescriptionId,
                    "prescriptionName": prescriptionName,
                    "prescriptionInstructions": prescriptionInstructions,
                    "oralDoses": oralDoses,
                    "doctorPrescriptionRemark": doctorPrescriptionRemark,
                    "prescriptionType": prescriptionType,
                    "prescriptionDate": prescriptionDate
                },
                success: function (msg) {
                    console.log("doctorPrescription_success:" + msg);
                    turnPage('doctorPrescription.html');
                },
                error: function (err) {
                    alert("doctorPrescription_error:" + err);
                }
            });
        });
});

$('#remove').click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行删除操作!");
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');
        if (confirm("是否删除 " + jsonobject.prescriptionName + " 这条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/doctorprescription/deletebyid/" + jsonobject.doctorPrescriptionId + "/",
                success: function () {
                    turnPage('doctorPrescription.html');
                }
            })
        }
    }
});
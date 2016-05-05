/**
 * Created by sjh on 16/3/8.
 */
//处方表
var $table = $("#doctorPrescriptionTable");
var rowcontent = null;

function initTable() {
    $table.bootstrapTable({
        url: "http://localhost:8080/doctorprescription/getall",
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
            title: '用法说明'
        }, {
            field: 'oralDoses',
            title: '服用剂量'
        }, {
            field: 'doctorPrescriptionRemark',
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


//时间
//$("#prescriptionDate").datetimepicker({
//    format: 'yyyy-mm-dd',
//    //todayHighlight:true,
//    autoclose: true
//});

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

});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function () {
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
                dateType: "json",
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
                    turnPage('doctorPrescription.html');
                    console.log("doctorPrescription_success:" + msg);

                    if (prescriptionDate instanceof String) {
                        console.log("prescriptionDatesucc is String ")
                    }
                    else {
                        console.log("Date");
                        console.log("prescriptionDatesucc", prescriptionDate);
                    }
                },
                error: function (err) {
                    alert("doctorPrescription_error:" + err);
                    turnPage('doctorPrescription.html');

                    if (prescriptionDate instanceof String) {
                        console.log("prescriptionDateerr is String ")
                    }
                    else {
                        console.log("Date");
                        console.log("prescriptionDateerr", prescriptionDate);
                    }
                }
            });
        });
});

$('#remove').click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    if (confirm("是否删除此条信息？")) {
        $.ajax({
            type: 'delete',
            url: baseAddress + "/doctorprescription/deletebyid/" + jsonobject.doctorPrescriptionId + "/",
            success: function (json) {
                turnPage('doctorPrescription.html');
            }
        })
    }
});
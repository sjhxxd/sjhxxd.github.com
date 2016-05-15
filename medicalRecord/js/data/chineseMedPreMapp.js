/**
 * Created by sjh on 16/4/4.
 */
//中药处方映射
var $table = $("#chineseMedPreMappTable");
var rowcontent = null;

function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/chinesemedpremapp/getall",
        dateType:"json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'chineseMedPrescriptMappId',
            visible: false,
            title: '中药处方映射ID'
        }, {
            field: 'tempChineseMedicineId',
            title: '中药ID'
        }, {
            field: 'tempDoctorPrescriptionId',
            title: '处方ID'
        }, {
            field: 'chineseMedicineDose',
            title: '中药用量'
        }, {
            field: 'tempUnitId',
            title: '计量单位ID'
        }, {
            field: 'decoctionMethod',
            title: '煎法'
        }]
    })
}
initTable();

$("#add").click(function () {
    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
});

//阻止表单提交
$("form").submit(function (e) {
    e.preventDefault();
});
$('#cancel').click(function () {
    turnPage('chineseMedPreMapp.html');
});


$("#edit").click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    $("#chineseMedPrescriptMappId").val(jsonobject.chineseMedPrescriptMappId);
    $("#tempChineseMedicineId").val(jsonobject.tempChineseMedicineId);
    $("#tempDoctorPrescriptionId").val(jsonobject.tempDoctorPrescriptionId);
    $("#chineseMesicineDose").val(jsonobject.chineseMesicineDose);
    $("#tempUnitId").val(jsonobject.tempUnitId);
    $("#decoctionMethod").val(jsonobject.decoctionMethod);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');

    $('#changepanel').html("中药处方映射关系编辑");
    $('#doit').html("确定");

});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function () {
    $("#doit").click(
        function () {
            var chineseMedPrescriptMappId = $("#chineseMedPrescriptMappId").val();
            var tempChineseMedicineId = $("#tempChineseMedicineId").val();
            var tempDoctorPrescriptionId = $("#tempDoctorPrescriptionId").val();
            var tempUnitId = $("#tempUnitId").val();
            var chineseMesicineDose = $("#chineseMesicineDose").val();
            var decoctionMethod = $("#decoctionMethod").val();

            $.ajax({
                url: baseAddress + "/chinesemedpremapp/saveorupdate",
                type: "post",
                dataType:'text',
                data: {
                    "chineseMedPrescriptMappId": chineseMedPrescriptMappId,
                    "tempChineseMedicineId": tempChineseMedicineId,
                    "tempDoctorPrescriptionId": tempDoctorPrescriptionId,
                    "tempUnitId": tempUnitId,
                    "chineseMesicineDose": chineseMesicineDose,
                    "decoctionMethod": decoctionMethod
                },
                success: function (msg) {
                    turnPage('chineseMedPreMapp.html');
                    console.log("chineseMedPreMapp_success:" + msg)
                },
                error: function (msg) {
                    console.log("chineseMedPreMapp_error:" + msg)

                }

            });
        });
});

$('#remove').click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    if (confirm("是否删除此条信息？")) {
        $.ajax({
            type: 'delete',
            url: baseAddress + "/chinesemedpremapp/deletebyid/" + jsonobject.chineseMedPrescriptMappId + "/",
            success: function (json) {
                turnPage('chineseMedPreMapp.html');
            }
        })
    }
});
//中药
jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/chinesemedicineinfo/getall",
        success: function (msg) {
            var str = "";
            for (i in msg) {
                str += "<option value =" + msg[i].chineseMedicineId + " >" + msg[i].medicineName + "</option>";
            }
            $("#tempChineseMedicineId").append(str);
        }
    })
});
//处方
jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/doctorprescription/getall",
        success: function (msg) {
            var str = "";
            for (i in msg) {
                str += "<option value =" + msg[i].doctorPrescriptionId + " >" + msg[i].prescriptionName + "</option>";
            }
            $("#tempDoctorPrescriptionId").append(str);
        }
    })
});
//计量单位
jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/measurementunit/getall",
        success: function (msg) {
            var str = "";
            for (i in msg) {
                str += "<option value =" + msg[i].unitId + " >" + msg[i].unitName + "</option>";
            }
            $("#tempUnitId").append(str);
        }
    })
});
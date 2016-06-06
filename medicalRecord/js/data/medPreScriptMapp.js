/**
 * Created by sjh on 16/3/8.
 */
//中药方剂映射表
var $table = $("#medPreScriptMappTable");
var rowcontent = null;
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/medprescriptmapp/getall",
        dataType: "json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'chineseMedPrescriptMappId',
            visible: false,
            title: '中药方剂映射ID'
        }, {
            field: 'tempChineseMedicineId',
            title: '中药ID'
        }, {
            field: 'tempPrescriptionId',
            title: '方剂ID'
        }, {
            field: 'medicineAmount',
            title: '中药用量'
        }, {
            field: 'tempUnitId',
            title: '计量单位ID'
        }, {
            field: 'decoctionMethod',
            formatter: value20,
            title: '煎法'
        }, {
            field: 'medPrescriptMappRemarks',
            formatter: value20,
            title: '映射备注'
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
    turnPage('medPreScriptMapp.html');
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
        //中药修改
        $.ajax({
            async:true,
            type: "get",
            dataType: "json",
            url: baseAddress + "/chinesemedicineinfo/findbyname/?medicineName=" + jsonobject.tempChineseMedicineId.toString(),
            success: function (msg) {
                var ChineseMedicineId = msg[0].chineseMedicineId;
                $('#tempChineseMedicineId').val(ChineseMedicineId);
            }
        });
        //方剂修改
        $.ajax({
            async:true,
            type: "get",
            dataType: "json",
            url: baseAddress + "/presctiptionsinfo/findbyname/?prescriptionName=" + jsonobject.tempPrescriptionId.toString(),
            success: function (msg) {
               var  PrescriptionId = msg[0].prescriptionId;
                $('#tempPrescriptionId').val(PrescriptionId);
            }
        });
        //计量单位修改
        $.ajax({
            async:true,
            type: "get",
            dataType: "json",
            url: baseAddress + "/measurementunit/findbyname/?unitName=" + jsonobject.tempUnitId.toString(),
            success: function (msg) {
                var  UnitId = msg.unitId;
                $('#tempUnitId').val(UnitId);
            }
        });
        $('#chineseMedPrescriptMappId').val(jsonobject.chineseMedPrescriptMappId);
        $('#medicineAmount').val(jsonobject.medicineAmount);
        $('#decoctionMethod').val(jsonobject.decoctionMethod);
        $('#medPrescriptMappRemarks').val(jsonobject.medPrescriptMappRemarks);

        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
        $('#changepanel').html("中药方剂映射关系编辑");
        $('#doit').html("确定");
    }
});

$(function () {
    initTable();
    $('#doit').click(
        function () {
            var chineseMedPrescriptMappId = $('#chineseMedPrescriptMappId').val();
            var tempChineseMedicineId = $('#tempChineseMedicineId').val();
            var tempPrescriptionId = $('#tempPrescriptionId').val();
            var medicineAmount = $('#medicineAmount').val();
            var tempUnitId = $('#tempUnitId').val();
            var decoctionMethod = $('#decoctionMethod').val();
            var medPrescriptMappRemarks = $('#medPrescriptMappRemarks').val();

            $.ajax({
                url: baseAddress + "/medprescriptmapp/saveorupdate",
                type: "post",
                dataType: "text",
                data: {
                    "chineseMedPrescriptMappId": chineseMedPrescriptMappId,
                    "tempChineseMedicineId": tempChineseMedicineId,
                    'tempPrescriptionId': tempPrescriptionId,
                    "medicineAmount": medicineAmount,
                    "tempUnitId": tempUnitId,
                    "decoctionMethod": decoctionMethod,
                    "medPrescriptMappRemarks": medPrescriptMappRemarks
                },
                success: function (msg) {
                    console.log("medPreScriptMapp_success:" + msg);
                    turnPage('medPreScriptMapp.html');
                },
                error: function (msg) {
                    console.log("patient_error:" + msg)
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
        //确认是否删除
        if (confirm("是否删除此条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/medprescriptmapp/deletebyid/" + jsonobject.chineseMedPrescriptMappId + "/",
                success: function () {
                    turnPage('medPreScriptMapp.html');
                }
            })
        }
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
            for (var i in msg) {
                str += "<option value =" + msg[i].chineseMedicineId + " >" + msg[i].medicineName + "</option>";
            }
            $("#tempChineseMedicineId").append(str);
        }
    })
});


//方剂
jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/presctiptionsinfo/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].prescriptionId + " >" + msg[i].prescriptionName + "</option>";
            }
            $("#tempPrescriptionId").append(str);
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
            for (var i in msg) {
                str += "<option value =" + msg[i].unitId + " >" + msg[i].unitName + "</option>";
            }
            $("#tempUnitId").append(str);
        }
    })
});
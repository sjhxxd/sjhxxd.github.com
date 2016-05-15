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
            title: '煎法'
        }, {
            field: 'medPrescriptMappRemarks',
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
    var jsonobject = eval('(' + rowcontent + ')');

    $('#chineseMedPrescriptMappId').val(jsonobject.chineseMedPrescriptMappId);
    $('#tempChineseMedicineId').val(jsonobject.tempChineseMedicineId);
    $('#tempPrescriptionId').val(jsonobject.tempPrescriptionId);
    $('#medicineAmount').val(jsonobject.medicineAmount);
    $('#tempUnitId').val(jsonobject.tempUnitId);
    $('#decoctionMethod').val(jsonobject.decoctionMethod);
    $('#medPrescriptMappRemarks').val(jsonobject.medPrescriptMappRemarks);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
    $('#changepanel').html("中药方剂映射关系编辑");
    $('#doit').html("确定");
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
});
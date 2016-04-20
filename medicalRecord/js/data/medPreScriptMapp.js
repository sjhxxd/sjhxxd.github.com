/**
 * Created by sjh on 16/3/8.
 */
//中药方剂映射表
var $table = $("#medPreScriptMappTable");
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/medprescriptmapp/getall",
        dateType: "json",
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

initTable();
/**
 * Created by sjh on 16/4/4.
 */
//中药处方映射
var $table = $("#chineseMedPreMappTable");

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
            field: 'tempUnitId',
            title: '计量单位ID'
        }, {
            field: 'chineseMesicineDose',
            title: '中药用量'
        }, {
            field: 'decoctionMethod',
            title: '煎法'
        }]
    })
}
initTable();
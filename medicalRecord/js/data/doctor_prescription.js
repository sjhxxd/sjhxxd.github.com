/**
 * Created by sjh on 16/3/8.
 */
//处方表
var $table = $("#doctorPrescriptionTable");
function initTable() {
    $table.bootstrapTable({
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'doctorPrescriptionId',
            visible: false,
            title: '处方ID'
        }, {
            field: 'tempChineseMedicineId',
            title: 'temp_药品ID'
        }, {
            field: 'chineseMedicineDose',
            title: '药品用量'
        }, {
            field: 'prescriptionInstructions',
            title: '药品用量'
        }, {
            field: 'oralDoses',
            title: '笔记类别'
        }, {
            field: 'prescriptionInstructions',
            title: '笔记类别'
        }, {
            field: 'doctorPrescriptionRemark',
            title: '笔记类别'
        }, {
            field: 'prescriptionType',
            title: '笔记类别'
        }]

    });
}

initTable();
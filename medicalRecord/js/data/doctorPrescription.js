/**
 * Created by sjh on 16/3/8.
 */
//处方表
var $table = $("#doctorPrescriptionTable");
function initTable() {
    $table.bootstrapTable({
        ulr:baseAddress+"/doctorprescription/getall",
        dataType:"json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'doctorPrescriptionId',
            visible: false,
            title: '处方ID'
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
        }]

    });
}

initTable();
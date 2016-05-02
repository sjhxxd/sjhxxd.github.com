/**
 * Created by sjh on 16/5/2.
 */
var $table = $("#inquiryResultTable");
function initTable() {
    $table.bootstrapTable({
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'inquiryResultId',
            visible: false,
            title: ''
        }, {
            field: 'tempPatientId',
            title: ''
        }, {
            field: 'inquiryDate',
            title: ''
        }, {
            field: 'inquiryRemarks',
            title: ''
        }, {
            field: 'inquiryResult',
            title: ''
        }, {
            field: 'inquiryFlag',
            title: ''
        }]

    });
}

initTable();
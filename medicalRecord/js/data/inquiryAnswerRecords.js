/**
 * Created by sjh on 16/5/2.
 */
var $table = $("#inquiryAnswerRecordsTable");
function initTable() {
    $table.bootstrapTable({
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'answerRecordsId',
            visible: false,
            title: ''
        }, {
            field: 'tempInquiryQuestionId',
            title: ''
        }, {
            field: 'tempPatientId',
            title: ''
        }, {
            field: 'inquiryQuestionAnswer',
            title: ''
        }]

    });
}

initTable();
/**
 * Created by sjh on 16/5/2.
 */
var $table=$("#inquiryIssuessTable");
function initTable(){
    $table.bootstrapTable({
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'inquiryQuestionId',
            visible: false,
            title: ''
        }, {
            field: 'inquiryQuestionContent',
            title: ''
        }, {
            field: 'inquiryQuestionRemarks',
            title: ''
        }]

    });
}

initTable();
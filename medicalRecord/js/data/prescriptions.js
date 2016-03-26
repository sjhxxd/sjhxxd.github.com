/**
 * Created by sjh on 16/3/8.
 */
//方剂信息表
var $table=$("#prescriptionsInfoTable");
function initTable(){
    $table.bootstrapTable({
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'prescriptionId',
            visible: false,
            title: '中药方剂ID'
        }, {
            field: 'prescriptionName',
            title: '方剂名称'
        }, {
            field: 'prescriptionOrigin',
            title: '出处'
        }, {
            field: 'prescriptionEffect',
            title: '功效'
        }, {
            field: 'prescriptionClass',
            title: '剂型'
        }, {
            field: 'prescriptionFunction',
            title: '功能主治'
        }, {
            field: 'prescriptionSummary',
            title: '概述'
        }, {
            field: 'prescriptionInstruction',
            title: '用法说明'
        }, {
            field: 'prescriptionRemark',
            title: '备注'
        }]

    });
}

initTable();
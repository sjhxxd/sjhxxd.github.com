/**
 * Created by sjh on 16/3/8.
 */
//计量单位表
var $table=$("#measurementUnitTable");
function initTable(){
    $table.bootstrapTable({
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'unitId',
            visible: false,
            title: '计量单位ID'
        }, {
            field: 'unitName',
            title: '计量单位名'
        }, {
            field: 'hexadecimal',
            title: '进制'
        }, {
            field: 'unitRemarks',
            title: '计量单位备注'
        }]

    });
}

initTable();
/**
 * Created by sjh on 16/3/8.
 */
//食材信息表
var $table=$("#foodMaterialInfoTable");
function initTable(){
    $table.bootstrapTable({
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'foodMaterialId',
            visible: false,
            title: '食材ID'
        }, {
            field: 'foodMaterialName',
            title: '食材名'
        }, {
            field: 'foodMaterialProperty',
            title: '性'
        }, {
            field: 'foodMaterialTaste',
            title: '味'
        }, {
            field: 'foodMaterialConnent',
            title: '内容'
        }, {
            field: 'tempPictureLocationId',
            visible:false,
            title: 'temp_图片ID'
        }, {
            field: 'foodMaterialRemark',
            title: '备注'
        }, {
            field: 'foodMaterialEffect',
            title: '功效'
        }]

    });
}

initTable();
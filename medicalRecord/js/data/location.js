/**
 * Created by sjh on 16/3/8.
 */
//地理位置信息表
var $table = $("#locationInfoTable");
function initTable() {
    $table.bootstrapTable({
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'locationInfoId',
            visible: false,
            title: '地理信息ID'
        }, {
            field: 'locationLongitude',
            visible: false,
            title: '经度'
        }, {
            field: 'locationLatitude',
            title: '纬度'
        }, {
            field: 'realLocation',
            title: '具体地理位置'
        }, {
            field: 'locationProvince',
            title: '所在省'
        }, {
            field: 'locationCity',
            title: '所在市'
        }, {
            field: 'locationClassify',
            title: '所在区'
        }, {
            field: 'locationCounty',
            title: '所在县'
        }, {
            field: 'locationRemarks',
            title: '地理位置备注'
        }]

    });
}

initTable();
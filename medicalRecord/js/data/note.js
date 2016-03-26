/**
 * Created by sjh on 16/3/8.
 */
//笔记表
var $table=$("#noteTable");
function initTable(){
    $table.bootstrapTable({
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'myNoteId',
            visible: false,
            title: '我的笔记ID'
        }, {
            field: 'tempDoctorId',
            visible: false,
            title: 'temp_医生ID'
        }, {
            field: 'noteDate',
            title: '笔记时间'
        }, {
            field: 'noteClass',
            title: '笔记类别'
        }]

    });
}

initTable();
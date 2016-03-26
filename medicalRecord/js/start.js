/**
 * Created by sjh on 16/2/29.
 */
$("#doctorInfoTable").bootstrapTable({
    columns: [{
        field: 'state',
        checkbox: true,
        align: 'center'

    }, {
        field: 'chineseMedicineId',
        visible: false,
        title: '中药ID'
    }, {
        field: 'medicineName',
        title: '中药名称'
    }, {
        field: 'medicineProperty',
        title: '药性'
    }, {
        field: 'medicineTaste',
        title: '药味'
    }, {
        field: 'effectType',
        title: '功效类别'
    }, {
        field: 'medicineGrade',
        title: '品级'
    }, {
        field: 'channelTropism',
        title: '归经'
    }, {
        field: 'indicationsFunction',
        title: '功能主治'
    }, {
        field: 'clinicalApplication',
        title: '临床应用'
    }, {
        field: 'tempPictureLocationId',
        visible: false,
        title: '图片ID'
    }, {
        field: 'chineseMedicineRemark',
        title: '中药备注'
    }, {
        field: 'anotherName',
        title: '别名'
    }]

    //data:[{
    //    doctorID:1,
    //    doctorName:"施嘉豪"
    //}]

});
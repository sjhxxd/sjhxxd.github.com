/**
 * Created by sjh on 16/2/29.
 */
    //中药信息表

var $table=$("#chineseMedicineInfoTable");
var rowcontent = null;
var tag = null;
function initTable(){
    $table.bootstrapTable({
        url: baseAddress+"/chinesemedicineinfo/getbyname/",
        dataType:"json",
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
            title: 'temp_图片ID'
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
}

initTable();

$("#add").click(function () {
    tag = "add";
    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
});
//阻止表单提交
$("form").submit(function(e){
    e.preventDefault();
});
$('#cancel').click(function () {
    $('.showpanel').css('display', 'block');
    $('.addpanel').css('display', 'none');
});
$('#edit').click(function () {
    tag = "edit";
    var jsonobject = eval('(' + rowcontent + ')');

    $('#chineseMedicineId').val(jsonobject.chineseMedicineId);
    $('#medicineName').val(jsonobject.medicineName);
    $('#medicineProperty').val(jsonobject.medicineProperty);
    $('#medicineTaste').val(jsonobject.medicineTaste);
    $('#effectType').val(jsonobject.effectType);
    $('#medicineGrade').val(jsonobject.medicineGrade);
    $('#channelTropism').val(jsonobject.channelTropism);
    $('#indicationsFunction').val(jsonobject.indicationsFunction);
    $('#tempPictureLocationId').val(jsonobject.tempPictureLocationId);
    $('#chineseMedicineRemark').val(jsonobject.chineseMedicineRemark);
    $('#anotherName').val(jsonobject.anotherName);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');

    $('#changepanel').html("中药信息编辑");
    $('#doit').html("确定");
});
$('#chineseMedicineInfoTable').on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});
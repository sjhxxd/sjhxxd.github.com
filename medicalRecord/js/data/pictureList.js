/**
 * Created by sjh on 16/3/8.
 */
//图片信息表
var $table=$("#pictureListTable");
var rowcontent = null;
function initTable(){
    $table.bootstrapTable({
        url:baseAddress+"/picturelist/getall",
        dataType:"json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'pictureLocationId',
            visible: false,
            title: '图片位置ID'
        }, {
            field: 'originalPicturePath',
            title: '原图路径'
        }, {
            field: 'smallPicturePath',
            title: '缩略图路径'
        }, {
            field: 'pictureClass',
            title: '图片类别'
        }, {
            field: 'pictureName',
            title: '图片名'
        }, {
            field: 'pictureTitle',
            title: '图片主题'
        }, {
            field: 'pictureRemarks',
            title: '图片备注'
        }]
    });
}
$("#add").click(function () {
    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
});

//阻止表单提交
$("form").submit(function (e) {
    e.preventDefault();
});
$('#cancel').click(function () {
    turnPage('pictureList.html');
});


$("#edit").click(function(){
    var jsonobject = eval('(' + rowcontent + ')');
    $("#pictureLocationId").val(jsonobject.pictureLocationId);
    $("#originalPicturePath").val(jsonobject.originalPicturePath);
    $("#smallPicturePath").val(jsonobject.smallPicturePath);
    $("#pictureClass").val(jsonobject.pictureClass);
    $("#pictureName").val(jsonobject.pictureName);
    $("#pictureTitle").val(jsonobject.pictureTitle);
    $("#pictureRemarks").val(jsonobject.pictureRemarks);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
    $('#changepanel').html("图片信息编辑");
    $('#doit').html("确定");

});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function(){
    initTable();
    $("#doit").click(
        function(){
            var pictureLocationId=$("#pictureLocationId").val();
            var originalPicturePath=$("#originalPicturePath").val();
            var smallPicturePath=$("#smallPicturePath").val();
            var pictureClass=$("#pictureClass").val();
            var pictureName=$("#pictureName").val();
            var pictureTitle=$("#pictureTitle").val();
            var pictureRemarks=$("#pictureRemarks").val();

            $.ajax({
                url:baseAddress+"/picturelist/saveorupdate",
                type:"post",
                dataType:"text",
                data:{
                    "pictureLocationId":pictureLocationId,
                    "originalPicturePath":originalPicturePath,
                    "smallPicturePath":smallPicturePath,
                    "pictureClass":pictureClass,
                    "pictureName":pictureName,
                    "pictureTitle":pictureTitle,
                    "pictureRemarks":pictureRemarks
                },
                success:function(msg){
                    console.log("pictureList_success:"+msg);
                    turnPage('pictureList.html')
                },
                error:function(msg){
                    alert("pictureList_error:"+msg)

                }

            });
        });
});

$('#remove').click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    //确认是否删除
    if (confirm("是否删除此条信息？")) {
        $.ajax({
            type: 'delete',
            url: baseAddress+"/picturelist/deletebyid/" + jsonobject.pictureLocationId + "/",
            success: function (json) {
                turnPage('pictureList.html');
            }
        })
    }
});
//地理位置信息表
var $table = $("#locationInfoTable");
var rowcontent = null;
function initTable() {
    $table.bootstrapTable({
        url:baseAddress+"/locationinfo/getall",
        dataType:"json",
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

$("#add").click(function () {
    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
});

//阻止表单提交
$("form").submit(function (e) {
    e.preventDefault();
});
$('#cancel').click(function () {
    $('.showpanel').css('display', 'block');
    $('.addpanel').css('display', 'none');
});


$("#edit").click(function(){
    var jsonobject = eval('(' + rowcontent + ')');
    $("#locationInfoId").val(jsonobject.locationInfoId);
    $("#locationLongitude").val(jsonobject.locationLongitude);
    $("#locationLatitude").val(jsonobject.locationLatitude);
    $("#realLocation").val(jsonobject.realLocation);
    $("#locationProvince").val(jsonobject.locationProvince);
    $("#locationCity").val(jsonobject.locationCity);
    $("#locationClassify").val(jsonobject.locationClassify);
    $("#locationCounty").val(jsonobject.locationCounty);
    $("#locationRemarks").val(jsonobject.locationRemarks);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
    $('#changepanel').html("地理位置信息编辑");
    $('#doit').html("确定");

});
$table.on('check.bs.table', function (e, row) {
     rowcontent = JSON.stringify(row);
});

$(function(){
    $("#doit").click(
        function(){
            var locationInfoId=$("#locationInfoId").val();
            var locationLongitude=$("#locationLongitude").val();
            var locationLatitude=$("#locationLatitude").val();
            var realLocation=$("#realLocation").val();
            var locationProvince=$("#locationProvince").val();
            var locationCity=$("#locationCity").val();
            var locationClassify=$("#locationClassify").val();
            var locationCounty=$("#locationCounty").val();
            var locationRemarks=$("#locationRemarks").val();

            $.ajax({
                url:baseAddress+"/locationinfo/saveorupdate",
                type:"post",
                dateType:"json",
                data:{
                    "locationInfoId":locationInfoId,
                    "locationLongitude":locationLongitude,
                    "locationLatitude":locationLatitude,
                    "realLocation":realLocation,
                    "locationProvince":locationProvince,
                    "locationCity":locationCity,
                    "locationClassify":locationClassify,
                    "locationCounty":locationCounty,
                    "locationRemarks":locationRemarks
                },
                success:function(msg){
                    turnPage('location.html');
                    console.log("location_success:"+msg)
                },
                error:function(msg){
                    turnPage('location.html');
                    alert("location_error:"+msg)

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
            url: baseAddress+"/locationinfo/deletebyid/" + jsonobject.locationInfoId + "/",
            success: function (json) {
                turnPage('location.html');
            }
        })
    }
});
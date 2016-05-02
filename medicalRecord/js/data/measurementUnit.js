/**
 * Created by sjh on 16/3/8.
 */
//计量单位表
var $table=$("#measurementUnitTable");
var rowcontent = null;
var tag = null;
function initTable(){
    $table.bootstrapTable({
        url:baseAddress+"/measurementunit/getall",
        dateType:"json",
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

$("#add").click(function () {
    tag = "add";
    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
});

//阻止表单提交
$("form").submit(function (e) {
    e.preventDefault();
});
$('#cancel').click(function () {
    turnPage('measurementUnit.html');
});


$("#edit").click(function(){
    tag="edit";
    var jsonobject = eval('(' + rowcontent + ')');
    $("#unitId").val(jsonobject.unitId);
    $("#unitName").val(jsonobject.unitName);
    $("#hexadecimal").val(jsonobject.hexadecimal);
    $("#unitRemarks").val(jsonobject.unitRemarks);
    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');

    $('#changepanel').html("计量单位编辑");
    $('#doit').html("确定");

});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function(){
    $("#doit").click(
        function(){
            var unitId=$("#unitId").val();
            var unitName=$("#unitName").val();
            var hexadecimal=$("#hexadecimal").val();
            var unitRemarks=$("#unitRemarks").val();

            $.ajax({
                url:baseAddress+"/measurementunit/saveorupdate",
                type:"post",
                dateType:"json",
                data:{
                    "unitId":unitId,
                    "unitName":unitName,
                    "hexadecimal":hexadecimal,
                    "unitRemarks":unitRemarks
                },
                success:function(msg){
                    turnPage('measurementUnit.html');
                    console.log("measurementUnit_success:"+msg)
                },
                error:function(msg){
                    turnPage('measurementUnit.html');
                    alert("measurementUnit_error:"+msg)

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
            url: baseAddress+"/measurementunit/deletebyid/" + jsonobject.unitId + "/",
            success: function (json) {
                turnPage('measurementUnit.html');
            }
        })
    }
});
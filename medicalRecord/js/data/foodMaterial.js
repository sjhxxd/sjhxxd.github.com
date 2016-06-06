/**
 * Created by sjh on 16/2/29.
 */
//中药信息表

var $table = $("#foodMaterialInfoTable");
var rowcontent = null;
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/foodmaterialinfo/getall/",
        dataType: "json",
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
            title: '食性'
        }, {
            field: 'foodMaterialTaste',
            title: '食味'
        }, {
            field: 'foodMaterialContent',
            formatter: value20,
            title: '内容'
        }, {
            field: 'tempPictureLocationId',
            formatter: showPic,
            title: '图片ID'
        }, {
            field: 'foodMaterialRemark',
            formatter: value20,
            title: '备注'
        }, {
            field: 'foodMaterialEffect',
            formatter: value20,
            title: '功效'
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
    turnPage('foodMaterial.html');
});

$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$('#edit').click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行修改操作!");
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');

        $('#foodMaterialId').val(jsonobject.foodMaterialId);
        $('#foodMaterialName').val(jsonobject.foodMaterialName);
        $('#foodMaterialProperty').val(jsonobject.foodMaterialProperty);
        $('#foodMaterialTaste').val(jsonobject.foodMaterialTaste);
        $('#foodMaterialContent').val(jsonobject.foodMaterialContent);
        $('#tempPictureLocationId').val(jsonobject.tempPictureLocationId);
        $('#foodMaterialRemark').val(jsonobject.foodMaterialRemark);
        $('#foodMaterialEffect').val(jsonobject.foodMaterialEffect);

        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
        $('#changepanel').html("中药信息编辑");
        $('#doit').html("确定");
    }
});


$(function () {
    initTable();
    $("#doit").click(
        function () {
            var foodMaterialId = $("#foodMaterialId").val();
            var foodMaterialName = $("#foodMaterialName").val();
            var foodMaterialProperty = $("#foodMaterialProperty").val();
            var foodMaterialTaste = $("#foodMaterialTaste").val();
            var foodMaterialContent = $("#foodMaterialContent").val();
            var tempPictureLocationId = $("#tempPictureLocationId").val();
            var foodMaterialRemark = $("#foodMaterialRemark").val();
            var foodMaterialEffect = $("#foodMaterialEffect").val();

            $.ajax({
                url: baseAddress + "/foodmaterialinfo/saveorupdate",
                type: "post",
                dataType: "text",
                data: {
                    "foodMaterialId": foodMaterialId,
                    "foodMaterialName": foodMaterialName,
                    "foodMaterialProperty": foodMaterialProperty,
                    "foodMaterialTaste": foodMaterialTaste,
                    "foodMaterialContent": foodMaterialContent,
                    "tempPictureLocationId": tempPictureLocationId,
                    "foodMaterialRemark": foodMaterialRemark,
                    "foodMaterialEffect": foodMaterialEffect
                },
                success: function (msg) {
                    turnPage('foodMaterial.html');
                    console.log("foodMaterial_success:" + msg)
                },
                error: function (msg) {
                    turnPage('foodMaterial.html');
                    console.log("foodMaterial_error:" + msg)

                }

            });
        });
});

$('#remove').click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行删除操作!");
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');
        //确认是否删除
        if (confirm("是否删除 " + jsonobject.foodMaterialName + " 这条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/foodmaterialinfo/deletebyid/" + jsonobject.foodMaterialId + "/",
                success: function () {
                    turnPage('foodMaterial.html');
                }
            })
        }
    }
});

//食材图片
jQuery(function ($) {
    var classpic = "食材";
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/picturelist/findbyname?pictureClass=" + classpic,
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].originalPicturePath + " >" + msg[i].pictureName + "</option>";
            }
            $("#tempPictureLocationId").append(str);
        }
    })
});
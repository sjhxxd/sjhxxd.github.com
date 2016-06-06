/**
 * Created by sjh on 16/2/29.
 */
//中药信息表
//var zishulimit=function (data, type) {     //字数超过20,只显示20字
//    return type === 'display' && data.length > 21 ?
//    '<span title="' + data + '">' + data.substr(0, 20) + '...</span>' :
//        data;
//}

var $table = $("#chineseMedicineInfoTable");
var rowcontent = null;


function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/chinesemedicineinfo/getall/",
        dataType: "json",
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
            formatter: value20,
            title: '功能主治'
        }, {
            field: 'clinicalApplication',
            formatter: value20,
            title: '临床应用'
        }, {
            field: 'tempPictureLocationId',
            formatter:showPic,
            title: '图片ID'
        }, {
            field: 'chineseMedicineRemark',
            formatter: value20,
            title: '中药备注'
        }, {
            field: 'anotherName',
            title: '别名'
        }, {
            field: 'producingArea',
            title: '产地'
        }, {
            field: 'commonUsedPrescription',
            title: '常用方'
        }, {
            field: 'machiningProcessing',
            formatter: value20,
            title: '加工炮制'
        }, {
            field: 'usePrecaution',
            formatter: value20,
            title: '使用注意'
        }]

        //data:[{
        //    chineseMedicineId:1,
        //    medicineName:"施嘉豪"
        //}]

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
    turnPage('chineseMedicine.html');
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
        $('#chineseMedicineId').val(jsonobject.chineseMedicineId);
        $('#medicineName').val(jsonobject.medicineName);
        $('#medicineProperty').val(jsonobject.medicineProperty);
        $('#medicineTaste').val(jsonobject.medicineTaste);
        $('#effectType').val(jsonobject.effectType);
        $('#medicineGrade').val(jsonobject.medicineGrade);
        $('#channelTropism').val(jsonobject.channelTropism);
        $('#indicationsFunction').val(jsonobject.indicationsFunction);
        $('#clinicalApplication').val(jsonobject.clinicalApplication);
        $('#tempPictureLocationId').val(jsonobject.tempPictureLocationId);
        $('#chineseMedicineRemark').val(jsonobject.chineseMedicineRemark);
        $('#anotherName').val(jsonobject.anotherName);
        $('#producingArea').val(jsonobject.producingArea);
        $('#commonUsedPrescription').val(jsonobject.commonUsedPrescription);
        $('#machiningProcessing').val(jsonobject.machiningProcessing);
        $('#usePrecaution').val(jsonobject.usePrecaution);

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
            var chineseMedicineId = $("#chineseMedicineId").val();
            var medicineName = $("#medicineName").val();
            var medicineProperty = $("#medicineProperty").val();
            var medicineTaste = $("#medicineTaste").val();
            var effectType = $("#effectType").val();
            var medicineGrade = $("#medicineGrade").val();
            var channelTropism = $("#channelTropism").val();
            var indicationsFunction = $("#indicationsFunction").val();
            var clinicalApplication = $("#clinicalApplication").val();
            var tempPictureLocationId = $("#tempPictureLocationId").val();
            var chineseMedicineRemark = $("#chineseMedicineRemark").val();
            var anotherName = $("#anotherName").val();
            var producingArea = $("#producingArea").val();
            var commonUsedPrescription = $("#commonUsedPrescription").val();
            var machiningProcessing = $("#machiningProcessing").val();
            var usePrecaution = $("#usePrecaution").val();

            $.ajax({
                url: baseAddress + "/chinesemedicineinfo/saveorupdate",
                type: "post",
                dataType: "text",
                data: {
                    "chineseMedicineId": chineseMedicineId,
                    "medicineName": medicineName,
                    "medicineProperty": medicineProperty,
                    "medicineTaste": medicineTaste,
                    "effectType": effectType,
                    "medicineGrade": medicineGrade,
                    "channelTropism": channelTropism,
                    "indicationsFunction": indicationsFunction,
                    "clinicalApplication": clinicalApplication,
                    "tempPictureLocationId": tempPictureLocationId,
                    "chineseMedicineRemark": chineseMedicineRemark,
                    "anotherName": anotherName,
                    "producingArea": producingArea,
                    "commonUsedPrescription": commonUsedPrescription,
                    "machiningProcessing": machiningProcessing,
                    "usePrecaution": usePrecaution
                },
                success: function (msg) {
                    turnPage('chineseMedicine.html');
                    console.log("chineseMedicine_success:" + msg)
                },
                error: function (msg) {
                    alert("chineseMedicine_error:" + msg)
                }
            });
        });
});

$('#remove').click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行删除操作!!")
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');
        //确认是否删除
        if (confirm("是否删除 " + jsonobject.medicineName + " 这条药材信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/chinesemedicineinfo/deletebyid/" + jsonobject.chineseMedicineId + "/",
                success: function () {
                    turnPage('chineseMedicine.html');
                }
            })
        }
    }
});

//中药图片
jQuery(function ($) {
    var classpic = "中药";
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/picturelist/findbyname?pictureClass="+classpic,
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].originalPicturePath + " >" + msg[i].pictureName + "</option>";
            }
            $("#tempPictureLocationId").append(str);
        }
    })
});
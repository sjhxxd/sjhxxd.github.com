//常见疾病信息
var $table = $("#commonDiseaseInfoTable");
var rowcontent = null;
var tag = null;

function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/commondiseaseinfo/getall",
        dateType: "json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'commonDiseaseId',
            visible: false,
            title: '常见疾病ID'
        }, {
            field: 'tempCommonDiseaseTypeId',
            title: '常见疾病类别ID'
        }, {
            field: 'commonDiseaseName',
            title: '常见疾病名称'
        }, {
            field: 'commonDiseaseExplain',
            title: '常见疾病说明'
        }]
    })
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
    $('.showpanel').css('display', 'block');
    $('.addpanel').css('display', 'none');
});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$("#edit").click(function () {
    tag = "edit";
    var jsonobject = eval('(' + rowcontent + ')');
    $("#commonDiseaseId").val(jsonobject.commonDiseaseId);
    $("#tempCommonDiseaseTypeId").val(jsonobject.tempCommonDiseaseTypeId);
    $("#commonDiseaseName").val(jsonobject.commonDiseaseName);
    $("#commonDiseaseExplain").val(jsonobject.commonDiseaseExplain);


    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');

    $('#changepanel').html("疾病类别信息编辑");
    $('#doit').html("确定");

});

$(function () {
    $("#doit").click(
        function () {
            var commonDiseaseId = $("#commonDiseaseId").val();
            var tempCommonDiseaseTypeId = $("#tempCommonDiseaseTypeId").val();
            var commonDiseaseName = $("#commonDiseaseName").val();
            var commonDiseaseExplain = $("#commonDiseaseExplain").val();
            $.ajax({
                url: baseAddress + "/commondiseaseinfo/saveorupdate",
                type: "post",
                dateType: "json",
                data: {
                    "commonDiseaseId": commonDiseaseId,
                    "tempCommonDiseaseTypeId": tempCommonDiseaseTypeId,
                    "commonDiseaseName": commonDiseaseName,
                    "commonDiseaseExplain": commonDiseaseExplain
                },
                success: function (msg) {
                    turnPage('commondiseaseinfo.html');
                    console.log("commondiseaseinfo_success:" + msg)
                },
                error: function (msg) {
                    turnPage('commondiseaseinfo.html');
                    console.log("commondiseaseinfo_error:" + msg)

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
            url: baseAddress + "/commondiseaseinfo/deletebyid/" + jsonobject.commonDiseaseId + "/",
            success: function (json) {
                turnPage('commondiseaseinfo.html');
            }
        })
    }
});

jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/commondiseasetype/getall",
        success: function (msg) {
            var str = "";
            for (i in msg) {
                str += "<option value =" + msg[i].commonDiseaseTypeId + " >" + msg[i].commonDiseaseTypeName + "</option>";
            }
            $("#tempCommonDiseaseTypeId").append(str);
        }

    })
});
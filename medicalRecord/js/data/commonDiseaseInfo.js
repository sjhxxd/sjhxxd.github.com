//常见疾病信息
var $table = $("#commonDiseaseInfoTable");
var rowcontent = null;
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/commondiseaseinfo/getall",
        dataType: "json",
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
            field: 'commonDiseaseCode',
            title: '常见疾病代码'
        }, {
            field: 'commonDiseaseExplain',
            formatter: value20,
            title: '常见疾病说明'
        }, {
            field: 'patientNumber',
            title: '病人人数'
        }]
    })
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
    turnPage('commondiseaseinfo.html');
});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$("#edit").click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行修改操作!");
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');
        //疾病类别修改
        $.ajax({
            async: true,
            type: "get",
            dataType: "json",
            url: baseAddress + "/commondiseasetype/findbyname/?commonDiseaseTypeName=" + jsonobject.tempCommonDiseaseTypeId.toString(),
            success: function (msg) {
                var CommonDiseaseTypeId = msg.commonDiseaseTypeId;
                $('#tempCommonDiseaseTypeId').val(CommonDiseaseTypeId);
            }
        });
        $("#commonDiseaseId").val(jsonobject.commonDiseaseId);
        $("#commonDiseaseName").val(jsonobject.commonDiseaseName);
        $("#commonDiseaseCode").val(jsonobject.commonDiseaseCode);
        $("#commonDiseaseExplain").val(jsonobject.commonDiseaseExplain);
        $("#patientNumber").val(jsonobject.patientNumber);

        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
        $('#changepanel').html("疾病信息编辑");
        $('#doit').html("确定");
    }
});

$(function () {
    $("#doit").click(
        function () {
            var commonDiseaseId = $("#commonDiseaseId").val();
            var tempCommonDiseaseTypeId = $("#tempCommonDiseaseTypeId").val();
            var commonDiseaseName = $("#commonDiseaseName").val();
            var commonDiseaseCode = $("#commonDiseaseCode").val();
            var commonDiseaseExplain = $("#commonDiseaseExplain").val();
            var patientNumber = $("#patientNumber").val();
            $.ajax({
                url: baseAddress + "/commondiseaseinfo/saveorupdate",
                type: "post",
                dataType: "text",
                data: {
                    "commonDiseaseId": commonDiseaseId,
                    "tempCommonDiseaseTypeId": tempCommonDiseaseTypeId,
                    "commonDiseaseName": commonDiseaseName,
                    "commonDiseaseCode": commonDiseaseCode,
                    "commonDiseaseExplain": commonDiseaseExplain,
                    "patientNumber": patientNumber
                },
                success: function (msg) {
                    turnPage('commondiseaseinfo.html');
                    console.log("commondiseaseinfo_success:" + msg)
                },
                error: function (msg) {
                    console.log("commondiseaseinfo_error:" + msg)
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
        if (confirm("是否删除 " + jsonobject.commonDiseaseName + " 这条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/commondiseaseinfo/deletebyid/" + jsonobject.commonDiseaseId + "/",
                success: function (json) {
                    turnPage('commondiseaseinfo.html');
                }
            })
        }
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

$(document).ready(function () {
    $('#commonDiseaseInfoform').bootstrapValidator({
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },

        fields: {
            patientNumber: {
                validators: {

                    regexp: {
                        regexp: /^[0-9]*$/,
                        message: '请输入正整数'
                    }
                }
            },
            val1024: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    stringLength: {
                        max: 1024,
                        message: '请输入不超过1024个字符的内容'
                    }
                }
            }
        }
    });

});
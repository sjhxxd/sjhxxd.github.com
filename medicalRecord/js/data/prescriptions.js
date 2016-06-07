/**
 * Created by sjh on 16/3/8.
 */
//方剂信息表
var $table = $("#prescriptionsInfoTable");
var rowcontent = null;
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/presctiptionsinfo/getall",
        dataType: "json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'prescriptionId',
            visible: false,
            title: '中药方剂ID'
        }, {
            field: 'prescriptionName',
            title: '方剂名称'
        }, {
            field: 'prescriptionOrigin',
            formatter: function(value){
                return "《"+value+"》"
            },
            title: '出处'
        }, {
            field: 'prescriptionEffect',
            formatter: value20,
            title: '功效'
        }, {
            field: 'prescriptionClass',
            title: '剂型'
        }, {
            field: 'prescriptionFunction',
            formatter: value20,
            title: '功能主治'
        }, {
            field: 'prescriptionSummary',
            formatter: value20,
            title: '概述'
        }, {
            field: 'prescriptionInstructions',
            formatter: value20,
            title: '用法说明'
        }, {
            field: 'prescriptionRemark',
            formatter: value20,
            title: '备注'
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


$("#edit").click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行修改操作!");
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');
        $("#prescriptionId").val(jsonobject.prescriptionId);
        $("#prescriptionName").val(jsonobject.prescriptionName);
        $("#prescriptionOrigin").val(jsonobject.prescriptionOrigin);
        $("#prescriptionEffect").val(jsonobject.prescriptionEffect);
        $("#prescriptionClass").val(jsonobject.prescriptionClass);
        $("#prescriptionFunction").val(jsonobject.prescriptionFunction);
        $("#prescriptionSummary").val(jsonobject.prescriptionSummary);
        $("#prescriptionInstructions").val(jsonobject.prescriptionInstructions);
        $("#prescriptionRemark").val(jsonobject.prescriptionRemark);

        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
        $('#changepanel').html("中药方剂信息编辑");
        $('#doit').html("确定");
    }
});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function () {
    $("#doit").click(
        function () {
            var prescriptionId = $("#prescriptionId").val();
            var prescriptionName = $("#prescriptionName").val();
            var prescriptionOrigin = $("#prescriptionOrigin").val();
            var prescriptionEffect = $("#prescriptionEffect").val();
            var prescriptionClass = $("#prescriptionClass").val();
            var prescriptionFunction = $("#prescriptionFunction").val();
            var prescriptionSummary = $("#prescriptionSummary").val();
            var prescriptionInstructions = $("#prescriptionInstructions").val();
            var prescriptionRemark = $("#prescriptionRemark").val();

            $.ajax({
                url: baseAddress + "/presctiptionsinfo/saveorupdate",
                type: "post",
                dataType: "text",
                data: {
                    "prescriptionId": prescriptionId,
                    "prescriptionName": prescriptionName,
                    "prescriptionOrigin": prescriptionOrigin,
                    "prescriptionEffect": prescriptionEffect,
                    "prescriptionClass": prescriptionClass,
                    "prescriptionFunction": prescriptionFunction,
                    "prescriptionSummary": prescriptionSummary,
                    "prescriptionInstructions": prescriptionInstructions,
                    "prescriptionRemark": prescriptionRemark
                },
                success: function (msg) {
                    console.log("presctiptions_success:" + msg);
                    turnPage('prescriptions.html')
                },
                error: function (msg) {
                    console.log("presctiptions_error:" + msg)
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
        if (confirm("是否删除 " + jsonobject.prescriptionName + " 此条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/presctiptionsinfo/deletebyid/" + jsonobject.prescriptionId + "/",
                success: function () {
                    turnPage('prescriptions.html');
                }
            })
        }
    }
});

$(document).ready(function () {
    $('#prescriptionsform').bootstrapValidator({
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },

        fields: {
            val200: {
                validators: {
                    notEmpty: {
                        message: '不能为空'
                    },
                    stringLength: {
                        max: 200,
                        message: '请输入不超过200个字符的内容'
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
/**
 * Created by sjh on 16/3/8.
 */
//方剂信息表
var $table=$("#prescriptionsInfoTable");
var rowcontent = null;
function initTable(){
    $table.bootstrapTable({
        url:baseAddress+"/presctiptionsinfo/getall",
        dataType:"json",
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
            title: '出处'
        }, {
            field: 'prescriptionEffect',
            title: '功效'
        }, {
            field: 'prescriptionClass',
            title: '剂型'
        }, {
            field: 'prescriptionFunction',
            title: '功能主治'
        }, {
            field: 'prescriptionSummary',
            title: '概述'
        }, {
            field: 'prescriptionInstruction',
            title: '用法说明'
        }, {
            field: 'prescriptionRemark',
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


$("#edit").click(function(){
    var jsonobject = eval('(' + rowcontent + ')');
    $("#prescriptionId").val(jsonobject.prescriptionId);
    $("#prescriptionName").val(jsonobject.prescriptionName);
    $("#prescriptionOrigin").val(jsonobject.prescriptionOrigin);
    $("#prescriptionEffect").val(jsonobject.prescriptionEffect);
    $("#prescriptionClass").val(jsonobject.prescriptionClass);
    $("#prescriptionFunction").val(jsonobject.prescriptionFunction);
    $("#prescriptionSummary").val(jsonobject.prescriptionSummary);
    $("#prescriptionInstruction").val(jsonobject.prescriptionInstruction);
    $("#prescriptionRemark").val(jsonobject.prescriptionRemark);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
    $('#changepanel').html("中药方剂信息编辑");
    $('#doit').html("确定");

});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function(){
    $("#doit").click(
        function(){
            var prescriptionId=$("#prescriptionId").val();
            var prescriptionName=$("#prescriptionName").val();
            var prescriptionOrigin=$("#prescriptionOrigin").val();
            var prescriptionEffect=$("#prescriptionEffect").val();
            var prescriptionClass=$("#prescriptionClass").val();
            var prescriptionFunction=$("#prescriptionFunction").val();
            var prescriptionSummary=$("#prescriptionSummary").val();
            var prescriptionInstruction=$("#prescriptionInstruction").val();
            var prescriptionRemark=$("#prescriptionRemark").val();

            $.ajax({
                url:baseAddress+"/presctiptionsinfo/saveorupdate",
                type:"post",
                dataType:"text",
                data:{
                    "prescriptionId":prescriptionId,
                    "prescriptionName":prescriptionName,
                    "prescriptionOrigin":prescriptionOrigin,
                    "prescriptionEffect":prescriptionEffect,
                    "prescriptionClass":prescriptionClass,
                    "prescriptionFunction":prescriptionFunction,
                    "prescriptionSummary":prescriptionSummary,
                    "prescriptionInstruction":prescriptionInstruction,
                    "prescriptionRemark":prescriptionRemark
                },
                success:function(msg){
                    console.log("presctiptions_success:"+msg);
                    turnPage('prescriptions.html')
                },
                error:function(msg){
                    console.log("presctiptions_error:"+msg)
                }

            });
        });
});

$('#remove').click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    if (confirm("是否删除此条信息？")) {
        $.ajax({
            type: 'delete',
            url: baseAddress+"/presctiptionsinfo/deletebyid/" + jsonobject.prescriptionId + "/",
            success: function () {
                turnPage('prescriptions.html');
            }
        })
    }
});
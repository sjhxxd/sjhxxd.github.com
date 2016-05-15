/**
 * Created by sjh on 16/3/8.
 */
    //中成药信息表
var $table=$("#patentMedicineInfoTable");
var rowcontent = null;
function initTable(){
    $table.bootstrapTable({
        url:baseAddress+"/patentmedicineinfo/getall",
        dataType:"json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'patentMedicineId',
            visible: false,
            title: '中成药ID'
        }, {
            field: 'patentMedicineName',
            title: '中成药名称'
        }, {
            field: 'patentMedicineContent',
            title: '中成药内容'
        }, {
            field: 'indicationsFunction',
            title: '功能主治'
        }, {
            field: 'shape',
            title: '性状'
        }, {
            field: 'usageDosage',
            title: '用法与用量'
        }, {
            field: 'attention',
            title: '注意'
        }, {
            field: 'specifications',
            title: '规格'
        }, {
            field: 'storageMethod',
            title: '贮藏方式'
        }, {
            field: 'saute',
            title: '制法'
        }, {
            field: 'patentMedicineRemark',
            title: '备注'
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
    turnPage('patentMedicine.html');
});


$("#edit").click(function(){
    var jsonobject = eval('(' + rowcontent + ')');
    $("#patentMedicineId").val(jsonobject.patentMedicineId);
    $("#patentMedicineName").val(jsonobject.patentMedicineName);
    $("#patentMedicineContent").val(jsonobject.patentMedicineContent);
    $("#indicationsFunction").val(jsonobject.indicationsFunction);
    $("#shape").val(jsonobject.shape);
    $("#usageDosage").val(jsonobject.usageDosage);
    $("#attention").val(jsonobject.attention);
    $("#specifications").val(jsonobject.specifications);
    $("#storageMethod").val(jsonobject.storageMethod);
    $("#saute").val(jsonobject.saute);
    $("#patentMedicineRemark").val(jsonobject.patentMedicineRemark);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
    $('#changepanel').html("中成药信息编辑");
    $('#doit').html("确定");

});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function(){
    initTable();
    $("#doit").click(
        function(){
            var patentMedicineId=$("#patentMedicineId").val();
            var patentMedicineName=$("#patentMedicineName").val();
            var patentMedicineContent=$("#patentMedicineContent").val();
            var indicationsFunction=$("#indicationsFunction").val();
            var shape=$("#shape").val();
            var usageDosage=$("#usageDosage").val();
            var attention=$("#attention").val();
            var specifications=$("#specifications").val();
            var storageMethod=$("#storageMethod").val();
            var saute=$("#saute").val();
            var patentMedicineRemark=$("#patentMedicineRemark").val();

            $.ajax({
                url:baseAddress+"/patentmedicineinfo/saveorupdate",
                type:"post",
                dataType:"text",
                data:{
                    "patentMedicineId":patentMedicineId,
                    "patentMedicineName":patentMedicineName,
                    "patentMedicineContent":patentMedicineContent,
                    "indicationsFunction":indicationsFunction,
                    "shape":shape,
                    "usageDosage":usageDosage,
                    "attention":attention,
                    "specifications":specifications,
                    "storageMethod":storageMethod,
                    "saute":saute,
                    "patentMedicineRemark":patentMedicineRemark
                },
                success:function(msg){
                    console.log("patentMedicine_success:"+msg);
                    turnPage('patentMedicine.html')
                },
                error:function(msg){
                    console.log("patentMedicine_error:"+msg)
                }

            });
        });
});

$('#remove').click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    if (confirm("是否删除此条信息？")) {
        $.ajax({
            type: 'delete',
            url: baseAddress+"/patentmedicineinfo/deletebyid/" + jsonobject.patentMedicineId + "/",
            success: function () {
                turnPage('patentMedicine.html');
            }
        })
    }
});
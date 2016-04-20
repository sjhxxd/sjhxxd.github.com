
//常见疾病类别表
var $table = $("#commonDiseaseTypeTable");
var rowcontent = null;
var tag = null;
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/commondiseasetype/getall",
        dateType:"json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'commonDiseaseTypeId',
            visible: false,
            title: '常见疾病类别ID'
        }, {
            field: 'commonDiseaseTypeName',
            title: '常见疾病类别名'
        }, {
            field: 'commonDiseaseTypeCode',
            title: '常见疾病代码'
        }, {
            field: 'commonDiseaseTypeExplain',
            title: '常见疾病类别说明'
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

$("#edit").click(function(){
    tag="edit";
    var jsonobject = eval('(' + rowcontent + ')');
    $("#commonDiseaseTypeId").val(jsonobject.commonDiseaseTypeId);
    $("#commonDiseaseTypeName").val(jsonobject.commonDiseaseTypeName);
    $("#commonDiseaseTypeCode").val(jsonobject.commonDiseaseTypeCode);
    $("#commonDiseaseTypeExplain").val(jsonobject.commonDiseaseTypeExplain);



    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');

    $('#changepanel').html("疾病类别信息编辑");
    $('#doit').html("确定");

});

$(function(){
    $("#doit").click(
        function(){
            var commonDiseaseTypeId=$("#commonDiseaseTypeId").val();
            var commonDiseaseTypeName=$("#commonDiseaseTypeName").val();
            var commonDiseaseTypeCode=$("#commonDiseaseTypeCode").val();
            var commonDiseaseTypeExplain=$("#commonDiseaseTypeExplain").val();
            $.ajax({
                url:baseAddress+"/commondiseasetype/saveorupdate",
                type:"post",
                dateType:"json",
                data:{
                    "commonDiseaseTypeId":commonDiseaseTypeId,
                    "commonDiseaseTypeName":commonDiseaseTypeName,
                    "commonDiseaseTypeCode":commonDiseaseTypeCode,
                    "commonDiseaseTypeExplain":commonDiseaseTypeExplain
                },
                success:function(msg){
                    turnPage('commonDiseaseType.html');
                    console.log("commonDiseaseType_success:"+msg)
                },
                error:function(msg){
                    turnPage('commonDiseaseType.html');
                    console.log("commonDiseaseType_error:"+msg)

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
            url: baseAddress+"/commondiseasetype/deletebyid/" + jsonobject.commonDiseaseTypeId + "/",
            success: function (json) {
                turnPage('commonDiseaseType.html');
            }
        })
    }
});
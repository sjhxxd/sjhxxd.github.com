//常见疾病类别表
var $table = $("#commonDiseaseTypeTable");
var rowcontent = null;
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/commondiseasetype/getall",
        dateType: "json",
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
            formatter: value20,
            title: '常见疾病类别说明'
        }]
    })
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
    turnPage('commonDiseaseType.html');
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
        $("#commonDiseaseTypeId").val(jsonobject.commonDiseaseTypeId);
        $("#commonDiseaseTypeName").val(jsonobject.commonDiseaseTypeName);
        $("#commonDiseaseTypeCode").val(jsonobject.commonDiseaseTypeCode);
        $("#commonDiseaseTypeExplain").val(jsonobject.commonDiseaseTypeExplain);

        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
        $('#changepanel').html("疾病类别信息编辑");
        $('#doit').html("确定");
    }
});

$(function () {
    initTable();
    $("#doit").click(
        function () {
            var commonDiseaseTypeId = $("#commonDiseaseTypeId").val();
            var commonDiseaseTypeName = $("#commonDiseaseTypeName").val();
            var commonDiseaseTypeCode = $("#commonDiseaseTypeCode").val();
            var commonDiseaseTypeExplain = $("#commonDiseaseTypeExplain").val();
            $.ajax({
                url: baseAddress + "/commondiseasetype/saveorupdate",
                type: "post",
                dataType: "text",
                data: {
                    "commonDiseaseTypeId": commonDiseaseTypeId,
                    "commonDiseaseTypeName": commonDiseaseTypeName,
                    "commonDiseaseTypeCode": commonDiseaseTypeCode,
                    "commonDiseaseTypeExplain": commonDiseaseTypeExplain
                },
                success: function (msg) {
                    turnPage('commonDiseaseType.html');
                    console.log("commonDiseaseType_success:" + msg)
                },
                error: function (msg) {
                    console.log("commonDiseaseType_error:" + msg)
                }
            });
        });
});

$('#remove').click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行修改操作!");
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');
        //确认是否删除
        if (confirm("是否删除 " + jsonobject.commonDiseaseTypeName + " 这条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/commondiseasetype/deletebyid/" + jsonobject.commonDiseaseTypeId + "/",
                success: function (json) {
                    turnPage('commonDiseaseType.html');
                }
            })
        }
    }
});
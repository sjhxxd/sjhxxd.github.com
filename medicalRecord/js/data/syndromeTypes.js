//证型信息表
var $table=$("#syndromeTypesTable");
var rowcontent = null;
function initTable(){
    $table.bootstrapTable({
        url:baseAddress+"/syndrometypes/getall",
        dataType:"json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'syndromeId',
            visible: false,
            title: '证型ID'
        }, {
            field: 'syndromeSystemType',
            title: '证型系别'
        }, {
            field: 'syndromeLevelType',
            title: '证型类别'
        }, {
            field: 'syndromeName',
            title: '证型名'
        }, {
            field: 'syndromeRemark',
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
    turnPage('syndromeTypes.html');
});

$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$("#edit").click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    $("#syndromeId").val(jsonobject.syndromeId);
    $("#syndromeSystemType").val(jsonobject.syndromeSystemType);
    $("#syndromeLevelType").val(jsonobject.syndromeLevelType);
    $("#syndromeName").val(jsonobject.syndromeName);
    $("#syndromeRemark").val(jsonobject.syndromeRemark);



    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');

    $('#changepanel').html("证型信息编辑");
    $('#doit').html("确定");

});

$(function () {
    $("#doit").click(
        function () {
            var syndromeId = $("#syndromeId").val();
            var syndromeSystemType = $("#syndromeSystemType").val();
            var syndromeLevelType = $("#syndromeLevelType").val();
            var syndromeName = $("#syndromeName").val();
            var syndromeRemark = $("#syndromeRemark").val();
            $.ajax({
                url: baseAddress + "/syndrometypes/saveorupdate",
                type: "post",
                dataType: "text",
                data: {
                    "syndromeId": syndromeId,
                    "syndromeSystemType": syndromeSystemType,
                    "syndromeLevelType": syndromeLevelType,
                    "syndromeName": syndromeName,
                    "syndromeRemark": syndromeRemark
                },
                success: function (msg) {
                    console.log("syndromeTypes_success:" + msg);
                    turnPage('syndromeTypes.html')
                },
                error: function (msg) {
                    alert("syndromeTypes_error:" + msg)
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
            url: baseAddress + "/syndrometypes/deletebyid/" + jsonobject.syndromeId + "/",
            success: function (json) {
                turnPage('syndromeTypes.html');
            }
        })
    }
});
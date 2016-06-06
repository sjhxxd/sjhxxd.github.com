/**
 * Created by sjh on 16/3/8.
 */
//笔记表
var $table = $("#noteTable");
function initTable() {
    $table.bootstrapTable({
        url: baseAddress+"/note/getall",
        dataType: "json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'myNoteId',
            visible: false,
            title: '笔记ID'
        }, {
            field: 'tempDoctorId',
            visible: false,
            title: '医生ID'
        }, {
            field: 'tempNoteTypeId',
            title: '笔记类别'
        }, {
            field: 'noteDate',
            title: '笔记时间'
        }, {
            field: 'noteContent',
            formatter: value20,
            title: '笔记内容'
        }, {
            field: 'noteRemark',
            formatter: value20,
            title: '笔记备注'
        }, {
            field: 'tempChineseMedicineId',
            title: '中药ID'
        }, {
            field: 'tempFoodMaterialId',
            title: '食材ID'
        }, {
            field: 'tempPatentMedicineId',
            title: '中成药ID'
        }, {
            field: 'tempPrescriptionId',
            title: '方剂ID'
        }]

    });
}

$("#noteDate").datetimepicker({
    format: 'yyyy-mm-dd',
    autoclose: true
});

$("#add").click(function () {
    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
});

//阻止表单提交
$("form").submit(function (e) {
    e.preventDefault();
});
$('#cancel').click(function () {
    turnPage('note.html');
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
        $("#myNoteId").val(jsonobject.myNoteId);
        $("#tempDoctorId").val(jsonobject.tempDoctorId);
        $("#tempNoteTypeId").val(jsonobject.tempNoteTypeId);
        $("#noteDate").val(jsonobject.noteDate);
        $("#noteContent").val(jsonobject.noteContent);
        $("#noteRemark").val(jsonobject.noteRemark);
        $("#tempChineseMedicineId").val(jsonobject.tempChineseMedicineId);
        $("#tempFoodMaterialId").val(jsonobject.tempFoodMaterialId);
        $("#tempPatentMedicineId").val(jsonobject.tempPatentMedicineId);
        $("#tempPrescriptionId").val(jsonobject.tempPrescriptionId);

        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
        $('#changepanel').html("图片信息编辑");
        $('#doit').html("确定");
    }
});
$(function () {
    initTable();
    $("#doit").click(
        function () {
            var myNoteId = $("#myNoteId").val();
            var tempDoctorId = $("#tempDoctorId").val();
            var tempNoteTypeId = $("#tempNoteTypeId").val();
            var noteDate = $("#noteDate").val();
            var noteContent = $("#noteContent").val();
            var noteRemark = $("#noteRemark").val();
            var tempChineseMedicineId = $("#tempChineseMedicineId").val();
            var tempFoodMaterialId = $("#tempFoodMaterialId").val();
            var tempPatentMedicineId = $("#tempPatentMedicineId").val();
            var tempPrescriptionId = $("#tempPrescriptionId").val();

            $.ajax({
                url: baseAddress + "/note/saveorupdate",
                type: "post",
                dataType: "text",
                data: {
                    "myNoteId": myNoteId,
                    "tempDoctorId": tempDoctorId,
                    "tempNoteTypeId": tempNoteTypeId,
                    "noteDate": noteDate,
                    "noteContent": noteContent,
                    "noteRemark": noteRemark,
                    "tempChineseMedicineId": tempChineseMedicineId,
                    "tempFoodMaterialId": tempFoodMaterialId,
                    "tempPatentMedicineId": tempPatentMedicineId,
                    "tempPrescriptionId": tempPrescriptionId
                },
                success: function (msg) {
                    console.log("note_success:" + msg);
                    turnPage('note.html')
                },
                error: function (msg) {
                    console.log("note_error:" + msg)

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
        if (confirm("是否删除这条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/note/deletebyid/" + jsonobject.myNoteId + "/",
                success: function () {
                    turnPage('note.html');
                }
            })
        }
    }
});

//医生
jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/doctorinfo/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].doctorId + " >" + msg[i].doctorName + "</option>";
            }
            $("#tempDoctorId").append(str);
        }
    })
});

//中药
jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/chinesemedicineinfo/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].chineseMedicineId + " >" + msg[i].medicineName + "</option>";
            }
            $("#tempChineseMedicineId").append(str);
        }
    })
});

//食材
jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/foodmaterialinfo/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].foodMaterialId + " >" + msg[i].foodMaterialName + "</option>";
            }
            $("#tempFoodMaterialId").append(str);
        }
    })
});

//中成药
jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/patentmedicineinfo/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].patentMedicineId + " >" + msg[i].patentMedicineName + "</option>";
            }
            $("#tempPatentMedicineId").append(str);
        }
    })
});

//方剂
jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/presctiptionsinfo/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].prescriptionId + " >" + msg[i].prescriptionName + "</option>";
            }
            $("#tempFoodMaterialId").append(str);
        }
    })
});
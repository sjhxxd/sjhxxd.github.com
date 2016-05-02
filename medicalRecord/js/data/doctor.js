//医生信息表
var $table = $("#doctorInfoTable");
var rowcontent = null;

function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/doctorinfo/getall",
        dataType: "json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'doctorId',
            visible: false,
            title: '医生ID'
        }, {
            field: 'doctorName',
            title: '医生姓名'
        }, {
            field: 'doctorSex',
            title: '医生性别'
        }, {
            field: 'doctorAge',
            title: '医生年龄'
        }, {
            field: 'doctorPhoneNumber',
            title: '手机号码'
        }, {
            field: 'doctorUnitName',
            title: '所在单位'
        }, {
            field: 'doctorDepartmentName',
            title: '所在科室'
        }, {
            field: 'doctorIdentity',
            title: '登录身份'
        }, {
            field: 'doctorPassword',
            title: '登录密码'
        }, {
            field: 'doctorAddress',
            title: '所在地区'
        }, {
            field: 'checkState',
            title: '审核状态'
        }, {
            field: 'doctorRemark',
            title: '备注'
        }, {
            field: 'doctorWechat',
            title: '微信'
        }, {
            field: 'doctorIntroduction',
            title: '自我介绍'
        }, {
            field: 'tempPictureLocationId',
            title: '图片ID'
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
    turnPage('doctor.html');
});


$("#edit").click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    $("#doctorId").val(jsonobject.doctorId);
    $("#doctorName").val(jsonobject.doctorName);
    if (jsonobject.doctorSex.toString() == "男") {
        $("#male").attr("checked", "true")
    } else {
        $("#female").attr("checked", "true")
    }
    $("#doctorAge").val(jsonobject.doctorAge);
    $("#doctorPhoneNumber").val(jsonobject.doctorPhoneNumber);
    $("#doctorUnitName").val(jsonobject.doctorUnitName);
    $("#doctorDepartmentName").val(jsonobject.doctorDepartmentName);
    $("#doctorIdentity").val(jsonobject.doctorIdentity);
    $("#doctorPassword").val(jsonobject.doctorPassword);
    $("#doctorAddress").val(jsonobject.doctorAddress);
    $("#checkState").val(jsonobject.checkState);
    $("#doctorRemark").val(jsonobject.doctorRemark);
    $("#doctorWechat").val(jsonobject.doctorWechat);
    $("#doctorIntroduction").val(jsonobject.doctorIntroduction);
    $("#tempPictureLocationId").val(jsonobject.tempPictureLocationId);
    console.log("doctorEntity--->", jsonobject);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');

    $('#changepanel').html("医生信息编辑");
    $('#doit').html("确定");

});
$table.on('check.bs.table', function (e, row) {
    rowcontent = JSON.stringify(row);
});

$(function () {
    initTable();

    $("#doit").click(
        function () {
            var doctorId = $("#doctorId").val();
            var doctorName = $("#doctorName").val();
            var doctorSex = $("#doctorSex").val();
            var doctorAge = $("#doctorAge").val();
            var doctorPhoneNumber = $("#doctorPhoneNumber").val();
            var doctorUnitName = $("#doctorUnitName").val();
            var doctorDepartmentName = $("#doctorDepartmentName").val();
            var doctorIdentity = $("#doctorIdentity").val();
            var doctorPassword = $("#doctorPassword").val();
            var doctorAddress = $("#doctorAddress").val();
            var checkState = $("#checkState").val();
            var doctorRemark = $("#doctorRemark").val();
            var doctorWechat = $("#doctorWechat").val();
            var doctorIntroduction = $("#doctorIntroduction").val();
            var tempPictureLocationId = $("#tempPictureLocationId").val();

            $.ajax({
                url: baseAddress + "/doctorinfo/saveorupdate",
                type: "post",
                dateType: "json",
                data: {
                    "doctorId": doctorId,
                    "doctorName": doctorName,
                    "doctorSex": doctorSex,
                    "doctorAge": doctorAge,
                    "doctorPhoneNumber": doctorPhoneNumber,
                    "doctorUnitName": doctorUnitName,
                    "doctorDepartmentName": doctorDepartmentName,
                    "doctorIdentity": doctorIdentity,
                    "doctorPassword": doctorPassword,
                    "doctorAddress": doctorAddress,
                    "checkState": checkState,
                    "doctorRemark": doctorRemark,
                    "doctorWechat": doctorWechat,
                    "doctorIntroduction": doctorIntroduction,
                    "tempPictureLocationId": tempPictureLocationId
                },
                success: function (msg) {
                    turnPage('doctor.html');
                    console.log("doctor_success:" + msg)
                },
                error: function (msg) {
                    turnPage('doctor.html');
                    console.log("doctor_error:" + msg)

                }

            });
        });
});

$('#remove').click(function () {
    var jsonobject = eval('(' + rowcontent + ')');
    if (confirm("是否删除此条医生信息？")) {
        $.ajax({
            type: 'delete',
            url: baseAddress + "/doctorinfo/deletebyid/" + jsonobject.doctorId + "/",
            success: function (json) {
                turnPage('doctor.html');
            }
        })
    }
});
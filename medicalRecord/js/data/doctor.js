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
            visible: false,
            title: '登录密码'
        }, {
            field: 'doctorAddress',
            title: '所在地区'
        }, {
            field: 'checkState',
            formatter: function (value) {
                if (value == 0) {
                    return "<p style='color: #FF0000'>未审核</p>";
                } else if (value == 1) {
                    return "<p style='color:#5cb85c'>已通过</p>"
                } else if (value == 2) {
                    return "<p style='color:#CCCCCC'>未通过</p>"
                }
            },
            title: '审核状态'
        }, {
            field: 'doctorRemark',
            formatter: value20,
            title: '备注'
        }, {
            field: 'doctorWechat',
            title: '微信'
        }, {
            field: 'doctorIntroduction',
            formatter: value20,
            title: '自我介绍'
        }, {
            field: 'tempPictureLocationId',
            formatter: showPic,
            title: '图片ID'
        }]

    });
}


$('#cancel').click(function () {
    turnPage('doctor.html');
});


$("#edit").click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行修改操作!");
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');
        $("#doctorId").val(jsonobject.doctorId);
        $("#doctorName").val(jsonobject.doctorName);
        $("#doctorSex").val(jsonobject.doctorSex);

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

        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
        $('#changepanel').html("医生信息编辑");
        $('#doit').html("确定");
    }
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
                dataType: "text",
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
                    console.log("doctor_error:" + msg)
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
        if (confirm("是否删除 '" + jsonobject.doctorName + "' 这条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/doctorinfo/deletebyid/" + jsonobject.doctorId + "/",
                success: function (json) {
                    turnPage('doctor.html');
                }
            })
        }
    }
});
//医生图片
jQuery(function ($) {
    var classpic = "医生";
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/picturelist/findbyname?pictureClass="+classpic,
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].originalPicturePath + " >" + msg[i].pictureName + "</option>";
            }
            $("#tempPictureLocationId").append(str);
        }
    })
});

$(document).ready(function () {
    $('#doctorform').bootstrapValidator({
        excluded: ':disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },

        fields: {
            doctorName: {
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    },
                    regexp: {
                        regexp: /^[\u4e00-\u9fa5]+$/,
                        message: '姓名只能包含中文'
                    }
                }
            },
            doctorAge: {
                validators: {
                    notEmpty: {
                        message: '年龄不能为空'
                    },
                    regexp: {
                        regexp: /^[1-9]\d?$|^1[01]\d$|^120$/,
                        message: '年龄1-120岁之间'
                    }
                }
            },
            doctorPhoneNumber: {
                validators: {
                    notEmpty: {
                        message: '手机号不能为空'
                    },
                    regexp: {
                        regexp: /^1[3|5|7|8|][0-9]{9}$/,
                        message: '请输入正确的手机号'
                    }
                }
            },
            val1024: {
                validators: {
                    stringLength: {
                        max: 1024,
                        message: '请输入不超过1024个字符的内容'
                    }
                }
            },
            val50: {
                validators: {
                    stringLength: {
                        max: 50,
                        message: '请输入不超过50个字符的内容'
                    }
                }
            }
        }
    });
})
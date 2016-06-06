/**
 * Created by sjh on 16/4/4.
 */
//病案信息表
var $table = $("#caseRecordTable");
var rowcontent = null;
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/caserecord/getall",
        dataType: "json",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'caseId',
            visible: false,
            title: '病案ID'
        }, {
            field: 'tempPatientId',
            title: '病人ID'
        }, {
            field: 'tempDoctorId',
            title: '医生ID'
        }, {
            field: 'tempDiseaseId',
            title: '常见疾病ID'
        }, {
            field: 'clinicalTime',
            formatter: function (value) {
                if (value == 1) {
                    return "<p >初诊</p>";
                } else if (value == 2) {
                    return "<p >次诊</p>"
                } else if (value == 3) {
                    return "<p >三诊</p>"
                } else if (value == 4) {
                    return "<p >四诊</p>"
                } else if (value == 5) {
                    return "<p >五诊</p>"
                }
            },
            title: '诊次'
        }, {
            field: 'caseDate',
            title: '时间'
        }, {
            field: 'patientTalk',
            formatter: value20,
            title: '主诉'
        }, {
            field: 'medicalHistory',
            formatter: value20,
            title: '病史'
        }, {
            field: 'tempPictureLocationId',
            formatter: showPic,
            title: '图片ID'
        }, {
            field: 'diagnosis',
            formatter: value20,
            title: '诊断'
        }, {
            field: 'tempDoctorPrescriptionId',
            title: '处方ID'
        }, {
            field: 'curativeEffect',
            formatter: value20,
            title: '疗效'
        }, {
            field: 'caseRemark',
            formatter: value20,
            title: '备注'
        }, {
            field: 'tipsContent',
            formatter: value20,
            title: '心得体会'
        }, {
            field: 'tempSyndromeId',
            title: '证型ID'
        }, {
            field: 'tempInquiryResultId',
            visible: false,
            title: '问诊结果ID'
        }]
    })
}

$("#caseDate").datetimepicker({
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
    turnPage('caseRecord.html');
});

$("#edit").click(function () {
    checkboxFun();
    if (n == 0) {
        alert("请选择一条记录进行修改操作!");
    }
    else if (n == 1) {
        var jsonobject = eval('(' + rowcontent + ')');

        //病人修改
        $.ajax({
            type: "get",
            dataType: "json",
            url: baseAddress + "/patientinfo/findbyname/?patientName=" + jsonobject.tempPatientId.toString(),
            success: function (msg) {
                var PatientId = msg[0].patientId;
                $('#tempPatientId').val(PatientId);
            }
        });
        //医生修改
        $.ajax({
            type: "get",
            dataType: "json",
            url: baseAddress + "/doctorinfo/findbyname/?doctorName=" + jsonobject.tempDoctorId.toString(),
            success: function (msg) {
                var DoctorId = msg[0].doctorId;
                $('#tempDoctorId').val(DoctorId);
            }
        });
        //疾病类别修改
        $.ajax({
            async:true,
            type: "get",
            dataType: "json",
            url: baseAddress + "/commondiseaseinfo/findbyname/?commonDiseaseName=" + jsonobject.tempDiseaseId.toString(),
            success: function (msg) {
                var DiseaseId = msg.commonDiseaseId;
                $('#tempDiseaseId').val(DiseaseId);
            }
        });
        //处方修改
        $.ajax({
            type: "get",
            dataType: "json",
            url: baseAddress + "/doctorprescription/findbyname/?prescriptionName=" + jsonobject.tempDoctorPrescriptionId.toString(),
            success: function (msg) {
                var PrescriptionId = msg[0].doctorPrescriptionId;
                $('#tempDoctorPrescriptionId').val(PrescriptionId);
            }
        });
        //证型修改
        $.ajax({
            type: "get",
            dataType: "json",
            url: baseAddress + "/syndrometypes/findbyname/?syndromeName=" + jsonobject.tempSyndromeId.toString(),
            success: function (msg) {
                var SyndromeId = msg[0].syndromeId;
                $('#tempSyndromeId').val(SyndromeId);
            }
        });
        //问诊结果修改
        $.ajax({
            type: "get",
            dataType: "json",
            url: baseAddress + "/inquiryresult/findbyname/?inquiryResult=" + jsonobject.tempInquiryResultId.toString(),
            success: function (msg) {
                var InquiryResultId = msg[0].inquiryResultId;
                $('#tempInquiryResultId').val(InquiryResultId);
            }
        });
        $("#caseId").val(jsonobject.caseId);
        $("#tempDiseaseId").val(jsonobject.tempDiseaseId);
        $("#clinicalTime").val(jsonobject.clinicalTime);
        $("#caseDate").val(jsonobject.caseDate);
        $("#patientTalk").val(jsonobject.patientTalk);
        $("#medicalHistory").val(jsonobject.medicalHistory);
        $("#tempPictureLocationId").val(jsonobject.tempPictureLocationId);
        $("#diagnosis").val(jsonobject.diagnosis);
        $("#tempDoctorPrescriptionId").val(jsonobject.tempDoctorPrescriptionId);
        $("#curativeEffect").val(jsonobject.curativeEffect);
        $("#caseRemark").val(jsonobject.caseRemark);
        $("#tipsContent").val(jsonobject.tipsContent);
        $("#tempSyndromeId").val(jsonobject.tempSyndromeId);
        $("#tempInquiryResultId").val(jsonobject.tempInquiryResultId);

        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
        $('#changepanel').html("病案信息编辑");
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
            var caseId = $("#caseId").val();
            var tempPatientId = $("#tempPatientId").val();
            var tempDoctorId = $("#tempDoctorId").val();
            var tempDiseaseId = $("#tempDiseaseId").val();
            var clinicalTime = $("#clinicalTime").val();
            var caseDate = $("#caseDate").val();
            var patientTalk = $("#patientTalk").val();
            var medicalHistory = $("#medicalHistory").val();
            var tempPictureLocationId = $("#tempPictureLocationId").val();
            var diagnosis = $("#diagnosis").val();
            var tempDoctorPrescriptionId = $("#tempDoctorPrescriptionId").val();
            var curativeEffect = $("#curativeEffect").val();
            var caseRemark = $("#caseRemark").val();
            var tipsContent = $("#tipsContent").val();
            var tempSyndromeId = $("#tempSyndromeId").val();
            var tempInquiryResultId = $("#tempInquiryResultId").val();

            $.ajax({
                url: baseAddress + "/caserecord/saveorupdate",
                type: "post",
                dataType: "text",
                data: {
                    "caseId": caseId,
                    "tempPatientId": tempPatientId,
                    "tempDoctorId": tempDoctorId,
                    "tempDiseaseId": tempDiseaseId,
                    "clinicalTime": clinicalTime,
                    "caseDate": caseDate,
                    "patientTalk": patientTalk,
                    "medicalHistory": medicalHistory,
                    "tempPictureLocationId": tempPictureLocationId,
                    "diagnosis": diagnosis,
                    "tempDoctorPrescriptionId": tempDoctorPrescriptionId,
                    "curativeEffect": curativeEffect,
                    "caseRemark": caseRemark,
                    "tipsContent": tipsContent,
                    "tempSyndromeId": tempSyndromeId,
                    "tempInquiryResultId": tempInquiryResultId
                },
                success: function (msg) {
                    turnPage('caseRecord.html');
                    console.log("caseRecord_success:" + msg)
                },
                error: function (err) {
                    console.log("caseRecord_error:" + err)
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
        if (confirm("是否删除这条信息？")) {
            $.ajax({
                type: 'delete',
                url: baseAddress + "/caserecord/deletebyid/" + jsonobject.caseId + "/",
                success: function (json) {
                    turnPage('caseRecord.html');
                }
            })
        }
    }
});


jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/patientinfo/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].patientId + " >" + msg[i].patientName + "</option>";
            }
            $("#tempPatientId").append(str);
        }
    })
});

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

jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/commondiseaseinfo/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].commonDiseaseId + " >" + msg[i].commonDiseaseName + "</option>";
            }
            $("#tempDiseaseId").append(str);
        }
    })
});

//医案图片
jQuery(function ($) {
    var classpic = "医案";
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

jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/doctorprescription/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].doctorPrescriptionId + ">" + msg[i].prescriptionName + "</option>";
            }
            $("#tempDoctorPrescriptionId").append(str);
        }
    })
});

jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/syndrometypes/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].syndromeId + ">" + msg[i].syndromeLevelType + " " + msg[i].syndromeName + "</option>";
            }
            $("#tempSyndromeId").append(str);
        }
    })
});

jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/inquiryresult/getall",
        success: function (msg) {
            var str = "";
            for (var i in msg) {
                str += "<option value =" + msg[i].inquiryResultId + ">" + msg[i].inquiryResult + "</option>";
            }
            $("#tempInquiryResultId").append(str);
        }
    })
});



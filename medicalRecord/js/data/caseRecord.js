/**
 * Created by sjh on 16/4/4.
 */
//病案信息表
var $table = $("#caseRecordTable");
var rowcontent = null;
function initTable() {
    $table.bootstrapTable({
        url: baseAddress + "/caserecord/getall",
        dateType: "json",
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
            //formatter: function (value, name) {
            //    $.ajax({
            //        type: "get",
            //        datatype: "json",
            //        url: baseAddress + '/patientinfo/getall',
            //        success: function (msg) {
            //            var str = "";
            //            for (i in msg) {
            //                str += "<option value =" + msg[i].patientId + " >" + msg[i].patientName + "</option>";
            //            }
            //            return str;
            //        }
            //    });
            //},
            title: '病人ID'
        }, {
            field: 'tempDoctorId',
            title: '医生ID'
        }, {
            field: 'tempDiseaseId',
            title: '常见疾病ID'
        }, {
            field: 'clinicalTime',
            title: '诊次'
        }, {
            field: 'caseDate',
            title: '时间'
        }, {
            field: 'patientTalk',
            title: '主诉'
        }, {
            field: 'medicalHistory',
            title: '病史'
        }, {
            field: 'tempPictureLocationId',
            title: '图片ID'
        }, {
            field: 'diagnosis',
            title: '诊断'
        }, {
            field: 'tempDoctorPrescriptionId',
            title: '处方ID'
        }, {
            field: 'curativeEffect',
            title: '疗效'
        }, {
            field: 'caseRemark',
            title: '备注'
        }, {
            field: 'tipsContent',
            title: '心得体会'
        }, {
            field: 'tempSyndromeId',
            title: '证型ID'
        }, {
            field: 'tempInquiryResultId',
            title: '问诊结果ID'
        }]
    })
}

$("#caseDate").datetimepicker({
    format: 'yyyy-mm-dd',
    //todayHighlight:true,
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
    var jsonobject = eval('(' + rowcontent + ')');
    $("#caseId").val(jsonobject.caseId);
    $("#tempPatientId").val(jsonobject.tempPatientId);
    $("#tempDoctorId").val(jsonobject.tempDoctorId);
    $("#tempDiseaseId").val(jsonobject.tempDiseaseId);
    $("#clinicalTime").val(jsonobject.clinicalTime);
    $("#caseDate").val(jsonobject.caseDate);
    $("#patientTalk").val(jsonobject.patientTalk);
    $("#medicalHistory").val(jsonobject.medicalHistory);
    $("#tempPictureLocationId").val(jsonobject.tempPictureLocationId);
    $("#diagnosis").val(jsonobject.diagnosis);
    $("#caseRemark").val(jsonobject.caseRemark);
    $("#tipsContent").val(jsonobject.tipsContent);
    $("#tempSyndromeId").val(jsonobject.tempSyndromeId);
    $("#tempInquiryResultId").val(jsonobject.tempInquiryResultId);

    $('.showpanel').css('display', 'none');
    $('.addpanel').css('display', 'block');
    $('#changepanel').html("病案信息编辑");
    $('#doit').html("确定");
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
    var jsonobject = eval('(' + rowcontent + ')');
    if (confirm("是否删除此条信息？")) {
        $.ajax({
            type: 'delete',
            url: baseAddress + "/caserecord/deletebyid/" + jsonobject.caseId + "/",
            success: function (json) {
                turnPage('caseRecord.html');
            }
        })
    }
});


jQuery(function ($) {
    $.ajax({
        type: "get",
        dataType: "json",
        url: baseAddress + "/patientinfo/getall",
        success: function (msg) {
            var str = "";
            for (i in msg) {
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
            for (i in msg) {
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
            for (i in msg) {
                str += "<option value =" + msg[i].commonDiseaseId + " >" + msg[i].commonDiseaseName + "</option>";
            }
            $("#tempDiseaseId").append(str);
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
            for (i in msg) {
                str += "<option value =" + msg[i].syndromeId + ">" + msg[i].syndromeRemark + msg[i].syndromeName + "</option>";
            }
            $("#tempSyndromeId").append(str);
        }
    })
});

//jQuery(function ($) {
//    $.ajax({
//        type: "get",
//        dataType: "json",
//        url: baseAddress + "//getall",
//        success: function (msg) {
//            var str = "";
//            for (i in msg) {
//                str += "<option value =" + msg[i].inquiryResultId + ">" + msg[i].inquiryResult  + "</option>";
//            }
//            $("#tempInquiryResultId").append(str);
//        }
//    })
//});



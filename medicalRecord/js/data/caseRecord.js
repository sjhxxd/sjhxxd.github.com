/**
 * Created by sjh on 16/4/4.
 */
//病案信息表
var $table = $("#caseRecordTable");

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
            //            $("#tempPatientId").append(str);
            //        }
            //    };
            //    return name;
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
        }]
    })
}
initTable();
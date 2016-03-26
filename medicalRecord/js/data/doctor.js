/**
 * Created by sjh on 16/3/8.
 */
//医生信息表
var $table = $("#doctorInfoTable");
function initTable() {
    $table.bootstrapTable({
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
            field: 'password',
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
        }]

    });
}

initTable();
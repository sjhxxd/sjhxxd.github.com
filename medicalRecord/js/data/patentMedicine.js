/**
 * Created by sjh on 16/3/8.
 */
    //中成药信息表
var $table=$("#patentMedicineInfoTable");
function initTable(){
    $table.bootstrapTable({
        url:baseAddress+"/patentmedicineinfo/getall",
        columns: [{
            field: 'state',
            checkbox: true,
            align: 'center'
        }, {
            field: 'patentMedicineId',
            visible: false,
            title: '中成药ID'
        }, {
            field: 'patentMedicineName',
            title: '中成药名称'
        }, {
            field: 'patentMedicineContent',
            title: '中成药内容'
        }, {
            field: 'indicationsFunction',
            title: '功能主治'
        }, {
            field: 'shape',
            title: '性状'
        }, {
            field: 'usageDosage',
            title: '用法与用量'
        }, {
            field: 'attention',
            title: '注意'
        }, {
            field: 'specifications',
            title: '规格'
        }, {
            field: 'storageMethod',
            title: '贮藏方式'
        }, {
            field: 'saute',
            title: '制法'
        }, {
            field: 'patentMedicineRemark',
            title: '备注'
        }]

    });
}

initTable();
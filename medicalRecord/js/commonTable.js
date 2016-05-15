/**
 * Created by sjh on 16/5/15.
 */
$(function () {
    var rowcontent = null;
    $("#add").click(function () {
        $('.showpanel').css('display', 'none');
        $('.addpanel').css('display', 'block');
    });
    //阻止表单提交
    $("form").submit(function (e) {
        e.preventDefault();
    });
});


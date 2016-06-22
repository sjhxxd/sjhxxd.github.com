/**
 * Created by Mesogene on 3/13/16.
 */


//ajax函数定义
function restful(typeInfo, urlInfo, dataInfo) {
    /**typeInfo:操作类型；
     * urlInfo:地址；
     * dataInfo:json数据；
     * 操作类型：
     * get：获取（dataInfo为空时，查询所有；dataInfo不为空，条件查询）；
     * 查询(数据分页，暂时每页是十条数据，可后台更改)
     * post：上传；
     * put：更新(按照id)；
     * delete：删除数据（id）；
     * */

    var result = null;
    $.ajax({
        async: false,
        type: typeInfo,
        url: urlInfo,
        dataType: "json",
        //contentType:"application/json",
        data: dataInfo,
        success: function (json) {
            result = json;
        },
        error: function () {
            result = "fail";
        }
    });
    //	.success(function (json) {
    //	//result = json;
    //	result= json;
    //	return result;
    //}).error(function(json){
    //	result = json;
    //	return result;
    //});
    return result;
}

//ajax函数定义——提交数组
function restfulArray(typeInfo, urlInfo, dataInfo) {
    /**typeInfo:操作类型；
     * urlInfo:地址；
     * dataInfo:json数据；
     * 操作类型：
     * get：获取（dataInfo为空时，查询所有；dataInfo不为空，条件查询）；
     * 查询(数据分页，暂时每页是十条数据，可后台更改)
     * post：上传；
     * put：更新(按照id)；
     * delete：删除数据（id）；
     * */

    var result = null;
    $.ajax({
        async: false,
        type: typeInfo,
        url: urlInfo,
        //dataType:"json",
        contentType: "application/json",
        data: JSON.stringify(dataInfo),
        success: function (json) {
            result = json;
        },
        error: function () {
            result = "fail";
        }
    });
    //	.success(function (json) {
    //	//result = json;
    //	result= json;
    //	return result;
    //}).error(function(json){
    //	result = json;
    //	return result;
    //});
    return result;
}


/* 点击切换中间content */
function turnPage(url) {    //url:请求的url
    var $content = $('#content');
    $.ajax({
        type: "get",
        url: url,
        cache: false,
        dataType: "html",
        data: {area: url},
        success: function (html) {
            $content.empty();    //首先清空centent区
            $content.html(html);  //把下载的html文件添加到centent区中
        },
        error: function (mag) {
            $content.empty();
            $content.html('<p>出了一些差错，请耐心等待修复：）</p>');
        }
    });
}

$(function () {
    $(".submenu").hide();  //默认二级菜单隐藏
    /*侧边栏鼠标点击颜色切换*/
    $('.accordion> li>a').click(function () {
        $(this).addClass('active');
        $(this).parent().siblings().find('a').removeClass('active');
        $(this).siblings().toggle(500);
        $(this).parent().find('li').addClass('open');
        $(this).parent().siblings().find('ul').hide(500);
    });

    $(".submenu> li>a").click(function () {
        //var leftName =this.firstChild.nodeValue;
        //$("#right-nav").html(leftName);
        $(this).addClass("active");
        $(this).parent().siblings().find('a').removeClass("active");
        $(this).parent().parent().siblings().addClass('active');
    });

});

//不登录无法直接访问
if (sessionStorage.getItem('doctorId') == null) {
    if (sessionStorage.getItem('userName') == null) {
        location.href = 'login_d.html';
    }
} else {
    if (sessionStorage.getItem('userName') != null) {
        $('#u_name').html(sessionStorage.getItem('userName'));
    }
}
//退出登录
$('#logoutBtn').click(function (event) {
    sessionStorage.removeItem('doctorId');
    sessionStorage.removeItem('userName');
    location.href = 'login_d.html';
});

//Bootstrap Table 默认设置
$.extend($.fn.bootstrapTable.defaults, {
    singleSelect: true,
    striped: true
});


//checkbox全选
$("input[name='btSelectAll']").on("click", function () {
    if ($(this).prop("checked") === true) {
        $("input[name='btSelectItem']").prop("checked", $(this).prop("checked"));
        $('$table tbody tr').addClass('selected');
    } else {
        $("input[name='btSelectItem']").prop("checked", false);
        $('$table tbody tr').removeClass('selected');
    }
});
//检验选择了几个checkbox
function checkboxFun() {
    checks = $("input[name='btSelectItem']");
    n = 0;
    for (i = 0; i < checks.length; i++) {
        if (checks[i].checked) {
            n++;
            x = i;
        }
    }
}

//取前20个字显示
function value20(value) {
    if (value != null) {
        return value.length > 21 ? '<span title="' + value + '">' + value.substr(0, 20) + '...</span>' : value;
    }
}

//显示图片
function showPic(value) {
    if (value != null) {
        return '<img src="' + value + '" alt="抢修中..." height="50" width="50">'
    }
    else if (value == null) {
        return value;
    }
}


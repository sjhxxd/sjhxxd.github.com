$(function () {

    if (localStorage.getItem('usr') != null) {
        if (localStorage.getItem('pwd') != null) {
            $('#userName').val(localStorage.getItem('usr'));
            $('#password').val(localStorage.getItem('pwd'));
        }
    }

    $('#remember').click(function (event) {
        if ($(this).attr('checked')) {
            $(this).removeAttr('checked');
        } else {
            $(this).attr('checked', true);
        }
    });

    $('#login').click(function (event) {
        if ($('#remember').attr('checked') == 'checked') {
            localStorage.setItem('usr', $.trim($('#userName').val()));
            localStorage.setItem('pwd', $.trim($('#password').val()));
        } else {
            localStorage.removeItem('usr');
            localStorage.removeItem('pwd');
        }

        if (!$.trim($('#userName').val()).match(/^[a-zA-Z0-9_\u4e00-\u9fa5]+$/)) {
            alert('账号只能是数字、字母、下划线');
            return false;
        } else if ($.trim($('#password').val()).length < 6) {
            alert('密码至少六位');
            return false;
        } else {
            $.ajax({
                url: baseAddress + '/admin/login',
                type:'post',
                data: {
                    userName: $.trim($('#userName').val()),
                    password: $.trim($('#password').val())
                },
                success: function (data) {
                    console.log("data--->",data);
                    if (data.totalNumber == 0) {
                        alert(data.returnData);
                    } else if (data.totalNumber == 1) {
                        sessionStorage.setItem('userId', data.returnData.userId);
                        sessionStorage.setItem('userName', data.returnData.userName);
                        location.href = 'index.html';
                    }
                }
            })
        }
    })

})

/**
 * Created by sjh on 16/6/6.
 */
$(function () {

    if (localStorage.getItem('usr') != null) {
        if (localStorage.getItem('pwd') != null) {
            $('#doctorName').val(localStorage.getItem('usr'));
            $('#doctorPassword').val(localStorage.getItem('pwd'));
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
            localStorage.setItem('usr', $.trim($('#doctorName').val()));
            localStorage.setItem('pwd', $.trim($('#doctorPassword').val()));
        } else {
            localStorage.removeItem('usr');
            localStorage.removeItem('pwd');
        }

        if (!$.trim($('#doctorName').val()).match(/^[a-zA-Z0-9_\u4e00-\u9fa5]+$/)) {
            alert('账号只能是数字、字母、下划线');
            return false;
        } else if ($.trim($('#doctorPassword').val()).length < 6) {
            alert('密码至少六位');
            return false;
        } else {
            $.ajax({
                url: baseAddress + '/doctorLogin/login',
                type:'post',
                data: {
                    userName: $.trim($('#doctorName').val()),
                    password: $.trim($('#doctorPassword').val())
                },
                success: function (data) {
                    console.log("data--->",data);
                    if (data.totalNumber == 0) {
                        alert(data.returnData);
                    } else if (data.totalNumber == 1) {
                        sessionStorage.setItem('doctorId', data.returnData.doctorId);
                        sessionStorage.setItem('userName', data.returnData.userName);
                        location.href = 'index_d.html';
                    }
                }
            })
        }
    })

})

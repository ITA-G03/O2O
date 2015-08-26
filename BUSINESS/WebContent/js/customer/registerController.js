/**
 * Created by GUOKA2 on 2015/8/25.
 */

$(function () {
    $('form.register-form').find('button[type=submit]').click(function () {
        var $this = $('form.register-form'),
            tel = $this.find('input[name=tel]').val(),
            password = $this.find('input[name=password]').val(),
            confirm = $this.find('input[name=confirm]').val();
        if (tel && password && confirm) {
            if (confirm == password) {
                $.post('/action/register', {
                    tel: tel,
                    password: $.md5(password),
                    confirm: $.md5(confirm)
                }, function (data) {
                    if (data.status == 'success') {
                        location.href = '/index';
                    } else {
                        $('#errMsg').text(data.body.errMsg);
                    }
                })
                return false;
            } else {
                $('#errMsg').text('密码输入不一致');
                return false;
            }
        } else {
            return true;
        }
    })
})
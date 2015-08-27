/**
 * Created by GUOKA2 on 2015/8/25.
 */

$(function () {
    $('form.register-form').find('button[type=submit]').click(function () {
        var $this = $('form.register-form'),
            tel = $this.find('input[name=tel]').val(),
            password = $this.find('input[name=password]').val();
        if (tel && password) {
            $.post('/action/login', {
                tel: tel,
                password: $.md5(password)
            }, function (data) {
                if (data.status == 'success') {
                    location.href = '/index';
                } else {
                    $('#errMsg').text(data.body.errMsg);
                }
            });
            return false;
        } else {
            return true;
        }
    })
})
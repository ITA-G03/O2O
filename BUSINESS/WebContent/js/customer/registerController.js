/**
 * Created by GUOKA2 on 2015/8/25.
 */

$(function(){
    $('form.register-form').ajaxForm(function(data){
        console.log(data)
        if (data.status == 'success') {
            window.location.href = '/index';
        } else {
            $('#errMsg').text(data.body.errMsg);
        }
    })
})
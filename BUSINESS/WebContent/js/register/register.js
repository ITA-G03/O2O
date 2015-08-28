function initListeners() {
    $("#signboard").blur(validateUserName);
    $("#tel").blur(validateTel);
    $("#idCard").change(uploadIdCard);
    $("#license").change(uploadLicense);
    $("#Logo").change(uploadLogo);

    $("#registerButton").click(register);
}

function validateUserName() {
    var signboard = $("#signboard").val();
    $("#validateUserNameMessage").text("").hide();
    if (signboard.match(/^[\u4e00-\u9fa5A-Za-z]{3,}$/)) {
        $("#validateUserNameSpinner").show();
        //$.ajax({
        //    url: 'user/validateUserName',
        //    method: 'get',
        //    cache: false,
        //    data: {
        //        username: username
        //    },
        //    dataType: 'json',
        //    success: function (response) {
        //        $("#validateUserNameSpinner").hide();
        //        if (response.status == "success") {
        //            $("#validateUserNameMessage").attr("class", "text-success").text("").show();
        //        }
        //        else {
        //            $("#validateUserNameMessage").attr("class", "text-danger").text(response.body.reason).show();
        //        }
        //    },
        //    error: function () {
        //        $("#validateUserNameSpinner").hide();
        //    }
        //});
    }
    else {
        $("#validateUserNameMessage").attr("class", "text-danger").text("SignBoard Format Wrong!").show();
    }
}

function validatePassWord() {
    var password = $("#password").val();
    $("#validatePassWordMessage").text("").hide();
    if (!password.match(/[a-zA-z0-9][a-zA-Z0-9_]{3,20}/)) {
        $("#validatePassWordMessage").attr("class", "text-danger").text("Password Format Wrong!").show();
    }
}

function validateTel() {
    var tel = $("#tel").val();
    $("#validateTelMessage").text("").hide();
    if (!tel.match(/^[0-9\-]{7,20}$/)) {
        $("#validateTelMessage").attr("class", "text-danger").text("Tel Format Wrong!").show();
    }
}

function validateIdCard() {
    $("#validateIdCardMessage").text("").hide();
    if ($("#idCardId").val() == "") {
        $("#validateIdCardMessage").attr("class", "text-danger").text("Please Upload IdCard Image~").show();
    }
}


function validateLicense() {
    $("#validateLicenseMessage").text("").hide();
    if ($("#licenseId").val() == "") {
        $("#validateLicenseMessage").attr("class", "text-danger").text("Please Upload License Image~").show();
    }
}

function uploadIdCard() {
    $("#validateIdCardMessage").text("").hide();
    $.ajaxFileUpload({
        url: '/action/image/upload',
        secureuri: false,
        fileElementId: 'idCard',
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        success: function (data) {
            console.log(data.status);
            console.log(data.body.imageId);
            $("#idCardId").val(data.body.imageId);
            $("#idCardImage").attr("src", "/image/view/" + data.body.imageId).removeClass("hidden").show();
            $("#idCard").change(uploadIdCard);
        },
        error: function (data) {
            $("#validateIdCardMessage").attr("class", "text-danger").text("卧槽,上传失败了!").show();
            $("#idCard").change(uploadIdCard);
            console.log(data);
        }
    });

}

function uploadLogo() {
    $("#validateLogoMessage").text("").hide();
    $.ajaxFileUpload({
        url: '/action/image/upload',
        secureuri: false,
        fileElementId: 'Logo',
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        success: function (data) {
            console.log(data.status);
            console.log(data.body.imageId);
            $("#logoId").val(data.body.imageId);
            $("#logoImage").attr("src", "/image/view/" + data.body.imageId).removeClass("hidden").show();
            $("#Logo").change(uploadIdCard);
        },
        error: function (data) {
            $("#validateLogoMessage").attr("class", "text-danger").text("卧槽,上传失败了!").show();
            $("#Logo").change(uploadIdCard);
            console.log(data);
        }
    });

}

function uploadLicense() {
    $("#validateLicenseMessage").text("").hide();
    $.ajaxFileUpload({
        url: '/action/image/upload',
        secureuri: false,
        fileElementId: 'license',
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache: false,
        success: function (data) {
            console.log(data.status);
            console.log(data.body.imageId);
            $("#licenseId").val(data.body.imageId);
            $("#licenseImage").attr("src", "/image/view/" + data.body.imageId).removeClass("hidden").show();
            $("#license").change(uploadIdCard);
        },
        error: function (data) {
            $("#validateLicenseMessage").attr("class", "text-danger").text("卧槽,上传失败了!").show();
            $("#license").change(uploadIdCard);
            console.log(data);
        }
    });
}

function validateAll() {
    validateUserName();
    //validatePassWord();
    validateTel();
    validateIdCard();
    validateLicense();

    var validateResult = "";
    $("p[id^='validate']").each(function () {
        validateResult += ("" + $(this).text());
    });
    return validateResult == "";
}

function register() {
    if (validateAll() == true) {
        //submit
        var signboard = $("#signboard").val();
        var password = $("#password").val();
        var tel = $("#tel").val();
        var idCardId = $("#idCardId").val();
        var licenseId = $("#licenseId").val();

        $("#registerSpinner").show();
        $.ajax({
            url: 'user/register',
            method: 'post',
            cache: false,
            data: {
                signboard: signboard,
                password: password,
                tel: tel,
                idCardId: idCardId,
                licenseId: licenseId
            },
            dataType: 'json',
            success: function (response) {
                $("#registerSpinner").hide();
                if (response.status == "success") {
                    location.href = "login";
                }
                else {
                    $("#errorMessage").text("Register Failed").show();
                }
            }
            ,
            error: function () {
                $("#registerSpinner").hide();
            }


        });

    }
}


$(function () {
    initListeners();
});

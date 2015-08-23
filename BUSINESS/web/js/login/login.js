function initListeners(){
    $("#loginButton").click(login);
}

function login(){
    var username=$("#username").val();
    var password=$("#password").val();
    $("#loginSpinner").attr("class","").show();
    $("#loginResponseMessage").hide();
    $.ajax({
        url:'/action/login',
        method:'post',
        cache:false,
        data:{
            username:username,
            password:password
        },
        dataType:'json',
        success:function(response){
            $("#loginSpinner").hide();
            if(response.status=="success"){
                location.href="index";
            }
            else{
                $("#loginResponseMessage").attr("class","text-danger").text(response.body.reason).show();
                console.log("Set Message");
            }
        }
        ,
        error:function(response){
            $("#loginSpinner").hide();
            $("#loginResponseMessage").show();
        }

    });
}

function doubleDecode(query){
    var decodedQuery=decodeURI(query);
    return decodeURIComponent(decodedQuery);
}
$(function(){
    initListeners();
});
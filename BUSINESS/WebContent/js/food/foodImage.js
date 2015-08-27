function initListeners() {
	$("#foodPicture").change(uploadFoodImage);
    $("#saveButton").click(addFood);
}

function uploadFoodImage(){
	 $("#validatePictureMessage").text("").hide();
    $.ajaxFileUpload({
        url:'../action/image/upload',
        secureuri: false,
        fileElementId: 'foodPicture',
        dataType: 'JSON',
        contentType: "application/json; charset=utf-8",
        cache:false,
        success:function(data){
            console.log(data.status);
            console.log(data.body.imageId);
            $("#pictureId").val(data.body.imageId);
            $("#foodImage").attr("src","../image/view/"+data.body.imageId).removeClass("hidden").show();
        },
        error:function(data){
            $("#validatePicureMessage").attr("class","text-danger").text("卧槽,上传失败了!").show();
            $("#foodPicture").change(uploadFoodImage);
            console.log(data);
        }
    });
}
function validateFood(){
    $("#validaePictureMessage").text("").hide();
    if($("#pictureId").val()==""){
        $("#validatePictureMessage").attr("class","text-danger").text("Please Upload License Image~").show();
    }
}

function addFood(){
       alert("add.............")
       var foodName = $("#foodName").val();
       var price =$("#price").val();
       var typeName=$("#type").val();
       var foodPictureId = $("#pictureId").val();
       $.ajax({
           url: '../action/food/create',
           method: 'post',
           cache: false,
           data: {
               foodName: foodName,
               price: price,
               typeName: typeName,
               foodPictureId: foodPictureId
           },
           dataType: 'json',
           success: function (response) {
               if(response.status=="success"){
                   location.href="../business/index";
               }
               else{
                   $("#errorMessage").text("add food Failed").show();
               }
           }
           ,
           error: function () {
               $("#registerSpinner").hide();
           }


       });


}

$(function(){
    initListeners();
});

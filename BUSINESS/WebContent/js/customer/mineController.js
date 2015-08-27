app.controller('pageCtrl', function ($scope, $modal,$http) {

    $scope.changePassword = function () {
        var modalInstance = $modal.open({
            templateUrl: 'changePassword.html',
            controller: 'ModalInstanceCtrl'
        })
    }



    $scope.orders = [
        {
            id: 1,
            name: '香辣Tomcat堡',
            sales: 43,
            price: 8,
            num: 1
        },
        {
            id: 2,
            name: '炸Tomcat堡',
            sales: 43,
            price: 8,
            num: 1
        }, {
            id: 3,
            name: 'Tomcat卷',
            sales: 43,
            price: 8,
            num: 1
        }, {
            id: 4,
            name: 'Tomcat血',
            sales: 43,
            price: 8,
            num: 1
        }, {
            id: 5,
            name: '新奥尔良Tomcat腿',
            sales: 43,
            price: 8,
            num: 2
        }, {
            id: 1,
            name: '香辣Tomcat堡',
            sales: 43,
            price: 8,
            num: 3
        }, {
            id: 3,
            name: 'Tomcat卷',
            sales: 43,
            price: 8,
            num: 1
        }
    ]

    $http.get('/rest/mine/order/all').success(function (data) {
        console.info(data);
        $scope.orders = data;
    })

    $scope.getOrderSalesValue=function(orderItemList){
        var result=0.0;
        for(var i=0;i<orderItemList.length;i++){
            result+=(orderItemList[i].priceSnapshot* orderItemList[i].count );
        }
        return result.toFixed(1);
    }
})


app.controller('ModalInstanceCtrl', function ($scope, $modalInstance) {
    $scope.cancel = function () {
        $modalInstance.dismiss();
    };

    $scope.save=function(){
        //保存密码
        var oldPassword= $.md5($("#oldPassword").val());
        var newPassword= $.md5($("#newPassword").val());
        console.log("Old Password:"+oldPassword);
        console.log("New Password:"+newPassword);

        $.ajax({
            url:'/action/mine/info/update',
            method:'post',
            data:{
                oldPassword:oldPassword,
                newPassword:newPassword
            },
            cache:false,
            success:function(response){
                var responseMessage=JSON.parse(response);
                console.log("Response:~"+response+" Status:"+responseMessage.status);
                $modalInstance.dismiss();
                if(responseMessage.status=="success"){
                    $("#updatePasswordMessage").removeClass("hidden").removeClass("text-danger").addClass("text-success").text("更新成功=.=").show();
                }
                else{
                    $("#updatePasswordMessage").removeClass("hidden").removeClass("text-success").addClass("text-danger").text(responseMessage.body.errMsg).show();
                }
            },
            error:function(){

            }

        });
    };
});
app.controller('pageCtrl', function ($scope, $modal, $http) {

    $scope.changePassword = function () {
        var modalInstance = $modal.open({
            templateUrl: 'changePassword.html',
            controller: 'ModalInstanceCtrl'
        })
    }


    $scope.orders = [];

    $http.get('/rest/mine/order/all').success(function (data) {
        console.info(data);
        $scope.orders = data;
    })

    $scope.getOrderSalesValue = function (orderItemList) {
        if (orderItemList) {
            var result = 0.0;
            for (var i = 0; i < orderItemList.length; i++) {
                result += (orderItemList[i].priceSnapshot * orderItemList[i].count );
            }
            return result.toFixed(1);
        }
        else {
            return 0;
        }
    }

    $scope.submitComment = function (index) {
        console.log($scope.orders[index]);

        $.ajax({
            url:'/action/order/comment/create',
            method:'post',
            data:{
                orderId:$scope.orders[index].orderId,
                rating:$scope.orders[index].rating,
                comment:$scope.orders[index]._comments
            },
            cache:false,
            success:function(response){
                if(response.status=="success"){
                    console.log("~~改");
                    $scope.orders[index].status.statusId=14;
                    $scope.$apply();
                }
            }
        });
    }
})


app.controller('ModalInstanceCtrl', function ($scope, $modalInstance) {
    $scope.cancel = function () {
        $modalInstance.dismiss();
    };

    $scope.save = function () {
        //保存密码
        var oldPassword = $.md5($("#oldPassword").val());
        var newPassword = $.md5($("#newPassword").val());
        console.log("Old Password:" + oldPassword);
        console.log("New Password:" + newPassword);

        $.ajax({
            url: '/action/mine/info/update',
            method: 'post',
            data: {
                oldPassword: oldPassword,
                newPassword: newPassword
            },
            cache: false,
            success: function (response) {
                var responseMessage = JSON.parse(response);
                console.log("Response:~" + response + " Status:" + responseMessage.status);
                $modalInstance.dismiss();
                if (responseMessage.status == "success") {
                    $("#updatePasswordMessage").removeClass("hidden").removeClass("text-danger").addClass("text-success").text("更新成功=.=").show();
                }
                else {
                    $("#updatePasswordMessage").removeClass("hidden").removeClass("text-success").addClass("text-danger").text(responseMessage.body.errMsg).show();
                }
            },
            error: function () {

            }

        });
    };

});
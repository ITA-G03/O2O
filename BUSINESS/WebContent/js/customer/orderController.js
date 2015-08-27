app.controller('pageCtrl', function ($scope, $http) {
    $scope.pay = function () {
        var customerAddr = $scope.customerAddr;
        var remark = $scope.remark;
        $.ajax({
            url: '/order/create',
            type: 'POST',
            data: JSON.stringify({customerAddr: customerAddr, remark: remark}),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                location.href = '/success';
            }
        });

    }

    $http.get('/order/cart/session').success(function (data) {
        $scope.orders = data.foodList;
        $scope.restaurant = data;
        var sum = 0;
        for (var i = 0; i < $scope.orders.length; i++) {
            sum += ($scope.orders[i].price * $scope.orders[i].num);
        }
        $scope.sum = sum.toFixed(1);
    });
})
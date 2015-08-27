app.controller('pageCtrl', function ($scope, $http) {
    $scope.pay = function () {
        location.href = '/success';
    }

    $http.get('/order/cart/session').success(function (data) {
        $scope.orders = data.foodList;
    });


})
app.controller('pageCtrl', function ($scope, $modal) {

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
})

app.controller('ModalInstanceCtrl', function ($scope, $modalInstance) {
    $scope.cancel = function () {
        $modalInstance.dismiss();
    };
});
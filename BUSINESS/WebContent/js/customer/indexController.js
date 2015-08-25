app.controller('locationCtrl', function ($scope, $modal) {
    $scope.cities = ['珠海', '广州', '深圳'];
    $scope.searchCity = $scope.cities[0];

    $scope.search = function () {
        if (!$scope.searchArea) {
            $modal.open({
                templateUrl: 'mustFill.html',
                controller: 'ModalInstanceCtrl'
            });
        } else {
            location.href = '/main';
        }
    }
})

app.controller('ModalInstanceCtrl', function ($scope, $modalInstance) {
    $scope.cancel = function () {
        $modalInstance.dismiss();
    };
});
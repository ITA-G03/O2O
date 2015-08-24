app.controller('locationCtrl', function ($scope, $modal) {
    $scope.cities = ['珠海', '广州', '深圳'];

    $scope.search = function () {
        if (!$scope.searchArea) {
            var modalInstance = $modal.open({
                templateUrl: 'mustFill.html',
                controller: 'ModalInstanceCtrl'
            });
        } else {
            location.href = 'main.html';
        }
    }
})

app.controller('ModalInstanceCtrl', function ($scope, $modalInstance) {
    $scope.cancel = function () {
        $modalInstance.dismiss();
    };
});
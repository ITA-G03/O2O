/**
 * Created by GUOKA2 on 2015/8/25.
 */
app.controller('loginCtrl', function ($scope, $http) {
    $scope.login = function () {
        $http({
            method: 'POST',
            url: '/action/login',
            data: param($scope.formData),
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function (data) {
            if (data.status == 'success') {
                window.location.href = '/main';
            } else {
                $scope.errMsg = data.body.errMsg;
            }
        })


    }


})
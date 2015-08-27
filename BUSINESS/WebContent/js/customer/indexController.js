app.controller('locationCtrl', function ($scope, $modal, $http, $cookieStore) {

    $http.get('/rest/location/city').success(function (data) {
        $scope.cities = data;
    })

    $scope.history = $cookieStore.get('locations');
    $scope.searchFromHistory = function () {
        var form = $('form.change-location-form');
        form.find('select[name=cityId]').val($scope.history[$scope.historyIndex].city.cityId);
        form.find('input[name=areaName]').val($scope.history[$scope.historyIndex].area.areaName);
        form.submit();
    }

    $http.get('/rest/location/area').success(function (data) {
        $scope.areas = data;
    });

})

$(function () {
    $('form.change-location-form').ajaxForm(function (data) {
        if (data.status == 'success') {
            window.location.href = '/main';
        } else {
            console.log(data);
        }
    })
})


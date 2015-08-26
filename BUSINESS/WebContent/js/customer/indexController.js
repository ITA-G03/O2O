app.controller('locationCtrl', function ($scope, $modal, $http) {

    $http.get('/rest/location/city').success(function (data) {
        $scope.cities = data;
    })

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


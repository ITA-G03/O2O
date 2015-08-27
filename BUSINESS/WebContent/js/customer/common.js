Array.prototype.contains = function (element) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == element) {
            return true;
        }
    }
    return false;
}

var param = function (obj) {
    var query = '', name, value, fullSubName, subName, subValue, innerObj, i;

    for (name in obj) {
        value = obj[name];

        if (value instanceof Array) {
            for (i = 0; i < value.length; ++i) {
                subValue = value[i];
                fullSubName = name + '[' + i + ']';
                innerObj = {};
                innerObj[fullSubName] = subValue;
                query += param(innerObj) + '&';
            }
        }
        else if (value instanceof Object) {
            for (subName in value) {
                subValue = value[subName];
                fullSubName = name + '[' + subName + ']';
                innerObj = {};
                innerObj[fullSubName] = subValue;
                query += param(innerObj) + '&';
            }
        }
        else if (value !== undefined && value !== null)
            query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
    }

    return query.length ? query.substr(0, query.length - 1) : query;
};

var app = angular.module('o2o', ['ui.bootstrap', 'ngAnimate', 'ngCookies']);

app.controller('userCtrl', function ($scope, $http, $cookieStore) {
    $http.get('/rest/user/info').success(function (data) {
        $scope.user = data;
    })

    $http.get('/rest/location/info').success(function (data) {
        $scope.location = data;
        if (data && data.city && data.area) {
            var locations = $cookieStore.get('locations');
            if (!locations) {
                locations = [];
            }
            var found = false;
            for (var i = 0; i < locations.length; i++) {
                if (locations[i].city.cityId == data.city.cityId && locations[i].area.areaName == data.area.areaName) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                locations.push(data);
            }
            $cookieStore.put('locations', locations);
            console.log($cookieStore.get('locations'));
        }
    })
});

app.controller('SearchRestaurantCtrl', function ($scope, $http) {
    $scope.getRes = function () {
        return $http.get('/rest/restaurant/list/' + $scope.searchRes).then(function (response) {
            return response.data.map(function (item) {
                return item;
            });
        });
    };
});



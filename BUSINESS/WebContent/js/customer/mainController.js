app.controller('pageCtrl', function ($scope, $http) {
    $scope.resTypes = ['全部', '中餐', '西餐', '快餐', '饮料'];
    $scope.selectedResType = '全部';
    $scope.changeResType = function (type) {
        $scope.selectedResType = type;
        for (var i = 0; i < $scope.res.length; i++) {
            if (type == '全部' || !$scope.res[i].tags) {
                $scope.res[i].show = true;
            } else {
                $scope.res[i].show = $scope.res[i].tags.contains(type);
            }
        }
    };

    $scope.selectedSortType = 'default';
    $scope.changeSortType = function (type) {
        $scope.selectedSortType = type;
        if (type == 'default') {
            $scope.res.sort(function (a, b) {
                return a.id - b.id;
            });
        } else if (type == 'sales') {
            $scope.res.sort(function (a, b) {
                return b.sales - a.sales;
            });
        } else if (type == 'rating') {
            $scope.res.sort(function (a, b) {
                return b.rating - a.rating;
            });
        } else if (type == 'speed') {
            $scope.res.sort(function (a, b) {
                return b.time - a.time;
            });
        }
    };

    $http.get('/rest/restaurant/list').success(function (data) {
        console.info(data);
        $scope.res = data;
        $scope.changeResType($scope.selectedResType);
    });

    $scope.resPopoverTpl = "resPopoverTemplate.html";
})

app.controller('carouselCtrl', function ($scope) {
    $scope.interval = 5000;
    var slides = $scope.slides = [
        {
            img: 'images/350.jpg',
            href: '#'
        },
        {
            img: 'images/351.jpg',
            href: '#'
        }, {
            img: 'images/352.jpg',
            href: '#'
        }, {
            img: 'images/354.jpg',
            href: '#'
        }
    ];
});

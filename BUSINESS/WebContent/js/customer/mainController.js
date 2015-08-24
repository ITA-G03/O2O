app.controller('pageCtrl', function ($scope) {
    $scope.resTypes = ['全部', '中餐', '西餐', '快餐', '饮料'];
    $scope.selectedResType = '全部';
    $scope.changeResType = function (type) {
        $scope.selectedResType = type;
        for (var i = 0; i < $scope.res.length; i++) {
            if (type == '全部') {
                $scope.res[i].show = true;
            } else {
                $scope.res[i].show = $scope.res[i].tags.contains(type);
            }
        }
    }

    $scope.selectedSortType = 'default';
    $scope.changeSortType = function (type) {
        $scope.selectedSortType = type;
        if (type == 'default') {
            $scope.res.sort(function (a, b) {
                return a.id - b.id;
            })
        } else if (type == 'sales') {
            $scope.res.sort(function (a, b) {
                return b.sales - a.sales;
            })
        } else if (type == 'rating') {
            $scope.res.sort(function (a, b) {
                return b.rating - a.rating;
            })
        } else if (type == 'speed') {
            $scope.res.sort(function (a, b) {
                return b.time - a.time;
            })
        }
    }

    $scope.res = [
        {
            id: 1,
            name: '炸Tomcat',
            img: 'images/res.jpg',
            rating: 4.3,
            sales: 43,
            price: 20,
            time: 30,
            tags: ["西餐", '快餐'],
            show: true
        }, {
            id: 1,
            name: 'Tomcat汉堡',
            img: 'images/res1.jpg',
            rating: 1.3,
            sales: 43,
            price: 20,
            time: 30,
            tags: ["西餐", '快餐'],
            show: true
        }, {
            id: 1,
            name: 'Tomcat肉',
            img: 'images/res2.jpg',
            rating: 3.3,
            sales: 43,
            price: 20,
            time: 30,
            tags: ["中餐"],
            show: true
        }, {
            id: 1,
            name: '沙县Tomcat',
            img: 'images/res3.jpg',
            rating: 2,
            sales: 43,
            price: 20,
            time: 30,
            tags: ["中餐", '快餐'],
            show: true
        }, {
            id: 1,
            name: 'Tomcat煲',
            img: 'images/res4.jpg',
            rating: 5,
            sales: 13,
            price: 20,
            time: 30,
            tags: ["中餐"],
            show: true
        }, {
            id: 1,
            name: '炸Tomcat',
            img: 'images/res.jpg',
            rating: 4.3,
            sales: 43,
            price: 20,
            time: 30,
            tags: ["西餐", '快餐'],
            show: true
        }, {
            id: 1,
            name: 'Tomcat汉堡',
            img: 'images/res1.jpg',
            rating: 1.3,
            sales: 43,
            price: 20,
            time: 30,
            tags: ["西餐", '快餐'],
            show: true
        }, {
            id: 1,
            name: 'Tomcat肉',
            img: 'images/res2.jpg',
            rating: 3.3,
            sales: 43,
            price: 20,
            time: 30,
            tags: ["中餐"],
            show: true
        }, {
            id: 1,
            name: '沙县Tomcat',
            img: 'images/res3.jpg',
            rating: 2,
            sales: 43,
            price: 20,
            time: 30,
            tags: ["中餐", '快餐'],
            show: true
        }, {
            id: 1,
            name: 'Tomcat煲',
            img: 'images/res4.jpg',
            rating: 5,
            sales: 13,
            price: 20,
            time: 30,
            tags: ["中餐"],
            show: true
        }

    ];
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

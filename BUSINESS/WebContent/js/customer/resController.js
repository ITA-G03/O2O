app.controller('pageCtrl', function ($scope) {
    $scope.foodTypes = ['全部', '汉堡', '鸡肉卷', '配餐', '甜点', '饮料'];
    $scope.selectedFoodType = '全部';
    $scope.changeFoodType = function (type) {
        $scope.selectedFoodType = type;
    }

    $scope.commentTypes = ['好评', '中评', '差评'];
    $scope.selectedCommentType = '好评';
    $scope.changeCommentType = function (type) {
        $scope.selectedCommentType = type;
    }

    $scope.order = function () {
        location.href = 'order.html';
    }

    $scope.foods = [
        {
            id: 1,
            name: '香辣Tomcat堡',
            sales: 43,
            price: 8,
            type: '汉堡'
        },
        {
            id: 2,
            name: '炸Tomcat堡',
            sales: 43,
            price: 8,
            type: '汉堡'
        }, {
            id: 3,
            name: 'Tomcat卷',
            sales: 43,
            price: 8,
            type: '鸡肉卷'
        }, {
            id: 4,
            name: 'Tomcat血',
            sales: 43,
            price: 8,
            type: '饮料'
        }, {
            id: 5,
            name: '新奥尔良Tomcat腿',
            sales: 43,
            price: 8,
            type: '配餐'
        }, {
            id: 6,
            name: '香辣Tomcat堡',
            sales: 43,
            price: 8,
            type: '汉堡'
        },
        {
            id: 7,
            name: '炸Tomcat堡',
            sales: 43,
            price: 8,
            type: '汉堡'
        }, {
            id: 8,
            name: 'Tomcat卷',
            sales: 43,
            price: 8,
            type: '鸡肉卷'
        }, {
            id: 9,
            name: 'Tomcat血',
            sales: 43,
            price: 8,
            type: '饮料'
        }, {
            id: 10,
            name: '新奥尔良Tomcat腿',
            sales: 43,
            price: 8,
            type: '配餐'
        }, {
            id: 11,
            name: '香辣Tomcat堡',
            sales: 43,
            price: 8,
            type: '汉堡'
        },
        {
            id: 12,
            name: '炸Tomcat堡',
            sales: 43,
            price: 8,
            type: '汉堡'
        }, {
            id: 13,
            name: 'Tomcat卷',
            sales: 43,
            price: 8,
            type: '鸡肉卷'
        }, {
            id: 14,
            name: 'Tomcat血',
            sales: 43,
            price: 8,
            type: '饮料'
        }, {
            id: 15,
            name: '新奥尔良Tomcat腿',
            sales: 43,
            price: 8,
            type: '配餐'
        }, {
            id: 16,
            name: '香辣Tomcat堡',
            sales: 43,
            price: 8,
            type: '汉堡'
        },
        {
            id: 17,
            name: '炸Tomcat堡',
            sales: 43,
            price: 8,
            type: '汉堡'
        }, {
            id: 18,
            name: 'Tomcat卷',
            sales: 43,
            price: 8,
            type: '鸡肉卷'
        }, {
            id: 19,
            name: 'Tomcat血',
            sales: 43,
            price: 8,
            type: '饮料'
        }, {
            id: 20,
            name: '新奥尔良Tomcat腿',
            sales: 43,
            price: 8,
            type: '配餐'
        }

    ]

    $scope.comments = [
        {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }, {
            rating: 4,
            body: '老板为什么我的鸡米花套餐少了鸡米花',
            date: '2015-07-07'
        }

    ]

    $scope.cart = [];

    $scope.getCartValue = function () {
        var v = 0;
        for (var i = 0; i < $scope.cart.length; i++) {
            v += $scope.cart[i].price * $scope.cart[i].num;
        }
        return v;
    }

    $scope.addToCart = function (index) {
        var found = false;
        for (var i = 0; i < $scope.cart.length; i++) {
            if ($scope.cart[i].id == $scope.foods[index].id) {
                $scope.cart[i].num += 1;
                found = true;
                break;
            }
        }
        if (!found) {
            $scope.cart.push({
                id: $scope.foods[index].id,
                name: $scope.foods[index].name,
                price: $scope.foods[index].price,
                num: 1
            })
        }
    }

    $scope.more = function (index) {
        $scope.cart[index].num += 1;
    }
    $scope.less = function (index) {
        if ($scope.cart[index].num > 1) {
            $scope.cart[index].num -= 1;
        } else {
            $scope.cart[index].num = 0;
        }

    }
})

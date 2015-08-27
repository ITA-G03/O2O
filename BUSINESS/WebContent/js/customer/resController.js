app.controller('pageCtrl', function ($scope, $http, $aside) {
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

        window.location.href = '/order';
    }


    $http.get('/rest/restaurant/detail').success(function (data) {
        console.info(data.foodList);
        $scope.foods = data.foodList;
        $scope.detail = data;
        $scope.changeFoodType($scope.selectedFoodType);
    });

    $http.get('/rest/restaurant/list/comment').success(function (data) {
        console.info(data);
        $scope.comments = data;
        $scope.changeCommentType($scope.selectedCommentType);
    });

    $scope.cart = [];

    $http.get('/order/cart/session').success(function (data) {
        console.info(data);
        $scope.cart = !data ? [] : data.foodList;
    });

    $scope.getCartValue = function () {
        var v = 0;
        for (var i = 0; i < $scope.cart.length; i++) {
            v += $scope.cart[i].price * $scope.cart[i].num;
        }
        return v.toFixed(1);
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
        sendAjaxToAddSession();
    }

    var sendAjaxToAddSession = function () {
        $.ajax({
            url: '/order/cart/session',
            type: 'post',
            data: JSON.stringify($scope.cart),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
        });
    };

    $scope.more = function (index) {
        $scope.cart[index].num += 1;
        sendAjaxToAddSession();
    }

    $scope.less = function (index) {
        if ($scope.cart[index].num > 1) {
            $scope.cart[index].num -= 1;
        } else {
            $scope.cart.splice(index, 1);
        }
        sendAjaxToAddSession();
    }

    $scope.showFoodPic = function (index) {
        $aside.open({
            templateUrl: 'foodDetailTemplate.html',
            placement: 'left',
            size: 'sm',
            controller: 'foodDetailModalCtrl',
            resolve: {
                food: function () {
                    return $scope.foods[index];
                }
            }
        });
    }
})

app.controller('foodDetailModalCtrl', function ($scope, $modalInstance, food) {
    $scope.food = food;
});

$(function () {
    $('table').delegate('button[data-action=addToCart]', 'click', function () {
        var $this = $(this),
            thisOffset = $this.offset(),
            cartOffset = $('#cart-icon').offset();
        var lovelyBall = $('<i class="add-to-cart-ball"></i>');
        lovelyBall.css({
            top: thisOffset.top,
            left: thisOffset.left
        }).appendTo('body').fly({
            start: {
                top: thisOffset.top - $(window).scrollTop(),
                left: thisOffset.left
            },
            end: {
                left: cartOffset.left,
                top: cartOffset.top - $(window).scrollTop(),
            },
            autoPlay: true,
            speed: 1.5,
            vertex_Rtop: 100,
            onEnd: function () {
                this.destroy();
            }
        })
    })
})


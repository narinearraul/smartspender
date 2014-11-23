'use strict';

/* Controllers */

var EarnItController = angular.module('EarnItController', []);

EarnItController.controller('LoginController', ['$scope', '$http', '$location',
    function($scope, $http, $location) {


        var _username = null;
        var _isChild = true;

        $scope.login = function() {
            if(_isChild) {

                $location.path("/addItem");
            }
        }
    }]);

EarnItController.controller('myWishListController', ['$scope', '$http',
    function($scope, $http) {



        $http.get('/api/child/getItems')
        .success(function(data) {
            $scope.wishList = data;
                $scope.max = parseInt(data.price);
                $scope.value = parseInt(data.balance);
            //console.log(data);
        })
        .error(function(data) {
            console.log('Error: ' + data);
        });
    }]);


EarnItController.controller('myChoreListController', ['$scope', '$http',
    function($scope, $http) {

        $scope.checkOffSingleChore = function(choreId) {
            console.log("HELLLO");
            $http.post('/api/child/checkOffSingleChore/'+ choreId)
            .success(function(data) {
                $scope.chores = data;
                console.log(data);
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
        }

        $http.get('/api/child/getChores')
            .success(function(data) {
                $scope.chores = data;
                console.log(data);
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
    }]);

EarnItController.controller('addItemController', ['$scope', '$http', '$location',
    function($scope, $http, $location) {


        $scope.item = {
            itemName: null,
            price: 0,
            balance: 0
        };


        $scope.addItem = function() {
            $http.post('/api/child/addItem', $scope.item)
                .success(function(data) {
                    //$scope.wishList = data;
                    console.log(data);
                    $location.path("/myWishList");
                })
                .error(function(data) {
                    console.log('Error: ' + data);
                });
        }
    }]);


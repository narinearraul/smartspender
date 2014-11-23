'use strict';

//Define an angular module for our app
var EarnItApp = angular.module('EarnItApp', [
    'EarnItController',
    'ui.bootstrap'
]);

EarnItApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'partials/login.ejs',
                controller: 'LoginController'
            }).
            when('/myWishList', {
                templateUrl: 'partials/myWishList.ejs',
                controller: 'myWishListController'
            }).
            when('/myChoreList', {
                templateUrl: 'partials/myChoreList.ejs',
                controller: 'myChoreListController'
            }).
            when('/addItem', {
                templateUrl: 'partials/addItem.ejs',
                controller: 'addItemController'
            }).
            otherwise({
                redirectTo: '/404.ejs'
            });
    }]);


//// public/core.js
//var Earnit = angular.module('Earnit', []);
//
//function mainController($scope, $http) {
//    $scope.formData = {};
//
//    // when landing on the page, get all todos and show them
//    $http.get('/api/todos')
//        .success(function(data) {
//            $scope.todos = data;
//            console.log(data);
//        })
//        .error(function(data) {
//            console.log('Error: ' + data);
//        });
//
//    // when submitting the add form, send the text to the node API
//    $scope.createTodo = function() {
//        $http.post('/api/todos', $scope.formData)
//            .success(function(data) {
//                $scope.formData = {}; // clear the form so our user is ready to enter another
//                $scope.todos = data;
//                console.log(data);
//            })
//            .error(function(data) {
//                console.log('Error: ' + data);
//            });
//    };
//
//    // delete a todo after checking it
//    $scope.deleteTodo = function(id) {
//        $http.delete('/api/todos/' + id)
//            .success(function(data) {
//                $scope.todos = data;
//                console.log(data);
//            })
//            .error(function(data) {
//                console.log('Error: ' + data);
//            });
//    };
//
//}

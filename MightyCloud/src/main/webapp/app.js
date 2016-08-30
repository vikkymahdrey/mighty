var mightyApp = angular.module('mighty', ['ngRoute']);

mightyApp.config(function($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl : 'views/login.html'
        })
        .when('/admin', {
        	templateUrl : 'views/admin.html'
        })
        // route for the about page
        ;
});

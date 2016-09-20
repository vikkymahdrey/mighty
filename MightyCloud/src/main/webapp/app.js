var mightyApp = angular.module('mighty', ['ngRoute','ui.bootstrap']);

mightyApp.config(function($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl : 'views/login.html'
        })
        .when('/admin', {
        	templateUrl : 'views/admin.html'
        })
        .when('/device', {
        	templateUrl : 'views/device.html',
        	controller : "deviceController"
        })
        // route for the about page
        ;
});

mightyApp.constant('config', {
    restURL: 'http://localhost:8080/MightyCloud/rest',
    restAllDevice:"/device"
});

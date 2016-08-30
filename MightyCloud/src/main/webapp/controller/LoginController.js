/**
 * 
 */
mightyApp.controller('loginController', function($scope,$location) {
	
	$scope.login = function() {
		console.log("LoginController.login");
		console.log("User Name " + $scope.userName);
		console.log("User Password " + $scope.password);
		
		$location.path('/admin')
	}
});
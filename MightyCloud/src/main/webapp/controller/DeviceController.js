/**
 * 
 */
mightyApp.controller('deviceController', function( $scope,$location, $http) {
	
	$scope.listAllDevice = function() {
		console.log("DeviceController.listAllDevice");
		$http.get("http://localhost:8080/MightyCloud/rest/admin/device").
		then(function success(response){
			console.log(response.data);
		}, function error(response) {
			console.log(reponse);
		})
		
	}
});
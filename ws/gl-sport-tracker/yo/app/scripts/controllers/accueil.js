'use strict';

angular.module('yoApp')
.controller('AccueilCtrl', function ($scope, $location, $cookieStore) {

    $scope.isAuthentified = $cookieStore.get('user-session');
    
	 if($scope.isAuthentified  == null){
		//$cookieStore.put("user-session", "active");
		
		$location.path('/login');
	}
	else{
		console.log("No");
	}
 });

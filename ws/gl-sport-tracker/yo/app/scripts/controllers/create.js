'use strict';

angular.module('yoApp')
.controller('CreateCtrl', function ($scope, $location, $cookieStore, User) {
	
	$scope.isAuthentified = $cookieStore.get('user-session');
	$scope.correctFields = true;
	$scope.user = new Object();
	
	if($scope.isAuthentified  == 'active'){
		$location.path('accueil');
	}
	else{
		$scope.createUser = function(myForm){			
			if(myForm.$valid) {
				var response = User.save({},$scope.user);
				
				if(response == null){
					$cookieStore.put("user-session", "active");
					$cookieStore.put("user-id", "15");
					$location.path('accueil');
				}
			}
			else{
				$scope.correctFields = false;
			}
		}
	}
    
 });

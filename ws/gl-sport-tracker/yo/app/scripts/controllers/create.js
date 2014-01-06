'use strict';

angular.module('yoApp')
.controller('LoginCtrl', function ($scope, $location, $cookieStore, User) {
	
	$scope.isAuthentified = $cookieStore.get('user-session');
	
	if($scope.isAuthentified  == 'active'){
		$location.path('accueil');
	}
	else{
		$scope.incorrect = false;
		
		$scope.createUser = function(loginForm){
			if(createUserForm.$valid) {
				// Test creation USER
				var user = new Object();
				user.firstName = "Florian";
				user.lastName = "Leloup";
				user.sex= 1;
				user.size = 190;
				user.mail = "test@test.fr";
				user.pseudo = "test";
				var response = User.save({},user);				
			}
			else{
				$scope.incorrect = true;
			}
		}
	}
    
 });

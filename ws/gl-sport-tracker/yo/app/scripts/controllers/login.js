'use strict';

angular.module('yoApp')
.controller('LoginCtrl', function ($scope, $location, $cookieStore, User) {
	
	$scope.isAuthentified = $cookieStore.get('user-session');
	    
	if($scope.isAuthentified  == 'active'){
		$location.path('/accueil');
	}
	else{

		$scope.user = User.query();
		console.log($scope);
		/*$scope.connexion = function(loginForm){
			if(loginForm.$valid) {
		          //Traitement ici...
		          console.log("valid");
		          console.log(loginForm.login.$modelValue);
		          console.log(loginForm.password.$modelValue);
		          User.query();
		     }
		}*/
	}
    
 });

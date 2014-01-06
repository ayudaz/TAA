'use strict';

angular.module('yoApp')
.controller('LoginCtrl', function ($scope, $location, $cookieStore, User) {
	
	$scope.isAuthentified = $cookieStore.get('user-session');
	
	if($scope.isAuthentified  == 'active'){
		$location.path('accueil');
	}
	else{
		$scope.incorrect = false;
		
		$scope.connexion = function(loginForm){
			if(loginForm.$valid) {
				$scope.user = User.connexion({email: loginForm.login, mdp: loginForm.password});
				//	FAIRE UNE REQUETE QUI GERE LA CONNEXION ET QUI RENVOIE UN USER
				// IF USER.isValid DO
				/*if(true){
					$cookieStore.put("user-session", "active");
					$cookieStore.put("user-id", "14");
					$location.path('accueil');
				}
				//ELSE DO
				else{
					$location.path('login');
				}*/
		     }
		}
	}
    
 });

'use strict';

angular.module('yoApp')
.controller('LoginCtrl', function ($scope, $location, $cookieStore, User, Connexion) {
	
	$scope.isAuthentified = $cookieStore.get('user-session');
	$scope.infosConnexion = new Object();
	
	if($scope.isAuthentified  == 'active'){
		$location.path('accueil');
	}
	else{
		$scope.incorrect = false;
		
		$scope.connexion = function(loginForm){
			if(loginForm.$valid) {
				
				var result = Connexion.get({email : $scope.infosConnexion.login, mdp:$scope.infosConnexion.password});
				
				result.$promise.then(
			      function( value ){
			    	  if(value.id != null){
						$cookieStore.put("user-session", "active");
						$cookieStore.put("user-id", value.id);
						$location.path('accueil');
			    	  }
			    	  else{
			    		  $scope.badLogin = true;
			    	  }
			      },
			      function( error ){
			    	  $scope.erreurServeur = true;
			      }
			   );
				
				//$scope.user = $resource('rest/users/:email/:mdp', { email: loginForm.login, mdp: loginForm.password });
				//User.connexion({email: loginForm.login, mdp: loginForm.password});
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

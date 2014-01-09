'use strict';

angular.module('yoApp')
.controller('LoginCtrl', function ($rootScope,$scope, $location, $cookieStore, User, Connexion, Page) {
	
	$scope.isAuthentified = $cookieStore.get('user-session');
	$scope.infosConnexion = new Object();
	
	Page.setCurrent("login");
	
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
		     }
		}
	}
    
 });

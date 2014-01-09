'use strict';

angular.module('yoApp')
.controller('CreateCtrl', function ($rootScope, $scope, $location, $cookieStore, User) {
	
	$scope.isAuthentified = $cookieStore.get('user-session');
	$scope.correctFields = true;
	$scope.stillUsed = true;
	$scope.user = new Object();
	
	if($scope.isAuthentified  == 'active'){
		$location.path('accueil');
	}
	else{
		$scope.createUser = function(myForm){			
			if(myForm.$valid){				
				var result = User.save({},$scope.user);
				
				result.$promise.then(
			      function( value ){
			    	  if(value.id != null){
						$cookieStore.put("user-session", "active");
						$cookieStore.put("user-id", value.id);
						$location.path('accueil');
			    	  }
			    	  else{
			    		  $scope.stillUsed = false;
			    	  }
			      },
			      function( error ){
			    	  $scope.erreurServeur = true;
			      }
			   );
			}
			else{
				$scope.correctFields = false;
			}
		}
	}
    
 });

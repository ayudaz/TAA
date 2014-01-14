'use strict';

angular.module('yoApp')
.controller('CreateCtrl', function ($rootScope, $scope, $location, $cookieStore, User) {
	
	$scope.isAuthentified = $cookieStore.get('user-session');
	$scope.correctFields = true;
	$scope.stillUsed = false;
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
			    	  console.log(value);
			    	  if(value[0] != 0){
							$cookieStore.put("user-session", "active");
							$cookieStore.put("user-id", value[0]);
							$location.path('accueil');
			    	  }
			    	  else{
			    		  	$scope.stillUsed = true;
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

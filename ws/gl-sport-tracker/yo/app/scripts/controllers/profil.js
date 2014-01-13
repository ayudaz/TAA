'use strict';

angular.module('yoApp')
.controller('ProfilCtrl', function ($rootScope, $scope, $location, $cookieStore, User, Page) {

    $scope.isAuthentified = $cookieStore.get('user-session');
    $scope.userId = $cookieStore.get('user-id');
    
	Page.setCurrent("profil");
    
	if($scope.isAuthentified  == null || $scope.userId == null){		
		$location.path('/login');
	}
	else{
	    $scope.user = User.get({userId: $scope.userId});
    	$scope.correctFields = true;
    	
	    var currentURI = $location.path();
	    var tabURI = currentURI.split('/');
	    
	    if(tabURI.indexOf("all") != -1){
	    	$scope.type = 'all';
	    }
	    else if(tabURI.indexOf("password") != -1){
	    	$scope.type = 'password';
	    }
	    else{
	    	$scope.type = 'all';
	    }
	    

    	$scope.updateUser = function(myForm){			
			if(myForm.$valid){				
				var result = User.update({userId:$scope.userId},$scope.user);
				
				result.$promise.then(
			      function( value ){
			    	  $location.path('profil');
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

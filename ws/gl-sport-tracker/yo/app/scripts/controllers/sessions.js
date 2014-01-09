angular.module('yoApp')
.controller('SessionsCtrl', function ($rootScope, $scope, $location, $cookieStore, User, Page) {

    $scope.isAuthentified = $cookieStore.get('user-session');
    $scope.userId = $cookieStore.get('user-id');
    

	 Page.setCurrent("sessions");
    
	if($scope.isAuthentified  == null || $scope.userId == null){		
		$location.path('/login');
	}
	else{
	    $scope.user = User.get({userId: $scope.userId});
    	$scope.correctFields = true;
    	
	    var currentURI = $location.path();
	    var tabURI = currentURI.split('/');
	    
	    if(tabURI.indexOf("all") != -1){
	    	console.log("We go there");
	    	$scope.type = 'all';
	    }
	    else if(tabURI.indexOf("password") != -1){
	    	console.log("WE go there");
	    	$scope.type = 'password';
	    }
	    else{
	    	$scope.type = 'all';
	    }
	}
 });

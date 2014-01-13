angular.module('yoApp')
.controller('SessionsCtrl', function ($rootScope, $scope, $location, $cookieStore, User, Session, Page) {

    $scope.isAuthentified = $cookieStore.get('user-session');
    $scope.userId = $cookieStore.get('user-id');

	Page.setCurrent("sessions");
    
	if($scope.isAuthentified  == null || $scope.userId == null){		
		$location.path('/login');
	}
	else{
	    $scope.user = User.get({userId: $scope.userId});
    	$scope.correctFields = true;
    	

    	$scope.erreurServeur = false;
    	
    	$scope.userSessions = Session.getAll();
    	
    	$scope.newSession = new Object();
    	
    	$scope.createSession = function(myForm) {			
			if(myForm.$valid){

		    	var start = new Date();		    	
		    	var end = new Date();
		    	
		    	$scope.newSession.startDate = start;
		    	$scope.newSession.endDate = end;
		    	
				var result = Session.save({},$scope.newSession);
				
				result.$promise.then(
			      function( value ){
			    	  if(value.id != null){
			    		  $location.path('sessions');
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
		};
    	
    	var currentURI = $location.path();
	    var tabURI = currentURI.split('/');
	    var indexOfSession = tabURI.indexOf("session");
	    
	    if(indexOfSession != -1){
	    	if(tabURI.length > (indexOfSession+1)){
	    		var sessionID = tabURI[indexOfSession+1];
	    		
	    		if(!isNaN(sessionID)){
		    		var session = Session.get({sessionId: sessionID});
		    		
		    		if(session == null){
		    			$location.path('/404');
		    		}
		    		else{
		    			console.log("HERE");
		    			$scope.session = session;
		    			console.log(session);
		    			console.log($scope);
		    			$scope.existSession = true;
		    		}
	    		}
	    	}
	    }
	    else{
	    	$scope.existSession = false;
	    }
	    
	    
	}
 });

angular.module('yoApp').filter('formatDate', function() {
  return function(input) {
    return convertTimestampToFormatedDate(input);
  };
});
'use strict';

angular.module('yoApp')
.controller('AccueilCtrl', function ($rootScope, $scope, $location, $cookieStore, User,Page, Session) {

    $scope.isAuthentified = $cookieStore.get('user-session');
    $scope.userId = $cookieStore.get('user-id');

	Page.setCurrent("accueil");
	
    if($scope.isAuthentified  == null || $scope.userId == null){		
		$location.path('/login');
	}
	else{
	    $scope.user = User.get({userId: $scope.userId});
	    $scope.sessions = Session.get({userId: $scope.userId});
	    //$scope.user.sessions = Session.getAll();
	    console.log($scope.user);
	    console.log($scope.sessions);
	    //console.log($scope.user.sessions);
	    //console.log($scope.user.sessions.length);
	}
 });

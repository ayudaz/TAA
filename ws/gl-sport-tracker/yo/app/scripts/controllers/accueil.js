'use strict';

angular.module('yoApp')
.controller('AccueilCtrl', function ($rootScope, $scope, $location, $cookieStore, User,Page) {

    $scope.isAuthentified = $cookieStore.get('user-session');
    $scope.userId = $cookieStore.get('user-id');

	Page.setCurrent("accueil");
	
    if($scope.isAuthentified  == null || $scope.userId == null){		
		$location.path('/login');
	}
	else{
	    $scope.user = User.get({userId: $scope.userId});
	    //console.log($scope.user);
	}
 });

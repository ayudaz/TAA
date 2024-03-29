'use strict';

angular.module('yoApp')
.controller('AmisCtrl', function ($rootScope, $scope, $location, $cookieStore, User,Page) {

    $scope.isAuthentified = $cookieStore.get('user-session');
    $scope.userId = $cookieStore.get('user-id');

	Page.setCurrent("amis");
	
    if($scope.isAuthentified  == null || $scope.userId == null){		
		$location.path('/login');
	}
	else{
	    $scope.allUser = User.getAll();
	    $scope.predicate = 'lastName';
	    $scope.reverse = false;
	}
 });
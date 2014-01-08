'use strict';

angular.module('yoApp')
.controller('AccueilCtrl', function ($scope, $location, $cookieStore, User) {

    $scope.isAuthentified = $cookieStore.get('user-session');
    $scope.userId = $cookieStore.get('user-id');
    
    $scope.currentPage = "accueil";
    
	if($scope.isAuthentified  == null || $scope.userId == null){		
		$location.path('/login');
	}
	else{
	    $scope.user = User.get({userId: $scope.userId});
	    console.log($scope.user);
	}
 });

'use strict';

angular.module('yoApp')
.controller('AccueilCtrl', function ($scope, $location, $cookieStore, User) {

    $scope.isAuthentified = $cookieStore.get('user-session');
    $scope.currentPage = "accueil";
    
	if($scope.isAuthentified  == null){		
		$location.path('/login');
	}
	else{
	    $scope.userId = $cookieStore.get('user-id');
	    console.log("ID :"+$scope.userId);
	    $scope.user = User.get({userId: $scope.userId});
	    
	    console.log($scope);
	}
 });

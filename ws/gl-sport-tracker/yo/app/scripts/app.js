'use strict';

var app = angular.module('yoApp', [
                         'ngCookies',
                         'ngResource',
                         'ngSanitize',
                         'ngRoute'
                       ])
.config(function($locationProvider, $routeProvider) {
  $routeProvider
    .when('/', {
      templateUrl: 'views/main/accueil.html', 
      controller: 'AccueilCtrl'
    })
    .when('/accueil', {
    	templateUrl: 'views/main/accueil.html', 
        controller: 'AccueilCtrl'
    })
    .when('/profil', {
    	templateUrl: 'views/profil/profil.html', 
      controller:  'ProfilCtrl'
    })
    .when('/profil/edit/:typeOfEdit', {
    	templateUrl: 'views/profil/profil-edit.html', 
      controller:  'ProfilCtrl'
    })  
    .when('/session', {
    	 templateUrl: 'views/sessions/sessions.html', 
      controller:  'SessionsCtrl'
    })
    .when('/session/new', {
    	 templateUrl: 'views/sessions/session-new.html', 
      controller:  'SessionsCtrl'
    })
     .when('/session/:sessionId', {
    	 templateUrl: 'views/sessions/session-detail.html', 
      controller:  'SessionsCtrl'
    })
    .when('/amis', {
    	templateUrl: 'views/amis/amis.html', 
      controller:  'AmisCtrl'
    })
    .when('/login', {
    	templateUrl: 'views/main/login.html', 
      controller:  'LoginCtrl'
    })
    .when('/create', {
    	templateUrl: 'views/main/create.html', 
      controller:  'CreateCtrl'
    })      
    .when('/404', {
    	templateUrl: 'views/main/404.html', 
      controller: 'NotFoundCtrl'
    })
    .otherwise({ redirectTo: '/404' });
  
});


app.factory('User', ['$resource', function($resource) {
	return $resource('rest/users/:userId', { userId: '@userId' }, 
			{ update: { method: 'PUT' }
		});
}]);

app.factory('Connexion', ['$resource', function($resource) {
	return $resource('rest/users/:email/:mdp', { email: '@email', mdp:'@mdp' }, {});
}]);


app.factory('Session', ['$resource', function($resource) {
	return $resource('rest/sessions/:userId', 
		{ userId: '@userId' }, { 
			specialMethod: { method: 'PUT', params: { bookId: '@userId' }, isArray: false }
		});

}]);

app.factory('Page', function($rootScope){
    var currentPage = "";
    
    return {
        page:function(){
            return currentPage;
        },
        setCurrent:function(newCurrent){
             currentPage = newCurrent;
        }
    }
});

app.controller('MainCtrl', function ($scope, $location, $cookieStore, User, Connexion, Page) {
	console.log('MainCTRL....');
	
	$scope.isAuthentified = $cookieStore.get('user-session');
    $scope.userId = $cookieStore.get('user-id');
    
    $scope.page = Page;
    
	if($scope.isAuthentified  == null || $scope.userId == null){	
		$location.path('/login');
	}
	else{
		console.log("Determination de l'URL");
		var currentURI = $location.path();
		var tabURI = currentURI.split('/');

		 if(tabURI.length >0){
			 Page.setCurrent(tabURI[1]);
			 console.log(Page.page);
		 }
	}
	
	$scope.deco = function() {
		console.log("On trouve bien la fonction...");
		if($cookieStore.get('user-session') == 'active'){
			console.log("Deconexion...");
			$cookieStore.remove('user-session');
			$cookieStore.remove('user-id');
			$location.path('/login');
		}
	};
	    
 });
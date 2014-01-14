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
    .when('/about', {
    	templateUrl: 'views/main/about.html', 
    })  
    .when('/404', {
    	templateUrl: 'views/main/404.html', 
      controller: 'NotFoundCtrl'
    })
    .otherwise({ redirectTo: '/404' });
  
});


app.factory('User', ['$resource', function($resource) {
	return $resource('rest/users/:userId', { userId: '@userId' }, 
			{ update: { method: 'PUT' },
			  getAll: {method: 'GET', isArray: true }
		});
}]);

app.factory('Connexion', ['$resource', function($resource) {
	return $resource('rest/users/:email/:mdp', { email: '@email', mdp:'@mdp' }, {});
}]);


app.factory('Session', ['$resource', function($resource) {
	return $resource('rest/sessions/:sessionId', 
		{ sessionId: '@sessionId' }, { 
			specialMethod: { method: 'PUT', params: { bookId: '@userId' }, isArray: false },
			getAll: { method: 'GET', isArray: true }
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
    };
});

app.controller('MainCtrl', function ($scope, $location, $cookieStore, User, Connexion, Page) {
	
	$scope.isAuthentified = $cookieStore.get('user-session');
    $scope.userId = $cookieStore.get('user-id');
    
    $scope.page = Page;
    
	if($scope.isAuthentified  == null || $scope.userId == null){	
		$location.path('/login');
	}
	else{
		var currentURI = $location.path();
		var tabURI = currentURI.split('/');

		 if(tabURI.length >0){
			 Page.setCurrent(tabURI[1]);
			 console.log(Page.page);
		 }
	}
	
	$scope.deco = function() {
		if($cookieStore.get('user-session') == 'active'){
			$cookieStore.remove('user-session');
			$cookieStore.remove('user-id');
			$location.path('/login');
		}
	};
	    
 });

function convertTimestampToFormatedDate(timestamp){
	var date = new Date(timestamp);
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var seconds = date.getSeconds();
	var month = parseInt(date.getMonth()+1);
	var day = parseInt(date.getUTCDate()+1);
	var year = date.getFullYear();
	
	var formattedTime = day+'/'+month+'/'+year+' '+hours + ':' + minutes + ':' + seconds;

	
	return formattedTime;
}
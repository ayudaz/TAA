'use strict';

var app = angular.module('yoApp', [
                         'ngCookies',
                         'ngResource',
                         'ngSanitize',
                         'ngRoute'
                       ])
.config(function($locationProvider, $routeProvider) {
  //$locationProvider.html5Mode(true);
  $routeProvider
    .when('/', {
      templateUrl: 'views/accueil.html', 
      controller: 'AccueilCtrl'
    })
    .when('/accueil', {
    	templateUrl: 'views/accueil.html', 
        controller: 'AccueilCtrl'
    })
    .when('/profil/:profilId', {
    	templateUrl: 'views/profil.html', 
      controller:  'ProfilCtrl'
    })
     .when('/courses/:profilId', {
    	 templateUrl: 'views/courses.html', 
      controller:  'CourseCtrl'
    })
    .when('/amis/:profilId', {
    	templateUrl: 'views/amis.html', 
      controller:  'AmisCtrl'
    })
    .when('/login', {
    	templateUrl: 'views/login.html', 
      controller:  'LoginCtrl'
    })
    .when('/create', {
    	templateUrl: 'views/create.html', 
      controller:  'CreateCtrl'
    })      
    .when('/404', {
    	templateUrl: 'views/404.html', 
      controller: 'NotFoundCtrl'
    })
    .otherwise({ redirectTo: '/' });
});

app.factory('User', ['$resource', function($resource) {
	return $resource('rest/users/:userId', 
		{ userId: '@userId' }, { 
			loan: { 
				method: 'PUT', 
				params: { bookId: '@userId' }, 
				isArray: false 
			}
		});

}]);

app.factory('User', ['$resource', function($resource) {
	return $resource('rest/users/:userId', 
		{ userId: '@userId' }, { 
			specialMethod: { method: 'PUT', params: { bookId: '@userId' }, isArray: false },
			connexion : {method: 'GET', params: {email: '@email', mdp: '@mdp'}}
			/*get: { method : 'GET', isArray : true}*/
		});

}]);

app.factory('Session', ['$resource', function($resource) {
	return $resource('rest/sessions/:userId', 
		{ userId: '@userId' }, { 
			specialMethod: { method: 'PUT', params: { bookId: '@userId' }, isArray: false }
		});

}]);
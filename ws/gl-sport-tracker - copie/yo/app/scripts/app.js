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
    .when('/404', {
    	templateUrl: 'views/404.html', 
      controller: 'NotFoundCtrl'
    })
    .otherwise({ redirectTo: '/' });
});

app.factory('User', ['$resource', function($resource) {
	console.log("On vient bien la...");
	return $resource('rest/users/:userId', 
		{ userId: '@userId' }, { 
			loan: { 
				method: 'PUT', 
				params: { bookId: '@userId' }, 
				isArray: false 
			}
		});

}]);
/**
 * 
 */

var Bookmark=angular.module('Bookmark',['ngRoute']);

/* Configuration for routing */
Bookmark.config(function($routeProvider){
	/* route for home */
	$routeProvider.when('/',{
		controller:"HomeController",
		templateUrl:"home"
	})
	
	/* route for login */
	.when('/login',{})
	
	/* route for register */
	.when('/register',{
		controller:"RegisterController",
		templateUrl:"register"
	})
	
	/* otherwise, route to error page */
	.otherwise({});
})
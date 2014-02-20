/**
 * 
 */

var BookmarkHome=angular.module('BookmarkHome',['ngRoute']);

/* Configuration for routing */
BookmarkHome.config(function($routeProvider){
	/* route for home */
	$routeProvider.when('/',{
		controller:"HomeController",
		templateUrl:"home"
	})
	
	/* route for login */
	.when('/login',{
		controller:"LoginController",
		templateUrl:"login"
	})
	
	/* route for register */
	.when('/register',{
		controller:"RegisterController",
		templateUrl:"register"
	})
	
	/*route for bookmakrs*
	.when('../bookmarks/:option',{
		controller:"BookmarkListController",
		templateUrl:"bookmarks/page/:option"
	})*/
	
	/* otherwise, route to error page */
	.otherwise({});
})
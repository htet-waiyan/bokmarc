var Bookmark=angular.module('Bookmark',['ngRoute']);

Bookmark.config(['$routeProvider',function($routeProvider){
	/*
	 * route to bookmarks/something,
	 * REST style url
	 * */
	$routeProvider.when('/',{
		controller:'BookmarkController',
		templateUrl:'page/all'
	})
}]);
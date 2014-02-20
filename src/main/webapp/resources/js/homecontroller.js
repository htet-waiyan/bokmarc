BookmarkHome.controller("HomeController",function($scope){
	console.log('In the homecontroller');
	$scope.about='Bookmark is a simple cloud-based personal bookmark application'+
				'Just drag and drop the bookmarklet below onto the bookmark bar of your'+
				'browser';
	
	$scope.how='Bookmark works on every device and every browser. Your bookmarks'+
		'will not be share so that you can bookmark safely and privetly. This'+
		'application is used for personal only.';
})
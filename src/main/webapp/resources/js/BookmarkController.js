Bookmark.factory("BookmarkService",function($http){
	var bookmarks={}
	
	bookmarks.retrieve=function(param,callback){
		$http({
			method:'GET',
			url:'api/'+param
		}).success(function(data,status){
			callback(data);
		}).error(function(data,status){
			
		})
	}
	
	bookmarks.search=function(data,callback){
		$http({
			method:'POST',
			url:'../bookmarks/search',
			params:JSON.stringify(data)
		}).success(function(data,status){
			
		}).error(function(data,status){
			callback(data.msgBody,'error');
		});
	},
	
	bookmarks.add=function(data,callback){
		$http.post('../bookmarks/add',data,{
			cache:false,
			headers:{'Content-Type':'application/x-www-form-urlencoded'},
			transformRequest:function(data){
				if(data===undefined)
					return data;
				
				return $.param(data);
			},
			responseType:'json'
		}).success(function(data,status,headers,config){
			$('.add-form').hide();
			console.log(data);
			callback(data,'success');
		}).error(function(data,status,headers,config){
			console.log(status);
			if(status==500)
				callback('Server error! Try again later.','error');
		});
	};
	
	return bookmarks;
});

Bookmark.controller("BookmarkController",function($scope,BookmarkService){
	$scope.formData={};
	
	BookmarkService.retrieve('all',function(data){
		$scope.bookmarks=data;
	});
	
	$scope.save=function(){
		$scope.submitted=true;
		
		if($scope.bookmakrForm.$valid){
			console.log('saving....');
			BookmarkService.add($scope.formData,function(data,type){
				if(type=='error'){
					$scope.show=true;
					$scope.msg=data;
					$scope.type=type;
				}
				else{
					console.log(data.caption);
				
					$scope.test=data;
				}
			});
		}
	}
	
	var bind=function(newData,clear){
		$scope.bookmarks.unshift(newData);
		clear();
	}
});
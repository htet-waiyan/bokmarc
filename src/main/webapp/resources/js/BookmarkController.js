Bookmark.factory("BookmarkService",function($http){
	var bookmarks={}
	
	bookmarks.retrieve=function(param,callback){
		$http({
			method:'GET',
			url:'api/'+param
		}).success(function(data,status){
			callback(data,'success');
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
			callback(data,'success');
		}).error(function(data,status,headers,config){
			if(status==500)
				callback('Server error! Try again later.','error');
		});
	};
	
	bookmarks.removeBookmark=function(id,callback){
		var delParam={bookmarkID:id};
		$http({
			method:'GET',
			url:'../bookmarks/delete',
			params:delParam,
			transformRequest:function(data){
				if(data===undefined)
					return data;
				
				return $.param(data);
			},
			responseType:'json'
		}).success(function(data,status,headers,config){
			callback(data,'success');
		}).error(function(data,status,headers,config){
			
		})
		
		delParam=null;
	}
	
	return bookmarks;
});

Bookmark.controller("BookmarkController",function($scope,BookmarkService){
	$scope.formData={};
	
	BookmarkService.retrieve('all',function(data,msg){
		if(msg=='success')
			$scope.bookmarks=data;
	});
	
	$scope.test=function(obj){
		console.log(obj.caption);
	}
	
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
					$scope.submitted=false;
				
					bind(data,function(){
						$scope.formData=null;
					});
				}
			});
		}
	}
	
	$scope.remove=function(id,index){
		
		BookmarkService.removeBookmark(id,function(data,type){
			if(type=='success')
				$scope.bookmarks.splice(index,1);
		})
	}
	
	var bind=function(newData,clear){
		$scope.bookmarks.unshift(newData);
		clear();
	}
});

BookmarkHome.factory("RegisterService",function($http){
	var Data={
		submit:function(data,callback){
			$http({
				method:'POST',
				url:'register',
				data:data
			}).success(function(data,status){
				//console.log(data.msgBody);
				callback(data.msgBody,'success');
			}).error(function(data,status){
				console.log(status+" data : "+data);
				//return data;
				callback(data.msgBody,'error');
			});
		}
	}
	
	return Data;
});

BookmarkHome.controller("RegisterController",function($scope,RegisterService){
	$scope.formData={};
	
	$scope.submit=function(){
		$scope.submitted=true;
		
		if($scope.registerForm.$valid){
			
			RegisterService.submit($scope.formData,function(data,type){
				$scope.show=true;
				$scope.type=type;
				$scope.msg=data;
				console.log("Data : "+$scope.msg);
			
			});
		}
	}
})
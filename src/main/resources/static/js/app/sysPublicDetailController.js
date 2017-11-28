var app = angular.module('app', []);
app.controller('publicDetailCtrl', function($scope) {
   	$scope.querypublicDetail= function(){
   		var sysId = localStorage.getItem('sysId') ;
   		getData('/sysConfig/getSysPublicById/'+sysId,function(result){
	   		$scope.public = result.data ;
	   		$scope.$apply();
   		}) ;
    }
   	$scope.querypublicDetail();
   	
});
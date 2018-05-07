var app = angular.module('app', []);
app.controller('stakeUnStoreCtrl', function($scope) {
   	$scope.queryStakeUnStoreList= function(){
   			getData('/stations/getStakeCompareMap',function(result){
	   		$scope.unstakes = result.data ;
	   		$scope.$apply();
   		}) ;
    }
   	$scope.queryStakeUnStoreList();
   
});
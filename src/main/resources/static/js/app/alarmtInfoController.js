var app = angular.module('app', []);
app.controller('alermInfosCtrl', function($scope) {
   	$scope.queryAlarmInfos = function(){
   			var userId = localStorage.getItem('userId');
   			var orgId = localStorage.getItem('orgId') ;
   			//userId+"/"+orgId
   			///8abd94485bad1520015bad76efd0002f/297edff84d677b77014d69d81b7b001e
   			getData('/stations/getAlarmInfosByUserIdAndOrgId/'+userId+"/"+orgId,function(result){
	   		$scope.alarms = result.data ;
	   		$scope.$apply();
   		}) ;
    }
   	$scope.queryAlarmInfos();
   
});

app.controller('faultInfosCtrl', function($scope) {
   	$scope.queryAlarmInfos = function(){
   			var userId = localStorage.getItem('userId');
   			var orgId = localStorage.getItem('orgId') ;
   			//userId+"/"+orgId
   			///8abd94485bad1520015bad76efd0002f/297edff84d677b77014d69d81b7b001e
   			getData('/stations/getFaultInfosByUserIdAndOrgId/'+userId+"/"+orgId,function(result){
	   		$scope.faults = result.data ;
	   		$scope.$apply();
   		}) ;
    }
   	$scope.queryAlarmInfos();
   
});

app.filter('statusFilter', function() {  
		return function(input,name){
			if(input == name){
				return true ;
			}
		};
});
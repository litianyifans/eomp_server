var app = angular.module('app', []);
app.controller('stationDetailCtrl', function($scope, $filter,$http,$rootScope) {
   	$scope.queryStationDetail = function(){
   			localStorage.getItem('stationId');
   			localStorage.getItem('stationName');
   			localStorage.getItem('chargeCount');
   			localStorage.getItem('freeCount');
   			localStorage.getItem('faultCount');
   			localStorage.getItem('offlineCount');
   			localStorage.getItem('orgName');	
   			localStorage.getItem('address');
   			var stationId = localStorage.getItem('stationId');
   			getData('/stations/getStakesByStationId/'+stationId,function(result){
	   		$scope.stakes = result.data ;
	   		$rootScope.stakes = $scope.stakes ;
	   		$scope.stationName = localStorage.getItem('stationName');
	   		$scope.chargeCount = localStorage.getItem('chargeCount');
	   		$scope.freeCount = localStorage.getItem('freeCount');
   			$scope.faultCount = localStorage.getItem('faultCount');
   			$scope.offlineCount = localStorage.getItem('offlineCount');
   			$scope.orgName = localStorage.getItem('orgName');
   			$scope.address = localStorage.getItem('address');
	   		$scope.$apply();
   		}) ;
    }
   	$scope.queryStakeDetail = function(stake){
   			localStorage.removeItem("stakeNumber");
   			localStorage.removeItem("alias");
   			localStorage.setItem('stakeNumber',stake.stakeNumber);
   			localStorage.setItem('alias',stake.alias);
			mui.openWindow({
				url:'stakeHome.html'
			});
			
   	}
   	$scope.queryByStakeType = function(stakeType){
		$scope.stakes=$filter("filter")($rootScope.stakes,{'type':stakeType});
		mui('#popoverType').popover('toggle',document.getElementById("stakeType"));
	}
   	$scope.queryByStakeStatus = function(stakeStatus){
		$scope.stakes=$filter("filter")($rootScope.stakes,{'chargeStatus':stakeStatus});
		mui('#popoverStatus').popover('toggle',document.getElementById("stakeStatus"));
	}
   	$scope.queryStationDetail();
});

app.filter('statusFilter', function() {  
		return function(input,name){
			if(input == name){
				return true ;
			}
		};
});
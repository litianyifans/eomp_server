var app = angular.module('app', []);
app.controller('stationsCtrl', function($scope, $filter,$http,$rootScope) {
	
   	$scope.listStations = function(){
   		getData('/stations/getStationsByUserAccount/'+localStorage.getItem('userAccount'),function(result){
	   		$scope.stations = result.data ;
	   		$rootScope.stations = $scope.stations;
	   		$scope.sumStationData(result.data);
	   		$scope.$apply();
   		}) ;
    }
   	$scope.sumStationData = function(staions){
   			$scope.countStationNumber = staions.length ;
	   		$scope.sumChargeCount = 0 ;
	   		$scope.sumFreeCount = 0 ;
	   		$scope.sumFaultCount = 0 ;
	   		$scope.sumOfflineCount = 0 ;
	   		for(var i = 0 ; i < staions.length ; i++){
	   			$scope.sumChargeCount += parseInt(staions[i].chargeCount) ;
	   			$scope.sumFreeCount += parseInt(staions[i].freeCount) ;
	   			$scope.sumFaultCount += parseInt(staions[i].faultCount) ;
	   			$scope.sumOfflineCount += parseInt(staions[i].offlineCount) ;
	   		}
	   		$scope.sumStakeCount = $scope.sumChargeCount + $scope.sumFreeCount 
	   								+ $scope.sumFaultCount+$scope.sumOfflineCount ;
   	}
   	$scope.queryByStationName = function(stationName){
		$scope.stations=$filter("filter")($rootScope.stations,{'stationName':stationName});
		$scope.sumStationData($scope.stations);
	}
   	$scope.queryStationDetail = function(station){
   			localStorage.removeItem('stationId');
   			localStorage.removeItem('stationName');
   			localStorage.removeItem('chargeCount');
   			localStorage.removeItem('freeCount');
   			localStorage.removeItem('faultCount');
   			localStorage.removeItem('offlineCount');
   			localStorage.removeItem('orgName');	
   			localStorage.removeItem('address');	
   			localStorage.setItem('stationId',station.id);
   			localStorage.setItem('stationName',station.stationName);
   			localStorage.setItem('chargeCount',station.chargeCount);
   			localStorage.setItem('freeCount',station.freeCount);
   			localStorage.setItem('faultCount',station.faultCount);
   			localStorage.setItem('offlineCount',station.offlineCount);
   			localStorage.setItem('orgName',station.org.orgName);
   			localStorage.setItem('address',station.address);
   			
			mui.openWindow({
				url:'stationDetail.html'
			});
			
   	}
   	$scope.listStations();
});
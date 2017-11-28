
var app = angular.module('app', []);
app.controller('sakeBaseInfoCtrl', function($scope, $filter,$http,$rootScope) {
   			var stakeNumber = localStorage.getItem('stakeNumber');
   	$scope.queryStationDetail = function(){
   			getData('/stations/getStakeInfoByStakeNumber/'+stakeNumber,function(result){
	   		$scope.stake = result.data ;
	   		var portStatus = JSON.parse($scope.stake.portStatus) ;
				var flag = false ; 
				if(portStatus instanceof Array){
					for(var i = 0 ; i < portStatus.length ; i++){
						if(portStatus[i].key == 'softVersion'){
							$scope.stake.versionText = "V" + portStatus[i].value.split("").join(".");
							flag  = true ;
						}
					}
				}
				if((!flag)||"V0"==$scope.stake.versionText){
					$scope.stake.versionText  = "V0.0.0" ;
				}
			
	   		$scope.stationName = localStorage.getItem('stationName');
	   		$scope.chargeCount = localStorage.getItem('chargeCount');
	   		$scope.freeCount = localStorage.getItem('freeCount');
   			$scope.faultCount = localStorage.getItem('faultCount');
   			$scope.offlineCount = localStorage.getItem('offlineCount');
   			$scope.orgName = localStorage.getItem('orgName');
   			$scope.address = localStorage.getItem('address');
	   		$scope.$apply();
   		}) ;
    } ;
    
	$scope.showPortsFun = function(){
		getData('/stations/getStakeChargeStatusByStakeNumber/'+stakeNumber,function(rs){
			if(rs.data.length > 0) {
					$scope.showPorts = rs.data.sort(function(a,b) {
						return a.port - b.port;
					});
					$scope.showPorts.forEach(function(item,index){
						if(!!item.chargerStatus ) {							
							item.chargerStatus = JSON.parse(item.chargerStatus);
						}
						if(!!item.chargingInfo) {
							item.chargingInfo = JSON.parse(item.chargingInfo);							
						}
						if(!! item.bmsInfo) {
							item.bmsInfo = JSON.parse(item.bmsInfo);
						}
						if(!! item.portStatus) {
							for(var i = 0 ;i< item.portStatus.length ;i++){
								if(item.portStatus[i].name == '当前充电状态' && item.portStatus[i].value =='离线'){
									item.bmsInfo = [] ;
									item.chargingInfo = [] ;
									item.chargerStatus = [];
								}
							}
							item.portStatus = JSON.parse(item.portStatus);
						}
						
					});
					
					$scope.showPort = $scope.showPorts[0];
					$scope.showPortB = $scope.showPorts[1];
					$scope.$apply();
				} else {
					console.error('get stakePortsStatus is empty!');
				}
		});
	};   	
   	
   	
   	$scope.showPartiesStatus = function() {
   		getData('/stations/getStakeAlarmByStakeNumber/'+stakeNumber,function(result){
   			$scope.statkeErrorStatuses = result.data;
   			$scope.$apply();
   		});
	}
  	$scope.getChargerModeArrays = function(chargerStatus) {
			var count = getValueFromArray(chargerStatus, '当前模块总数');
			var arrays = [];
			for(var i = 1; i <= count; i++) {
				arrays.push(i);
			}
			return arrays;
	}
   	$scope.queryStationDetail();
   	$scope.showPartiesStatus();
   	$scope.showPortsFun();
});
	app.filter('attrFilter', function() {  
		return getValueFromArray;
	});
	app.filter('isAttrContainerFilter', function() {  
		return function(input,name){
			if(input == name){
				return true ;
			}
		};
	});
	app.filter('paging', function() {  
		return function(input, currPage,pageSize) {  
			if(input != null) {
				return input.slice((currPage - 1) * pageSize, currPage * pageSize);				
			}
	   };  
	});
	


function getValueFromArray(input, attr) {   
	if(input != null && attr != null) {
		for(var i = 0; i < input.length; i++) {
			if(input[i].name == attr) {
				return input[i].value;
			}
		}
	}
	return '';
};  

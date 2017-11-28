var app = angular.module('app', []);
app.controller('stationsCtrl', function($scope, $filter,$http,$rootScope) {
	  	$scope.listStations = function(){
	   		getData('/stations/getStationsByUserAccount/'+localStorage.getItem('userAccount'),function(result){
		   		$scope.stations = result.data ;
		   		
		   		$scope.$apply();
	   		}) ;
	   		
   		}
   		$scope.addStationMarkers = function(){
		$scope.stations.forEach(function(item){
			var marker = new AMap.Marker({
				map: map,
				title: item.name,
				content: $scope.getMarkerContent(item),
				position: [item.lng, item.lat],
				offset: new AMap.Pixel(-17,-35),
				extData: item.id
			});

			item.navigateInMap = function(){
				$scope.markerClick(this);
				$rootScope.$emit('showStation', item);
			};
			
			marker.item = item;
			marker.on('click', function(e){
				item.navigateInMap();
			});
		});
		};
		
		$scope.getMarkerContent = function(item) {
		// 实现原理参考：http://www.zhangxinxu.com/wordpress/2015/07/svg-circle-loading/
		var $content = $($('#station-marker-html').html());
		$content.find('.stakeCount').text(item.sumStakes);
		
		var accPercent = 0;               // 累计百分比
		var perimeter = 2 * Math.PI * 14; // marker的圆圈周长
		var status = ['freeCount', 'chargeCount', 'faultCount', 'offlineCount'];
		status.forEach(function(name) {
			var currPercent = item.sumStakes == 0 ? 0 : item[name] / item.sumStakes;
			var strokeLen = currPercent * perimeter;
			var startAngle = accPercent * 360 - 90;
			
			var $targetElem = $content.find('.' + name);
			$targetElem.attr('transform', 'rotate(' + startAngle + ', 17, 17)');
			$targetElem.attr('stroke-dasharray', strokeLen + ' 1000');
			accPercent += currPercent;
		});
		
		var markerContent = $content[0].outerHTML;
		return markerContent;
		};
   		$scope.markerClick = function(station) {
			$scope.showInfoWindow(station);
		};
		$scope.showInfoWindow = function(item) {
		var infoWindow = new AMap.InfoWindow({
			offset : new AMap.Pixel(0, -35)
		});

		infoWindow.setContent($scope.stationFormatter(item));
		infoWindow.open(map, [item.lng, item.lat]);
		$rootScope.infoWindow = infoWindow ;
		map.setZoomAndCenter(14, [item.lng, item.lat]);
		};
		$scope.stationFormatter = function(station) {
		var template =$('#stationInfo-template').html();
		return doT.template(template)(station);
		};
		
		$scope.stationRecordClick = function(station) {
			station.navigateInMap();
		};
   
	
});

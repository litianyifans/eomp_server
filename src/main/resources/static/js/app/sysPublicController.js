var app = angular.module('app', []);
app.controller('publicsCtrl', function($scope) {
   	$scope.queryPublics= function(){
   			getData('/sysConfig/getSysPublics',function(result){
	   		$scope.publics = result.data ;
	   		$scope.$apply();
   		}) ;
    }
   	$scope.queryPublics();
   	
   	
   	$scope.queryPublicDetail = function(public){
   		localStorage.removeItem('sysId') ;
   		localStorage.setItem('sysId',public.id);
   		mui.openWindow('noticeDetail.html','noticeDetail.html');
   	}
});
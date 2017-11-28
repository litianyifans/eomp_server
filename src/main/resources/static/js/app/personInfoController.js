var app = angular.module('app', []);
app.controller('personInfoCtrl', function($scope) {
   	$scope.queryUserInfo = function(){
   			var userAccount = localStorage.getItem('userAccount');
   			//userId+"/"+orgId
   			///8abd94485bad1520015bad76efd0002f/297edff84d677b77014d69d81b7b001e
   			getData('/users/getUserByuserAccount/'+userAccount,function(result){
	   		$scope.userInfo = result.data ;
	   		$scope.$apply();
   		}) ;
    }
   	$scope.queryUserInfo();
   
});
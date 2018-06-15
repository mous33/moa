/**
 * ホームページコントローラー
 */

define([ 'app' ], function(app) {
	app.controller('ad0101Ctrl', [
			'$rootScope',
			'$scope',
			'$http',
			'$state',
			'messageService',
			function($rootScope, $scope, $http, $state, messageService) {
				$http.post('admin/ad01/showUserGroups').success(function(json) {
					$scope.userGroupList = json.data;
				});
				$scope.addUser = function() {
					$state.go('home.AD01');
					$scope.message = "";
					$http.post('admin/ad01/addUser', $scope.registerUser)
							.success(function(json) {
								if (json.result == false) {
									if (json.message) {
										$scope.message = json.message;
									} else {
										$scope.errors = json.errors;
									}
								} else {
									messageService.showInfoMsg(json.message);
									$rootScope.showUsers();
									$('#closeBtn').click();
								}
							});
				}
			} ]);
});
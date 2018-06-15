/**
 * ログインページコントローラー
 */
define([ 'app' ], function(app) {
	app.controller('loginCtrl', [
			'$rootScope',
			'$scope',
			'$http',
			'$state',
			'messageService',
			function($rootScope, $scope, $http, $state, messageService) {
				$('#userId').focus();
				$scope.login = function() {
					$http.post('common/login/validateUser', $scope.loginUser)
							.success(function(res) {
								if (res.result == true) {
									$rootScope.loginUser = res.data;
									$state.go('home');
								} else {
									$scope.message = res.message;
									$scope.errors = res.errors;
									$('#userId').focus();
								}
							});
				};
			} ]);
});
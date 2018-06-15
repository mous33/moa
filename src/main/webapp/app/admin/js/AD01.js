/**
 * ホームページコントローラー
 */

define([ 'app' ], function(app) {
	app.controller('ad01Ctrl', [ '$rootScope', '$scope', '$http',
			'messageService',
			function($rootScope, $scope, $http, messageService) {
				$rootScope.showUsers = function() {
					$http.post('admin/ad01/showUsers').success(function(json) {
						$scope.users = json.data;
					});
				}
				$rootScope.showUsers();
			} ]);
});
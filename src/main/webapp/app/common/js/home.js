/**
 * ホームページコントローラー
 */

define([ 'app' ], function(app) {
	app.controller('homeCtrl', [ '$rootScope', '$scope', '$http', '$state',
			'messageService',
			function($rootScope, $scope, $http, $state, messageService) {
				$scope.loginUser = $rootScope.loginUser;
				$rootScope.loginUser = $scope.loginUser;
				// $scope.showHomePage = function() {
				// $http.post('common/home/showHomePage').success(
				// function(json) {
				// $scope.menus = json.data;
				// });
				// };
				// $scope.showHomePage();
			} ]);
});
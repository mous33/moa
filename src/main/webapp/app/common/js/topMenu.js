/**
 * ホームページコントローラー
 */

define([ 'app' ], function(app) {
	app.controller('topMenuCtrl', [ '$rootScope', '$scope', '$http', '$state',
			'messageService',
			function($rootScope, $scope, $http, $state, messageService) {
				$http.post('common/home/showMenus').success(function(json) {
					$rootScope.mainMenus = json.data;
				});
				$scope.showPage = function(subMenu) {
					$scope.selectedMainMenuName = subMenu.mainMenuName;
					$scope.selectedSubMenuName = subMenu.subMenuName;
					$state.go("home." + subMenu.subMenuId);
				};
			} ]);
});
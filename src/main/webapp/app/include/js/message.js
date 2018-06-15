/**
 * メッセージ表示コントローラー
 */
define([ "app" ], function(app) {
	app.controller('messageCtrl', [
			"$scope",
			"$uibModalInstance",
			"type",
			"msg", function($scope, $uibModalInstance, type, msg) {
				$scope.type = type;
				$scope.msg = msg;
				$scope.ok = function() {
					$uibModalInstance.close();
				}, $scope.cancel = function() {
					$uibModalInstance.dismiss();
				}
			} ]);
});
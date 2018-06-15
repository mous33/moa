define([ 'angular', 'routeManager' ], function(angular, RouteManager) {
	var MainApp = angular.module('MainApp', [ 'ngAnimate', 'ui.bootstrap',
			'ui.router', 'angularCSS' ]);
	MainApp.config([ '$controllerProvider', function($controllerProvider) {
		MainApp.controller = $controllerProvider.register;
	} ]).config(RouteManager).run(
			[ '$rootScope', '$state', '$window',
					function($rootScope, $state, $window) {
						$rootScope.go = function(path, param) {
							$state.go(path, param);
						}
					} ]);

	window.app = MainApp;
	MainApp.factory('UserInterceptor', [ "$q", "$rootScope", '$location',
			function($q, $rootScope, $location) {
				return {
					response : function(res) {
						if (res.data.isNotLogin == true) {
							$location.path("/login");
						}
						var deferred = $q.defer();
						var deferred = $q.defer();
						deferred.resolve(res);
						return deferred.promise;
					}
				};
			} ]);
	MainApp.config(function($httpProvider) {
		$httpProvider.interceptors.push('UserInterceptor');
	});

	MainApp.factory('messageService', [ '$rootScope', '$uibModal',
			function($rootScope, $uibModal) {
				var service = {};
				service.showMsg = function(type, msg, fn1, fn2) {
					var modalInstance = $uibModal.open({
						animation : true,
						templateUrl : 'message.html',
						controller : 'messageCtrl',
						size : 'sm',
						resolve : {
							type : function() {
								return type;
							},
							msg : function() {
								return msg;
							}
						}
					});
					modalInstance.result.then(fn1, fn2);
				};
				service.showErrorMsg = function(msg, fn) {
					service.showMsg('error', msg, fn);
				};
				service.showInfoMsg = function(msg, fn) {
					service.showMsg('info', msg, fn);
				};
				service.showConfirmMsg = function(msg, okFn, cancelFn) {
					service.showMsg('confirm', msg, okFn, cancelFn);
				};
				return service;
			} ]);
	MainApp.directive('input', function($parse) {
		return {
			restrict : 'E',
			require : '?ngModel',
			link : function(scope, element, attrs) {
				if (attrs.ngModel) {
					val = attrs.value || element.text();
					$parse(attrs.ngModel).assign(scope, val);
				}
			}
		};
	});
	return MainApp;
});
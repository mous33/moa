define([ "angularAMD" ], function(angularAMD) {
	var routeManager = function($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');
		$stateProvider.state('login', angularAMD.route({
			url : '/login',
			views : {
				'' : angularAMD.route({
					templateUrl : 'app/common/html/login.html',
					controllerUrl : 'app/common/js/login.js',
					css : 'app/common/css/login.css'
				}),
				'message@login' : angularAMD.route({
					templateUrl : 'app/include/html/message.html',
					controllerUrl : 'app/include/js/message.js'
				})
			}
		})).state('home', angularAMD.route({
			url : '/home',
			views : {
				'' : angularAMD.route({
					templateUrl : 'app/common/html/home.html',
					controllerUrl : 'app/common/js/home.js'
				}),
				'message@home' : angularAMD.route({
					templateUrl : 'app/include/html/message.html',
					controllerUrl : 'app/include/js/message.js'
				}),
				'topMenu@home' : angularAMD.route({
					templateUrl : 'app/common/html/topMenu.html',
					controllerUrl : 'app/common/js/topMenu.js'
				})
			}
		})).state('home.AD01', angularAMD.route({
			params : {
				'selectedMainMenu' : null
			},
			views : {
				'content@home' : angularAMD.route({
					templateUrl : 'app/admin/html/AD01.html',
					controllerUrl : 'app/admin/js/AD01.js'
				}),
				'ad0101@home.AD01' : angularAMD.route({
					templateUrl : 'app/admin/html/AD0101.html',
					controllerUrl : 'app/admin/js/AD0101.js'
				})

			}
		}));
	}

	return routeManager;
});
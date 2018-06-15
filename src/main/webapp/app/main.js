require.config({
	baseUrl : "app",
	paths : {
		"jquery" : "../lib/jquery/jquery-3.3.1.min",
		"angular" : "../lib/angular/angular.min",
		"angularAnimate" : "../lib/angular/angular-animate.min",
		"angularTouch" : "../lib/angular/angular-touch.min",
		"uiRouter" : "../lib/angular-plugins/angular-ui-router.min",
		"angularAMD" : "../lib/angular-plugins/angularAMD.min",
		"ngload" : "../lib/angular-plugins/ngload.min",
		"angularCSS" : "../lib/angular-plugins/angular-css.min",
		"uibootstrap" : "../lib/angular-plugins/ui-bootstrap-tpls-2.5.0.min",
		"bootstrap" : "../lib/bootstrap/js/bootstrap.min",
		"routeManager" : "routeManager"
	},
	shim : {
		"angular" : {
			deps : [ "jquery" ],
			exports : "angular"
		},
		"angularAnimate" : [ "angular" ],
		"angularTouch" : [ "angular" ],
		"uiRouter" : [ "angular" ],
		"angularAMD" : [ "angular" ],
		"ngload" : [ "angularAMD" ],
		"angularCSS" : [ "angular" ],
		"uibootstrap" : [ "angular" ],
		"bootstrap" : [ "jquery" ],
		"routeManager" : [ "angularAMD", "uiRouter" ]
	},
	urlArgs : "v=" + new Date().getTime()
});

define([ "jquery", "angular", "angularAnimate", "angularTouch", "angularAMD",
		"uiRouter", "angularCSS", "uibootstrap", "bootstrap", "app" ],
		function(jquery, angular, angularAnimate, angularTouch, angularAMD,
				uiRouter, angularCSS, uibootstrap, bootstrap, app) {
			return angularAMD.bootstrap(app);
		});
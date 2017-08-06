/**
 * confirmDialogue Directive
 * 
 
 * @author Atinder
 * @version 1.0
 * @since 2017-08-01
 * @example <confirm-dialogue></confirm-dialogue>
 */
angular.module('myApp').directive('confirmDialogue', confirmDialogue);

function confirmDialogue() {
	var directive = {
		link : link,
		templateUrl : '../js/template/confirm.html',
		restrict : 'EA',
		scope : {
			delName : '=',
			delFn : '&'
		},
		controller : ConfirmController,
		controllerAs : 'vm',
		bindToController : true
	};
	return directive;

	function link(scope, element, attrs) {
		/* */
	}

	function ConfirmController() {
		var vm = this;

	}
}

/**
 * @desc loading directive 
 * 
 * @example <loading val="emp.loading"></loading>
 */

angular.module('myApp').directive('loading', loading);

function loading() {
	var directive = {
		link : link,
		template : '<div class="loading">LOADING...</div>',
		restrict : 'EA',
		controllerAs : 'vm',
		bindToController : true,
		controller : loginController,
		scope : {
			val : '='
		},
	};
	return directive;

	function link(scope, element, attrs) {
		scope.$watch('vm.val', function(val) {
			if (val)
				$(element).show();
			else
				$(element).hide();
		});
	}

	function loginController() {
	}
}
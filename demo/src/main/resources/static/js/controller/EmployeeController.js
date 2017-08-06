/**
 * EmployeeController
 * 
 * @author Atinder
 * @version 1.0
 * @since 2017-08-01
 */
angular.module('myApp').controller('EmployeeController', EmployeeController);

EmployeeController.$inject = [ '$scope', 'employeeservice' ];

function EmployeeController($scope, employeeservice) {

	var vm = this;
	vm.employees = [];
	
	vm.currntIndex = 0;

	vm.setupData=function() {
		vm.employee = {
			name : "",
			email : "",
			address : "",
			id : ""
		}
		if ($scope.empForm) {
			$scope.empForm.$setPristine();
		}
	}
	function getEmployees() {
		vm.loading = true;
		return employeeservice.getEmployees().then(function(data) {
			vm.loading = false;
			vm.employees = data;
			return vm.employees;
		});
	}

	vm.saveEmployee = function() {
		vm.loading = true;
		if (vm.employee.id == "") {
			return employeeservice.saveEmployee(vm.employee).then(
					function(data) {
						vm.loading = false;
						vm.employees.unshift(data);
						vm.setupData();

					});
		} else {
			return employeeservice.updateEmployee(vm.employee).then(
					function(data) {
						vm.loading = false;
						vm.employees[vm.currntIndex] = data;
						vm.setupData();
					});
		}

	}

	vm.editEmployee = function(emp, index) {
		vm.employee = angular.copy(emp);
		vm.currntIndex = index;
	}

	vm.deleteEmployee = function(emp, index) {
		vm.delName = emp.name;
		vm.delId = emp.id;
		vm.currntIndex = index;
		$('#myModal').modal('show');

	}

	vm.deleteEmployeeConfirm = function(empid) {
		$('#myModal').modal('hide');
		vm.loading = true;
		return employeeservice.deleteEmployee(empid).then(function(data) {
			vm.loading = false;
			vm.employees.splice(vm.currntIndex, 1);
		});

	}
	
	getEmployees();
	vm.setupData();

}
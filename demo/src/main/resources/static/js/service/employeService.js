/**
 * employeeservice : dataservice factory 
 * 
 * @author Atinder
 * @version 1.0
 * @since 2017-08-01
 */
angular
    .module('myApp')
    .factory('employeeservice', employeeservice);

employeeservice.$inject = ['$http', '$log'];

function employeeservice($http, $log) {
    return {
        getEmployees: getEmployees,
        saveEmployee:saveEmployee,
        updateEmployee:updateEmployee,
        deleteEmployee:deleteEmployee
    };

    function getEmployees() {
        return $http.get('/api/employees')
            .then(getEmployeesComplete)
            .catch(getEmployeesFailed);
        function getEmployeesComplete(response) {
            return response.data;
        }

        function getEmployeesFailed(error) {
        	$log.error('XHR Failed for getEmployees.' + error.data);
        }
    }
    
    function saveEmployee(employee) {
        return $http.post('/api/employees',employee)
            .then(saveEmployeeComplete)
            .catch(saveEmployeeFailed);

        function saveEmployeeComplete(response) {
            return response.data;
        }

        function saveEmployeeFailed(error) {
        	$log.error('XHR Failed for saveEmployee.' + error.data);
        }
   }
    
    function updateEmployee(employee) {
        return $http.put('/api/employees',employee)
            .then(updateEmployeeComplete)
            .catch(updateEmployeeFailed);

        function updateEmployeeComplete(response) {
            return response.data;
        }

        function updateEmployeeFailed(error) {
        	$log.error('XHR Failed for saveEmployee.' + error.data);
        }
   }
    
    function deleteEmployee(empId) {
        return $http.delete('/api/employees/'+empId)
            .then(deleteEmployeeComplete)
            .catch(deleteEmployeeFailed);

        function deleteEmployeeComplete(response) {
            return response.data;
        }

        function deleteEmployeeFailed(error) {
        	$log.error('XHR Failed for saveEmployee.' + error.data);
        }
   }
}
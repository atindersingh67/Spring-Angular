package com.demo.service;

import java.util.List;

import com.demo.domain.Employee;
import com.demo.dto.EmployeeDto;

/**
* The IEmployeeService is a service interface  
*
* @author  Atinder
* @version 1.0
* @since   2017-08-01 
*/
public interface IEmployeeService {

	List<Employee> getAllEmployees();
	
	Employee getEmployee(long id);

	Employee saveEmployee(Employee employee);

	Employee updateEmployee(EmployeeDto employeeDto);
	
	void deleteEmployee(long id);
}

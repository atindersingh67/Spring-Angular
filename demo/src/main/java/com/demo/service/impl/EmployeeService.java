package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IEmployeeDao;
import com.demo.domain.Employee;
import com.demo.dto.EmployeeDto;
import com.demo.service.IEmployeeService;

/**
 * The EmployeeService is a service class which implements IEmployeeService
 * interface. It is a layer between controller and DAO
 *
 * @author Atinder
 * @version 1.0
 * @since 2017-08-01
 */

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {

		return employeeDao.findAllByOrderByIdDesc();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee updateEmployee(EmployeeDto employeeDto) {
		Employee emp = employeeDao.findById(employeeDto.getId());
		emp.setEmail(employeeDto.getEmail());
		emp.setAddress(employeeDto.getAddress());
		emp.setName(employeeDto.getName());
		return employeeDao.save(emp);
	}

	@Override
	public Employee getEmployee(long id) {
		return employeeDao.findById(id);
	}

	@Override
	public void deleteEmployee(long id) {
		employeeDao.delete(id);

	}
}

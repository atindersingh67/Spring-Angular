package com.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.Employee;
import com.demo.dto.EmployeeDto;
import com.demo.service.IEmployeeService;

/**
* The EmployeeController is a rest controller for all crude operations 
*
* @author  Atinder
* @version 1.0
* @since   2017-08-01 
*/


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeDto> get() {
		List<Employee> list = employeeService.getAllEmployees();
		return list.stream().map(employe -> modelMapper.map(employe, EmployeeDto.class)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeDto getById(@PathVariable("id") Long id) {
		return modelMapper.map(employeeService.getEmployee(id), EmployeeDto.class);

	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		return modelMapper.map(employeeService.saveEmployee(employee), EmployeeDto.class);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public EmployeeDto update(@RequestBody EmployeeDto employeeDto) {
		return modelMapper.map(employeeService.updateEmployee(employeeDto), EmployeeDto.class);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		
	}

}

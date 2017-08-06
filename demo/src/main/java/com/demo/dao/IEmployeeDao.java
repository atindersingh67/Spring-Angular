package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Employee;

/**
* The IEmployeeDao is an interface for User which interact with database and get result from Database
*
* @author  Atinder
* @version 1.0
* @since   2017-08-01 
*/

public interface IEmployeeDao extends JpaRepository<Employee, Long> {
	
	Employee findById(long id);

	List<Employee> findAllByOrderByIdDesc();
}

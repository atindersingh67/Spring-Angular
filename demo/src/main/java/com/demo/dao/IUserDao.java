package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.User;


/**
* The IUserDao is an interface for User which interact with database and get result from Databse  
*
* @author  Atinder
* @version 1.0
* @since   2017-08-01 
*/


public interface IUserDao extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
	
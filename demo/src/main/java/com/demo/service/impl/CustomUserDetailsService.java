package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.dao.IUserDao;
import com.demo.domain.User;

/**
 * The CustomUserDetailsService is a service class which implements UserDetailsService
 * interface and used by spring security.
 *
 * @author Atinder
 * @version 1.0
 * @since 2017-08-01
 */

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user = userDao.findByEmail(username);

		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true,
				true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		return authorities;
	}

}

package com.mobile.cleverpost.rest.persistence.dao.security;

import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class CustomJDBCDao extends JdbcDaoImpl {
	public CustomJDBCDao() {
		super();
	}
}

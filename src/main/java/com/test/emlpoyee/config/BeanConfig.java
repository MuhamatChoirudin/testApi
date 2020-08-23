package com.test.emlpoyee.config;

import com.test.emlpoyee.dao.EmployeeDao;
import com.test.emlpoyee.services.EmployeeService;

public class BeanConfig {

	public EmployeeDao employeeService() {
		return new EmployeeService();
		
	}
}

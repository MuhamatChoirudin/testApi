package com.test.emlpoyee.constants;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class RestConstant {
	
	public static final String API = "/api";
	public static final String ID = "/id";
	public static final String SAVE ="/save";
	public static final String DELETE ="/delete";
	public static final String EDIT ="/edit";
	
	public static class Employee {
	    	private Employee() {}
	    	
	    	public static final String EMPLOYEE				="/employee";
	    	public static final String URL_SEARCH_CUSTOMER				="/searchCustomer";
	    }
	
	public static class Branch {
    	private Branch() {}
    	
    	public static final String BRANCH				="/branch";
    	
    }
}

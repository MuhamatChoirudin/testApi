package com.test.emlpoyee.model;

import java.util.List;

import com.test.emlpoyee.entity.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetEmployeeAllResponse {

private long totalRecord;
	
	private List<Employee> listOfSundryGl;
}

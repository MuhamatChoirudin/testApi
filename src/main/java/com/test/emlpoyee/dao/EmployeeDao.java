package com.test.emlpoyee.dao;

import java.util.List;
import java.util.Optional;

import com.test.emlpoyee.dto.BranchDto;
import com.test.emlpoyee.dto.EmployeeDto;
import com.test.emlpoyee.entity.Branch;
import com.test.emlpoyee.entity.Employee;
import com.test.emlpoyee.model.EmployeeRequest;
import com.test.emlpoyee.model.GetEmployeeAllRequest;
import com.test.emlpoyee.model.GetEmployeeAllResponse;

public interface EmployeeDao {
	Employee getEmployeeById(String id) throws Exception;
	Employee saveBranch(EmployeeDto request) throws Exception;
	Employee setBranch(EmployeeDto request) throws Exception;
	Employee deleteBranch(String id) throws Exception;
	GetEmployeeAllResponse getEmployeeAll(GetEmployeeAllRequest request) throws Exception;
}

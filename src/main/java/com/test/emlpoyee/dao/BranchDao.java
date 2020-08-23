package com.test.emlpoyee.dao;

import java.util.List;
import java.util.Optional;

import com.test.emlpoyee.dto.BranchDto;
import com.test.emlpoyee.entity.Branch;
import com.test.emlpoyee.entity.Employee;
import com.test.emlpoyee.model.EmployeeRequest;
import com.test.emlpoyee.model.GetBranchAllRequest;
import com.test.emlpoyee.model.GetBranchAllResponse;
import com.test.emlpoyee.model.GetEmployeeAllRequest;
import com.test.emlpoyee.model.GetEmployeeAllResponse;
import com.test.emlpoyee.model.SearchDataAllRequest;

public interface BranchDao {
	Branch getBranchById(String id) throws Exception;
	Branch saveBranch(BranchDto request) throws Exception;
	Branch setBranch(BranchDto request) throws Exception;
	Branch deleteBranch(String id) throws Exception;
	Branch updateBranch(BranchDto request) throws Exception;
	GetBranchAllResponse getBranchAll(GetBranchAllRequest request) throws Exception;
	GetBranchAllResponse searchBranchAll(SearchDataAllRequest request) throws Exception;
}

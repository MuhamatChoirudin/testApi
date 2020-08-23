package com.test.emlpoyee.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.emlpoyee.constants.RestConstant;
import com.test.emlpoyee.controller.abstrac.AbstractPostController;
import com.test.emlpoyee.dao.BranchDao;
import com.test.emlpoyee.dao.EmployeeDao;
import com.test.emlpoyee.dto.BranchDto;
import com.test.emlpoyee.dto.EmployeeDto;
import com.test.emlpoyee.exception.ErrorHolder;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(RestConstant.API + RestConstant.Employee.EMPLOYEE)
@Api(value = "Save Employee", tags = "Save Employee")
public class EmployeeCreatePostController extends AbstractPostController<EmployeeDto, String, EmployeeCreatePostController>{

	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = RestConstant.SAVE)
	public ResponseEntity<String> save(@Valid @RequestBody EmployeeDto request, BindingResult bindingResult)throws Exception{

		return execute(request, bindingResult);
		
	}

	@Override
	public ResponseEntity<String> postExecute(EmployeeDto request) throws Exception {
		employeeDao.saveBranch(request);
		return  ResponseEntity.accepted().body("");
	}

	@Override
	public void constructAuditSuccess(RequestMethod method, EmployeeDto request, ResponseEntity<String> response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void constructAuditError(RequestMethod method, EmployeeDto request, List<ErrorHolder> errors)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

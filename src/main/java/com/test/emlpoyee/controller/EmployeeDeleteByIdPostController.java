package com.test.emlpoyee.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.test.emlpoyee.constants.RestConstant;
import com.test.emlpoyee.controller.abstrac.AbstractPostController;
import com.test.emlpoyee.dao.EmployeeDao;
import com.test.emlpoyee.exception.ErrorHolder;
import com.test.emlpoyee.model.BranchRequest;
import com.test.emlpoyee.model.EmployeeRequest;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(RestConstant.API + RestConstant.Employee.EMPLOYEE)
@Api(value = "Dalete Employee", tags = "Dalete Employee")
public class EmployeeDeleteByIdPostController extends AbstractPostController<EmployeeRequest, String, EmployeeDeleteByIdPostController>{

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = RestConstant.DELETE)
	public ResponseEntity<String> save(@RequestBody String id, BindingResult bindingResult)throws Exception{
		EmployeeRequest request = new EmployeeRequest();
		request.setId(id);
		return execute(request, bindingResult);
		
	}

	@Override
	public ResponseEntity<String> postExecute(EmployeeRequest request) throws Exception {
		employeeDao.deleteBranch(request.getId());
		return  ResponseEntity.accepted().body("");
	}

	@Override
	public void constructAuditSuccess(RequestMethod method, EmployeeRequest request, ResponseEntity<String> response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void constructAuditError(RequestMethod method, EmployeeRequest request, List<ErrorHolder> errors)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

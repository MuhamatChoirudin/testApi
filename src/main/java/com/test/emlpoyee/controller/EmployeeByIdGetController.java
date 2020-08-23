package com.test.emlpoyee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.emlpoyee.constants.RestConstant;
import com.test.emlpoyee.constants.SystemConstant;
import com.test.emlpoyee.controller.abstrac.AbstractGetController;
import com.test.emlpoyee.dao.EmployeeDao;
import com.test.emlpoyee.entity.Employee;

import com.test.emlpoyee.exception.ApplicationException;import com.test.emlpoyee.exception.ErrorHolder;
import com.test.emlpoyee.model.EmployeeRequest;
import com.test.emlpoyee.util.ValidatorUtils;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(RestConstant.API + RestConstant.Employee.EMPLOYEE+RestConstant.ID)
@Api(value = "Get Employee By Id", tags = "Get Employee By Id")

public class EmployeeByIdGetController extends AbstractGetController<EmployeeRequest, Employee, EmployeeByIdGetController>{

	@Autowired
	private EmployeeDao employeeDao;
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
	private ResponseEntity<Employee> getEmployeeById(@PathVariable String id,
			@ApiIgnore EmployeeRequest request) throws Exception {

		request.setId(id);
		return preExecute(request);
	}
	
//	public EmployeeRequest validate(EmployeeRequest request, HttpHeaders headers) throws Exception {
//		return (EmployeeRequest) ValidatorUtils.validateHeader(request, headers, messageSource,
//				SystemConstant.ProjectParam.source.toString(), SystemConstant.ProjectParam.username.toString());
//	}
	
	public ResponseEntity<Employee> execute(EmployeeRequest request)
			throws Exception {
		Employee entity = new Employee();
		try{
			entity = employeeDao.getEmployeeById(request.getId());			
		}catch(Exception e){
			if (e.getMessage().contains("No value present")) {
				ErrorHolder holder = new ErrorHolder();
				holder.setErrorCode(SystemConstant.ResponseCode.COM03);
				holder.setErrorMessage(SystemConstant.ResponseCode.DATA_NOT_FOUND);
				throw new ApplicationException(holder);
			}else{
				throw e;
			}
		}
		

		
				
		
		return ResponseEntity.ok().body(entity);
	}

	
	@Override
	public void constructAuditSuccess(RequestMethod method, EmployeeRequest request, ResponseEntity<Employee> response)
			throws Exception {
		
	}

	@Override
	public void constructAuditError(RequestMethod method, EmployeeRequest request, List<ErrorHolder> errors)
			throws Exception {
		
	}

}

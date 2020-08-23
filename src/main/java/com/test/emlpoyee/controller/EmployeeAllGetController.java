package com.test.emlpoyee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.test.emlpoyee.model.GetEmployeeAllRequest;
import com.test.emlpoyee.model.GetEmployeeAllResponse;
import com.test.emlpoyee.repository.EmployeeRepository;
import com.test.emlpoyee.util.ValidatorUtils;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(RestConstant.API + RestConstant.Employee.EMPLOYEE)
@Api(value = "Get Employee ", tags = "Get Employee")

public class EmployeeAllGetController extends AbstractGetController<GetEmployeeAllRequest, GetEmployeeAllResponse, EmployeeAllGetController>{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	private ResponseEntity<GetEmployeeAllResponse> getEmployee(@RequestParam(required = false) String recordLimit,
			 @RequestParam(required = false) String pageNumber,
			@ApiIgnore GetEmployeeAllRequest request) throws Exception {

		request.setPageNumber(request.getPageNumber());
		request.setRecordLimit(request.getRecordLimit());
		return preExecute(request);
	}

	
	public ResponseEntity<GetEmployeeAllResponse> execute(GetEmployeeAllRequest request)
			throws Exception {
		 Map<String, Object> resultMap = new HashMap<>();
		 GetEmployeeAllResponse response = new GetEmployeeAllResponse();
		 Pageable page = new PageRequest(Integer.parseInt(request.getPageNumber()) - 1, Integer.parseInt(request.getRecordLimit()));
	        Page<Employee> result = employeeRepository.findAll(page);
	        response.setListOfSundryGl(result.getContent());
	        response.setTotalRecord(result.getTotalElements());
		

		
		return ResponseEntity.ok().body(response);
	}

	
	@Override
	public void constructAuditSuccess(RequestMethod method, GetEmployeeAllRequest request, ResponseEntity<GetEmployeeAllResponse> response)
			throws Exception {
		
	}

	@Override
	public void constructAuditError(RequestMethod method, GetEmployeeAllRequest request, List<ErrorHolder> errors)
			throws Exception {
		
	}

}

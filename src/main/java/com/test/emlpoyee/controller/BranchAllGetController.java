package com.test.emlpoyee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import com.test.emlpoyee.dao.BranchDao;
import com.test.emlpoyee.dao.EmployeeDao;
import com.test.emlpoyee.entity.Branch;
import com.test.emlpoyee.entity.Employee;

import com.test.emlpoyee.exception.ApplicationException;import com.test.emlpoyee.exception.ErrorHolder;
import com.test.emlpoyee.model.EmployeeRequest;
import com.test.emlpoyee.model.GetBranchAllRequest;
import com.test.emlpoyee.model.GetBranchAllResponse;
import com.test.emlpoyee.model.GetEmployeeAllRequest;
import com.test.emlpoyee.model.GetEmployeeAllResponse;
import com.test.emlpoyee.repository.BranchRepository;
import com.test.emlpoyee.repository.EmployeeRepository;
import com.test.emlpoyee.util.ValidatorUtils;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(RestConstant.API + RestConstant.Branch.BRANCH)
@Api(value = "Get Branch All", tags = "Get Branch ALL")

public class BranchAllGetController extends AbstractGetController<GetBranchAllRequest, GetBranchAllResponse, BranchAllGetController>{

	@Autowired
	private BranchDao branchDao;
	
	@Autowired
	private BranchRepository branchRepository;
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	private ResponseEntity<GetBranchAllResponse> getEmployee(@RequestParam(required = false) String recordLimit,
			 @RequestParam(required = false) String pageNumber,
			@ApiIgnore GetBranchAllRequest request) throws Exception {

		request.setPageNumber(request.getPageNumber());
		request.setRecordLimit(request.getRecordLimit());
		return preExecute(request);
	}

	
	public ResponseEntity<GetBranchAllResponse> execute(GetBranchAllRequest request)
			throws Exception {
		 GetBranchAllResponse response = new GetBranchAllResponse();
		 Pageable page = new PageRequest(Integer.parseInt(request.getPageNumber()) - 1, Integer.parseInt(request.getRecordLimit()));
	        Page<Branch> result = branchRepository.findAll(page);
	        response.setListOfSundryGl(result.getContent());
	        response.setTotalRecord(result.getTotalElements());
		if(result.getTotalElements()==0) {
			ErrorHolder errorHolder = new ErrorHolder();
			errorHolder.setErrorCode(SystemConstant.ResponseCode.COM03);
			errorHolder.setErrorMessage(SystemConstant.ResponseCode.DATA_NOT_FOUND);
			throw new ApplicationException(HttpStatus.NO_CONTENT, new HttpHeaders(), errorHolder);

		}

		
		return ResponseEntity.ok().body(response);
	}

	
	@Override
	public void constructAuditSuccess(RequestMethod method, GetBranchAllRequest request, ResponseEntity<GetBranchAllResponse> response)
			throws Exception {
		
	}

	@Override
	public void constructAuditError(RequestMethod method, GetBranchAllRequest request, List<ErrorHolder> errors)
			throws Exception {
		
	}

}

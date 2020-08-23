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
import com.test.emlpoyee.dao.BranchDao;
import com.test.emlpoyee.dao.EmployeeDao;
import com.test.emlpoyee.entity.Branch;
import com.test.emlpoyee.entity.Employee;

import com.test.emlpoyee.exception.ApplicationException;import com.test.emlpoyee.exception.ErrorHolder;
import com.test.emlpoyee.model.BranchRequest;
import com.test.emlpoyee.model.EmployeeRequest;
import com.test.emlpoyee.util.ValidatorUtils;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(RestConstant.API + RestConstant.Branch.BRANCH+RestConstant.ID)
@Api(value = "Get Branch By Id", tags = "Get Branch By Id")

public class BranchByIdGetController extends AbstractGetController<BranchRequest, Branch, BranchByIdGetController>{

	@Autowired
	private BranchDao branchDao;
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
	private ResponseEntity<Branch> getEmployeeById(@PathVariable String id,
			@ApiIgnore BranchRequest request) throws Exception {

		request.setId(id);
		return preExecute(request);
	}
	
	@Override
	public ResponseEntity<Branch> execute(BranchRequest request)
			throws Exception {
		Branch entity = new Branch();
		try{
			entity = branchDao.getBranchById(request.getId());			
		}catch(Exception e){
			if (e.getMessage().contains("SchemaNotFoundException")) {
				ErrorHolder holder = new ErrorHolder();
				holder.setErrorCode(SystemConstant.ResponseCode.COM06);
				holder.setErrorMessage(e.getMessage());
				throw new ApplicationException(holder);
			}else{
				throw e;
			}
		}
		
		return ResponseEntity.ok().body(entity);
	}

	
	@Override
	public void constructAuditSuccess(RequestMethod method, BranchRequest request, ResponseEntity<Branch> response)
			throws Exception {
		
	}

	@Override
	public void constructAuditError(RequestMethod method, BranchRequest request, List<ErrorHolder> errors)
			throws Exception {
		
	}

}

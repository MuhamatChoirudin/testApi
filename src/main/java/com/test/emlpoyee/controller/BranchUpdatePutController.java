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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.emlpoyee.constants.RestConstant;
import com.test.emlpoyee.constants.SystemConstant;
import com.test.emlpoyee.controller.abstrac.AbstractPostController;
import com.test.emlpoyee.controller.abstrac.AbstractPutController;
import com.test.emlpoyee.dao.BranchDao;
import com.test.emlpoyee.dto.BranchDto;
import com.test.emlpoyee.entity.Branch;
import com.test.emlpoyee.exception.ApplicationException;
import com.test.emlpoyee.exception.ErrorHolder;
import com.test.emlpoyee.model.BranchRequest;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(RestConstant.API + RestConstant.Branch.BRANCH)
@Api(value = "Update Branch", tags = "Update Branch")
public class BranchUpdatePutController extends AbstractPutController<BranchDto, String, BranchUpdatePutController>{

	@Autowired
	BranchDao branchDao;
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}"+RestConstant.EDIT)
	public ResponseEntity<String> save(@Valid @RequestParam String id, @RequestBody BranchDto request)throws Exception{
		request.setId(id);
		return preExecute(request);
		
	}

	@Override
	public ResponseEntity<String> execute(BranchDto request)
			throws Exception {
		
		try{
			branchDao.updateBranch(request);			
		}catch(Exception e){
		
				throw e;

		}
		
		return ResponseEntity.accepted().body("");
	}
	
	@Override
	public void constructAuditSuccess(RequestMethod method, BranchDto request, ResponseEntity<String> response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void constructAuditError(RequestMethod method, BranchDto request, List<ErrorHolder> errors)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


	
	
	
}

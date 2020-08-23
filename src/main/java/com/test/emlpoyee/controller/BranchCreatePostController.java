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
import com.test.emlpoyee.dto.BranchDto;
import com.test.emlpoyee.exception.ErrorHolder;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(RestConstant.API + RestConstant.Branch.BRANCH)
@Api(value = "Save Branch", tags = "Save Branch")
public class BranchCreatePostController extends AbstractPostController<BranchDto, String, BranchCreatePostController>{

	@Autowired
	BranchDao branchDao;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = RestConstant.SAVE)
	public ResponseEntity<String> save(@Valid @RequestBody BranchDto request, BindingResult bindingResult)throws Exception{

		return execute(request, bindingResult);
		
	}

	@Override
	public ResponseEntity<String> postExecute(BranchDto request) throws Exception {
		branchDao.saveBranch(request);
		return  ResponseEntity.accepted().body("");
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

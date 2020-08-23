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
import com.test.emlpoyee.dao.BranchDao;
import com.test.emlpoyee.dto.BranchDto;
import com.test.emlpoyee.exception.ErrorHolder;
import com.test.emlpoyee.model.BranchRequest;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(RestConstant.API + RestConstant.Branch.BRANCH)
@Api(value = "Dalete Branch", tags = "Dalete Branch")
public class BranchDeleteByIdPostController extends AbstractPostController<BranchRequest, String, BranchDeleteByIdPostController>{

	@Autowired
	BranchDao branchDao;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = RestConstant.DELETE)
	public ResponseEntity<String> save(@RequestBody String id, BindingResult bindingResult)throws Exception{
		BranchRequest request = new BranchRequest();
		request.setId(id);
		return execute(request, bindingResult);
		
	}

	@Override
	public ResponseEntity<String> postExecute(BranchRequest request) throws Exception {
		branchDao.deleteBranch(request.getId());
		return  ResponseEntity.accepted().body("");
	}

	@Override
	public void constructAuditSuccess(RequestMethod method, BranchRequest request, ResponseEntity<String> response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void constructAuditError(RequestMethod method, BranchRequest request, List<ErrorHolder> errors)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}

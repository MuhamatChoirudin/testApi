package com.test.emlpoyee.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.emlpoyee.constants.RestConstant;
import com.test.emlpoyee.constants.SystemConstant;
import com.test.emlpoyee.dao.BranchDao;
import com.test.emlpoyee.dao.EmployeeDao;
import com.test.emlpoyee.dto.BranchDto;
import com.test.emlpoyee.entity.Branch;
import com.test.emlpoyee.entity.Employee;
import com.test.emlpoyee.exception.DataNotFoundException;
import com.test.emlpoyee.model.EmployeeRequest;
import com.test.emlpoyee.model.GetBranchAllRequest;
import com.test.emlpoyee.model.GetBranchAllResponse;
import com.test.emlpoyee.model.GetEmployeeAllRequest;
import com.test.emlpoyee.model.GetEmployeeAllResponse;
import com.test.emlpoyee.model.SearchDataAllRequest;
import com.test.emlpoyee.repository.BranchRepository;
import com.test.emlpoyee.repository.EmployeeRepository;

@Service
public class BranchService implements BranchDao{

	@Autowired
	private BranchRepository branchRepository;

	@Override
	public Branch getBranchById(String id) throws Exception {
		Optional<Branch> response = branchRepository.findById(id);
		System.out.println(response.get().getId());
		return response.isPresent() ? response.get():null;
	}

	@Override
	public GetBranchAllResponse getBranchAll(GetBranchAllRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Branch saveBranch(BranchDto request) throws Exception {
		Branch branch = setBranch(request);
		String uniqueID ="BR-" + RandomStringUtils.randomNumeric(5);		
		branch.setId(uniqueID);
		return branchRepository.save(branch);
	}

	@Override
	public Branch setBranch(BranchDto request) throws Exception {
		Branch branch = new Branch();
		branch.setEhomeId(request.getEhomeId());
		branch.setLastActive(request.getLastActive());
		branch.setEhomeId(request.getEhomeId());
		branch.setLavel(request.getLavel());
		branch.setName(request.getName());
		branch.setParentId(request.getParentId());
		branch.setParentName(request.getParentName());
		branch.setTimezone(request.getTimezone());
		return branch;
	}

	@Override
	public Branch deleteBranch(String id) throws Exception {
		Branch branch = branchRepository.getOne(id);
		if(branch.getLastActive()==true) {
				branch.setLastActive(false);
			}else {
				
			throw new DataNotFoundException(SystemConstant.ResponseCode.DATA_NOT_FOUND);
			}
		return branchRepository.save(branch);
	}

	@Override
	public Branch updateBranch(BranchDto request) throws Exception {
		Branch data =getBranchById(request.getId());
		if(data==null) {
			throw new DataNotFoundException(SystemConstant.ResponseCode.DATA_NOT_FOUND);
		}
		Branch branch = setBranch(request);
		return branchRepository.save(branch);
	}

	@Override
	public GetBranchAllResponse searchBranchAll(SearchDataAllRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

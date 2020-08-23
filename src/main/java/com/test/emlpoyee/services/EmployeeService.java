package com.test.emlpoyee.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.emlpoyee.constants.SystemConstant;
import com.test.emlpoyee.dao.EmployeeDao;
import com.test.emlpoyee.dto.EmployeeDto;
import com.test.emlpoyee.entity.Branch;
import com.test.emlpoyee.entity.Employee;
import com.test.emlpoyee.exception.DataNotFoundException;
import com.test.emlpoyee.model.EmployeeRequest;
import com.test.emlpoyee.model.GetEmployeeAllRequest;
import com.test.emlpoyee.model.GetEmployeeAllResponse;
import com.test.emlpoyee.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeDao{

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee getEmployeeById(String id) throws Exception {
		Optional<Employee> response = employeeRepository.findById(id);
		System.out.println(response.get().getId());
		return response.isPresent() ? response.get():null;
	}

	@Override
	public GetEmployeeAllResponse getEmployeeAll(GetEmployeeAllRequest request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee saveBranch(EmployeeDto request) throws Exception {
		Employee employee = setBranch(request);
		String uniqueID ="EM-" + RandomStringUtils.randomNumeric(5);		
		employee.setId(uniqueID);
		return employeeRepository.save(employee);
	}

	@Override
	public Employee setBranch(EmployeeDto request) throws Exception {
		Employee employee = new Employee();
		employee.setActive(request.getActive());
		employee.setAddress(request.getAddress());
		employee.setBankAccountName(request.getBankAccountName());
		employee.setBankAccountNumber(request.getBankAccountNumber());
		employee.setBaseSalary(request.getBaseSalary());
		employee.setBaseSalaryIdx(request.getBaseSalaryIdx());
		employee.setBiometricNumber(request.getBiometricNumber());
		employee.setBpjsCharge(request.getBpjsCharge());
		employee.setBpjsExtra(request.getBpjsExtra());
		employee.setBpjsSalary(request.getBpjsSalary());
		employee.setBranch(request.getBranch());
		employee.setBranchId(request.getBranchId());
		employee.setDailySalary(request.getDailySalary());
		employee.setFineCharge(request.getFineCharge());
		employee.setIncentiveExtra(request.getIncentiveExtra());
		employee.setJstCharge(request.getJstCharge());
		employee.setJstExtra(request.getJstExtra());
		employee.setLoanCharge(request.getLoanCharge());
		employee.setMealCharge(request.getMealCharge());
		employee.setMealExtra(request.getMealExtra());
		employee.setMiscCharge(request.getMiscCharge());
		employee.setMiscExtra(request.getMiscExtra());
		employee.setName(request.getName());
		employee.setNik(request.getNik());
		employee.setNumber(request.getNumber());
		employee.setRole(request.getRole());
		employee.setTitle(request.getTitle());
		employee.setTitleExtra(request.getTitleExtra());
		employee.setWorkEnd(request.getWorkEnd());
		employee.setWorkEndReason(request.getWorkEndReason());
		employee.setWorkStart(request.getWorkStart());
		return employee;
	}

	@Override
	public Employee deleteBranch(String id) throws Exception {
		Employee employee = employeeRepository.getOne(id);
		if(employee.getActive()==true) {
			employee.setActive(false);
			}else {
				
			throw new DataNotFoundException(SystemConstant.ResponseCode.DATA_NOT_FOUND);
			}
		return employeeRepository.save(employee);
	}

	
}

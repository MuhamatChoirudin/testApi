package com.test.emlpoyee.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	@JsonIgnore
	private String id;
	private String name;

	private String number;

	private String biometricNumber;

	private String title;

	private Date workStart;

	private Date workEnd;

	private String workEndReason;

	private Integer baseSalaryIdx;

	private int baseSalary;

	private Integer dailySalary;

	private Integer bpjsSalary;

	private Integer mealExtra;

	private Integer titleExtra;

	private Integer jstExtra;

	private Integer bpjsExtra;

	private Integer incentiveExtra;

	private Integer miscExtra;

	private Integer mealCharge;

	private Integer jstCharge;

	private Integer bpjsCharge;
	
	private Integer fineCharge;
	
	private Integer loanCharge;
	
	private Integer miscCharge;

	private String bankAccountNumber;

	private String bankAccountName;

	private String nik;

	private String address;

	private String role;

	private Boolean active;

	private String branch;
	
	private String branchId;
}

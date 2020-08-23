package com.test.emlpoyee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "NUMBER")
	private String number;
	
	@Column(name = "BIOMETRIC_NUMBER")
	private String biometricNumber;
	
	@Column(name = "TITEL")
	private String title;	
	
	@Column(name = "WORK_START")
	private Date workStart;	
	
	@Column(name = "WORK_END")
	private Date workEnd;	
	
	@Column(name = "WORK_END_REASON")
	private String workEndReason;	
	
	@Column(name = "BASE_SALARY_IDX")
	private Integer baseSalaryIdx;
	
	@Column(name = "BASE_SALARY")
	private int baseSalary;
	
	@Column(name = "DAILY_SALARY")
	private Integer dailySalary;
	
	@Column(name = "BPJS_SALARY")
	private Integer bpjsSalary;
	
	@Column(name = "MEAL_EXTRA")
	private Integer mealExtra;
	
	@Column(name = "TITLE_EXTRA")
	private Integer titleExtra;
	
	@Column(name = "JST_EXTRA")
	private Integer jstExtra;
	
	@Column(name = "BPJS_EXTRA")
	private Integer bpjsExtra;
	
	@Column(name = "INCENTIVE_EXTRA")
	private Integer incentiveExtra;
	
	@Column(name = "MISC_EXTRA")
	private Integer miscExtra;
	
	@Column(name = "MEAL_CHARGE")
	private Integer mealCharge;
	
	@Column(name = "JST_CHARGE")
	private Integer jstCharge;
	
	@Column(name = "BPJS_CHARGE")
	private Integer bpjsCharge;
	
	@Column(name = "FINE_CHARGE")
	private Integer fineCharge;
	
	@Column(name = "LOAN_CHARGE")
	private Integer loanCharge;
	
	@Column(name = "MISC_CHARGE")
	private Integer miscCharge;
	
	@Column(name = "BANK_ACCOUNT_NUMBER")
	private String bankAccountNumber;
	
	@Column(name = "BANK_ACCOUNT_NAME")
	private String bankAccountName;
	
	@Column(name = "NIK")
	private String nik;
	
	@Column(name = "ADDRESS")
	private String address;	
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "ACTIVE")
	private Boolean active;
	
	@Column(name = "BRANCH")
	private String branch;
	
	@Column(name = "BRANCH_ID")
	private String branchId;	
}

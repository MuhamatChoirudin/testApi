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
@Table(name = "BRANCH")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Branch {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAVEL")
	private Integer lavel;
	
	@Column(name = "PARENT_NAME")
	private String parentName;
	
	@Column(name = "PARENT_ID")
	private String parentId;	
	
	@Column(name = "TIMEZONE")
	private String timezone;	
	
	@Column(name = "EHOME_ID")
	private String ehomeId;	
	
	@Column(name = "LAST_ACTIVE")
	private Boolean lastActive;		
}

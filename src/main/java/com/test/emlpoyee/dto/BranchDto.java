package com.test.emlpoyee.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchDto {
	
@JsonIgnore
	private String id;
	
	private String name;
	
	private Integer lavel;
	
	private String parentName;
	
	private String parentId;	
	
	private String timezone;	
	
	private String ehomeId;	
	
	private Boolean lastActive;	
}

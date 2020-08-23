package com.test.emlpoyee.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetEmployeeAllRequest {

	private String recordLimit;

	private String pageNumber;
}

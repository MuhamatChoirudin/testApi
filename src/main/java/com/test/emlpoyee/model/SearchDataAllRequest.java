package com.test.emlpoyee.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDataAllRequest {

	private String key;
	
	private String value;
	
	private String recordLimit;

	private String pageNumber;
}

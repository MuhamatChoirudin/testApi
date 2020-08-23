package com.test.emlpoyee.exception;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.emlpoyee.constants.SystemConstant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationException extends RuntimeException{

	private static final long serialVersionUID = 9223286976090577002L;

	private List<ErrorHolder> errors = new LinkedList<>();

	private HttpStatus httpStatus = null;
	
	private HttpHeaders httpHeaders = null;
	
	public ApplicationException(ErrorHolder errorHolder) {
		super("");
		getErrors().add(errorHolder);
	}
	
	public ApplicationException(HttpStatus httpStatus, HttpHeaders httpHeaders, ErrorHolder errorHolder) {
		super("");
		this.httpStatus = httpStatus;
		this.httpHeaders = httpHeaders;
		getErrors().add(errorHolder);
	}
	
	public ApplicationException(List<ErrorHolder> errors) {
		this.errors = errors;
	}
	
	public ApplicationException(HttpStatus httpStatus, HttpHeaders httpHeaders, List<ErrorHolder> errors) {
		this.httpStatus = httpStatus;
		this.httpHeaders = httpHeaders;
		this.errors = errors;
	}
	
	public List<ErrorHolder> getErrors() {
		return errors;
	}
	
	public Boolean isEmpty() {
		return errors.size() == 0;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public HttpHeaders getHttpHeaders() {
		return httpHeaders;
	}
	
	@Override
	public String getMessage() {
		if (super.getMessage()==null || super.getMessage().isEmpty()) {
			StringBuilder stringBuilder = new StringBuilder();
			if (errors!=null && errors.get(0)!=null) {
				ErrorHolder errorHolder = errors.get(0);
				if (errorHolder.getErrorCode()!=null && !errorHolder.getErrorCode().isEmpty()) {
					stringBuilder.append(" "+errorHolder.getErrorCode());
				} 
				if (errorHolder.getErrorMessage()!=null && !errorHolder.getErrorMessage().isEmpty()) {
					stringBuilder.append(" "+errorHolder.getErrorMessage());
				}
				if (!stringBuilder.toString().isEmpty()) {
					return stringBuilder.toString();
				} 
			} 
			return SystemConstant.APPLICATION_EXCEPTION_DEFAULT;
		}
		return super.getMessage();
	}

}

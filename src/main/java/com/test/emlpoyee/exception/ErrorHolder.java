package com.test.emlpoyee.exception;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.emlpoyee.constants.SystemConstant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorHolder implements Serializable{

	private static final long serialVersionUID = 7236256080934819271L;

	@JsonProperty("error_code")
	private String errorCode;
	
	@JsonProperty("error_message")
	private String errorMessage;
	
	@JsonIgnore
	private String fieldName;
	
	public static ErrorHolder newInstance(String errorCode, String errorMessage) {
		ErrorHolder obj = new ErrorHolder();
			obj.setErrorCode(errorCode);
			obj.setErrorMessage(errorMessage);
		return obj;
	}
	
	public static ErrorHolder newInstance(String fieldName, String errorCode, String errorMessage) {
		ErrorHolder obj = new ErrorHolder();
			obj.setFieldName(fieldName);
			obj.setErrorCode(errorCode);
			obj.setErrorMessage(errorMessage);
		return obj;
	}
	
	public static ErrorHolder newGeneralErrorInstance(String errorMessage) {
		ErrorHolder obj = new ErrorHolder();
			obj.setErrorCode(SystemConstant.ErrorCode.GENERAL_ERROR);
			obj.setErrorMessage(errorMessage);
		return obj;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public boolean equals(Object param) {
		if (!(param instanceof ErrorHolder)) {
			return Boolean.FALSE;
		}
		ErrorHolder convertedParam = (ErrorHolder) param;
		if(StringUtils.isNotEmpty(this.getFieldName())
				&& StringUtils.isNotEmpty(convertedParam.getFieldName())
				&& this.getFieldName().equals(convertedParam.getFieldName())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}

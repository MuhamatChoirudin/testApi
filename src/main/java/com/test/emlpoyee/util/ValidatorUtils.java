package com.test.emlpoyee.util;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;

import com.test.emlpoyee.constants.SystemConstant;
import com.test.emlpoyee.exception.ApplicationException;
import com.test.emlpoyee.exception.ErrorHolder;



public class ValidatorUtils {
	
	
	public static void validate(Object obj, HttpHeaders headers, MessageSource messageSource, String key){
		if (!headers.containsKey(key)) {
			ErrorHolder errorHolder = new ErrorHolder();
			errorHolder.setErrorCode(SystemConstant.ResponseCode.COM01);
			errorHolder.setErrorMessage(getMessage(SystemConstant.ResponseCode.COM01,messageSource, key));
			throw new ApplicationException(errorHolder);
		}
		
		if (headers.get(key).get(0).isEmpty()) {
			ErrorHolder errorHolder = new ErrorHolder();
			errorHolder.setErrorCode(SystemConstant.ResponseCode.COM01);
			errorHolder.setErrorMessage(getMessage(SystemConstant.ResponseCode.COM01,messageSource, key));
			throw new ApplicationException(errorHolder);
		}
		
	}
	
	private static String getMessage(String key, MessageSource messageSource, Object... args){
		return messageSource.getMessage(key, args, SystemConstant.DEFAULT_LOCALE);
	} static void validateReferenceNo(Object obj, HttpHeaders headers, MessageSource messageSource){
		if (!headers.containsKey(SystemConstant.ProjectParam.referenceNo.toString())) {
			ErrorHolder errorHolder = new ErrorHolder();
			errorHolder.setErrorCode(SystemConstant.ResponseCode.COM01);
			errorHolder.setErrorMessage(getMessage(SystemConstant.ResponseCode.COM01,messageSource, SystemConstant.ProjectParam.referenceNo.toString()));
			throw new ApplicationException(errorHolder);
		}
		
		if (headers.get(SystemConstant.ProjectParam.referenceNo.toString()).get(0).isEmpty()) {
			ErrorHolder errorHolder = new ErrorHolder();
			errorHolder.setErrorCode(SystemConstant.ResponseCode.COM01);
			errorHolder.setErrorMessage(getMessage(SystemConstant.ResponseCode.COM01,messageSource, SystemConstant.ProjectParam.referenceNo.toString()));
			throw new ApplicationException(errorHolder);
		}
		
	}
	
	public static Object validateHeader(Object obj, HttpHeaders headers, MessageSource messageSource){
		validateReferenceNo(obj, headers, messageSource);
		return obj;
	
	}
	public static Object validateHeader(Object obj, HttpHeaders headers, MessageSource messageSource, String... keys){
		validateReferenceNo(obj, headers, messageSource);
		for (String key : keys) {
			validate(obj, headers, messageSource, key);
		}
		return obj;
	
	}

}

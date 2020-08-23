package com.test.emlpoyee.controller.abstrac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.emlpoyee.constants.SystemConstant;
import com.test.emlpoyee.exception.ApplicationException;
import com.test.emlpoyee.exception.ErrorHolder;
import com.test.emlpoyee.util.ValidatorUtils;




@Scope(value = "request")
@Controller
public abstract class AbstractGetController<T, Y, Z> {
	
	@Autowired
	protected MessageSource messageSource;
	
	public ResponseEntity<Y> preExecute(@RequestBody T request) throws Exception {
		
		try {
			//ResponseEntity<Y> response = execute(validate(request, headers), headers);
			ResponseEntity<Y> response = execute(request);
			constructAuditSuccess(RequestMethod.GET, request, response);
			return response;
		} catch (ApplicationException ae) {
			constructAuditError(RequestMethod.GET, request, ae.getErrors());
			
		}
		
		return null;
	}
	
	public abstract void constructAuditSuccess(RequestMethod method, T request, ResponseEntity<Y> response) throws Exception;
	
	
//	@SuppressWarnings("unchecked")
//	public T validate(T request, HttpHeaders headers) throws ApplicationException, Exception {
//		return (T)ValidatorUtils.validateHeader(request, headers, messageSource);
//	}

	public abstract void constructAuditError(RequestMethod method, T request, List<ErrorHolder> errors) throws Exception;

	
	public ResponseEntity<Y> execute(T request) throws Exception {
		return null;
	}
	
	
}

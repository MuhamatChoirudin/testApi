package com.test.emlpoyee.controller.abstrac;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.emlpoyee.exception.ApplicationException;
import com.test.emlpoyee.exception.ErrorHolder;




@Scope(value = "request")
@Controller
public abstract class AbstractPutController<T, Y, Z> {
	
	public ResponseEntity<Y> preExecute(@RequestBody T request) throws Exception {
		
		try {
			
			ResponseEntity<Y> response = execute(request);
		
			constructAuditSuccess(RequestMethod.PUT, request, response);
			
			return response;
		} catch (ApplicationException ae) {
			
			constructAuditError(RequestMethod.PUT, request, ae.getErrors());
	
			throw ae;
		}
	}

	
	public ResponseEntity<Y> execute(T request) throws Exception {
		return null;
	}
	public abstract void constructAuditSuccess(RequestMethod method, T request, ResponseEntity<Y> response) throws Exception;
	
	public abstract void constructAuditError(RequestMethod method, T request, List<ErrorHolder> errors) throws Exception;

	
	
}

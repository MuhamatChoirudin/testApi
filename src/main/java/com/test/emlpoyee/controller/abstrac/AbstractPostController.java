package com.test.emlpoyee.controller.abstrac;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.emlpoyee.exception.ApplicationException;
import com.test.emlpoyee.exception.ErrorHolder;




@Scope(value = "request")
@Controller
public abstract class AbstractPostController<T, Y, Z> {
	
	public ResponseEntity<Y> execute(@RequestBody T request, BindingResult bindingResult) throws Exception {
		
		if (bindingResult!= null && bindingResult.hasErrors()) {
			
            throw new ApplicationException(ErrorHolder.newGeneralErrorInstance("Invalid Validation"));
        }

		try {
			
			ResponseEntity<Y> response = postExecute(request);
		
			constructAuditSuccess(RequestMethod.POST, request, response);
			
			return response;
		} catch (ApplicationException ae) {
			
			constructAuditError(RequestMethod.POST, request, ae.getErrors());
	
			throw ae;
		}
	}

	
	public abstract ResponseEntity<Y> postExecute(T request) throws Exception;
	
	public abstract void constructAuditSuccess(RequestMethod method, T request, ResponseEntity<Y> response) throws Exception;
	
	public abstract void constructAuditError(RequestMethod method, T request, List<ErrorHolder> errors) throws Exception;

	
	
}

package com.test.emlpoyee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author hendriyauw
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4264713271940574624L;

	public DataNotFoundException(String message) {
		super(message);
	}
}

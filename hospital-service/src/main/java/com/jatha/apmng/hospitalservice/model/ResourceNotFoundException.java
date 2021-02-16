package com.jatha.apmng.hospitalservice.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.team.mighty.exception;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Shankara
 *
 */
public class MightyAppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public MightyAppException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}

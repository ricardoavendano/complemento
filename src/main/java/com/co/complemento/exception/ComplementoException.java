package com.co.complemento.exception;

import org.springframework.http.HttpStatus;

public class ComplementoException extends Exception {

	private static final long serialVersionUID = 5413924602670036267L;

	private final String errorMessage;
	private final HttpStatus status;

	public ComplementoException(String errorMessage, HttpStatus status) {
		this.errorMessage = errorMessage;
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}
}

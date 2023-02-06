package com.co.complemento.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.co.complemento.datatransfer.Error;
import com.co.complemento.exception.ComplementoException;

@Service
public class ErrorService {

	public Error getError(Exception e) {

		if (e instanceof ComplementoException) {
			return new Error("ComplementoException", ((ComplementoException) e).getErrorMessage(),
					((ComplementoException) e).getStatus());
		}

		Map<String, String> params = new HashMap<>();
		params.put("Exception", e.getClass() + "-" + e.getMessage());
		params.put("Time", LocalDateTime.now().toString());

		return new Error("ComplementoException", "Unknown Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

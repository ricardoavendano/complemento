package com.co.complemento.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.co.complemento.datatransfer.Error;
import com.co.complemento.exception.ComplementoException;

@ExtendWith(MockitoExtension.class)
class ErrorServiceTest {

	@InjectMocks
	private ErrorService errorService;

	@Test
	void shouldBeANoContent() {

		Error error = errorService.getError(new ComplementoException("", HttpStatus.NO_CONTENT));
		assertEquals(HttpStatus.NO_CONTENT, error.getStatus());
	}

	@Test
	void shouldBeAnUnknownError() {
		Error error = errorService.getError(new Exception());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, error.getStatus());
	}
}

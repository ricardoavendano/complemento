package com.co.complemento.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.co.complemento.datatransfer.Error;
import com.co.complemento.datatransfer.ResponseDTO;
import com.co.complemento.exception.ComplementoException;
import com.co.complemento.service.ComplementoService;
import com.co.complemento.service.ErrorService;

import fj.data.Either;

@ExtendWith(MockitoExtension.class)
class ComplementoControllerTest {

	@InjectMocks
	private ComplementoController complementoController;

	@Mock
	private ComplementoService complementoService;

	@Mock
	private ErrorService errorService;

	private static final String DATE_FORMAT = "yyyy-MM-dd-HH.mm.ss";

	@Test
	void checkPricesSuccessfully() throws ParseException {

		ResponseDTO responseDTO = new ResponseDTO();

		Either<Exception, ResponseDTO> resultEither = Either.right(responseDTO);

		when(complementoService.findPrices(any(), anyLong(), anyLong())).thenReturn(resultEither);

		ResponseEntity<?> res = complementoController.checkPrices(
				new SimpleDateFormat(DATE_FORMAT).parse("2020-06-16-21.00.00"), Long.valueOf(35455), Long.valueOf(1));

		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	@Test
	void buscarPersonaErrorTest() throws ParseException {

		Either<Exception, ResponseDTO> resultEither = Either
				.left(new ComplementoException("No content", HttpStatus.NO_CONTENT));

		Error error = new Error("ComplementoException", "No content", HttpStatus.NO_CONTENT);

		when(errorService.getError(any())).thenReturn(error);
		when(complementoService.findPrices(any(), anyLong(), anyLong())).thenReturn(resultEither);

		ResponseEntity<?> res = complementoController.checkPrices(
				new SimpleDateFormat(DATE_FORMAT).parse("2010-06-16-21.00.00"), Long.valueOf(35455), Long.valueOf(1));

		assertEquals(HttpStatus.NO_CONTENT, res.getStatusCode());
	}
}

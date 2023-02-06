package com.co.complemento.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.complemento.datatransfer.Error;
import com.co.complemento.datatransfer.ResponseDTO;
import com.co.complemento.service.ComplementoService;
import com.co.complemento.service.ErrorService;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping
@RestController
@Controller
public class ComplementoController {

	@Autowired
	private ComplementoService complementoService;

	@Autowired
	private ErrorService errorService;

	@GetMapping(value = "/checkPrices", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> checkPrices(
			@RequestParam("applicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") Date applicationDate,
			@RequestParam("productId") Long productId, @RequestParam("brandId") Long brandId) {

		Either<Exception, ResponseDTO> resultEither = complementoService.findPrices(applicationDate, productId,
				brandId);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error.getDescription(), error.getStatus());
	}

}

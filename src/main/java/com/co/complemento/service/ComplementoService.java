package com.co.complemento.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.co.complemento.datatransfer.ResponseDTO;

import fj.data.Either;

@Service
public interface ComplementoService {

	public Either<Exception, ResponseDTO> findPrices(Date applicationDate, Long productId, Long brandId);

}

package com.co.complemento.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.co.complemento.datatransfer.ResponseDTO;
import com.co.complemento.domain.Prices;
import com.co.complemento.exception.ComplementoException;
import com.co.complemento.repository.PricesRepository;
import com.co.complemento.service.ComplementoService;

import fj.data.Either;

@Service
public class ComplementoServiceImp implements ComplementoService {

	@Autowired
	private PricesRepository pricesRepository;

	@Override
	public Either<Exception, ResponseDTO> findPrices(Date applicationDate, Long productId, Long brandId) {

		Timestamp ts = new Timestamp(applicationDate.getTime());

		List<Prices> prices = pricesRepository.findAllPricesMatches(ts, productId, brandId);

		if (prices.isEmpty()) {
			return Either.left(new ComplementoException("No content", HttpStatus.NO_CONTENT));
		}

		ResponseDTO response = new ResponseDTO();
		response.setApplicationDate(ts.toString());
		response.setBrandId(prices.get(0).getBrandId());
		response.setBrandName(prices.get(0).getIdBrandPK().getName());
		response.setStartDate(prices.get(0).getStartDate().toString());
		response.setEndDate(prices.get(0).getEndDate().toString());
		response.setProductId(prices.get(0).getProductId());
		response.setPrice(prices.get(0).getPrice());
		response.setPriceList(prices.get(0).getPriceList());
		return Either.right(response);
	}
}

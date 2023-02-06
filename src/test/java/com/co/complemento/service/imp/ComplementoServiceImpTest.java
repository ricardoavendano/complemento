package com.co.complemento.service.imp;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.co.complemento.datatransfer.Error;
import com.co.complemento.datatransfer.ResponseDTO;
import com.co.complemento.domain.Brand;
import com.co.complemento.domain.Prices;
import com.co.complemento.repository.PricesRepository;
import com.co.complemento.service.ErrorService;
import com.co.complemento.service.impl.ComplementoServiceImp;

import fj.data.Either;

@ExtendWith(MockitoExtension.class)
class ComplementoServiceImpTest {

	@InjectMocks
	private ComplementoServiceImp complementoServiceImp;

	@Mock
	private PricesRepository pricesRepository;

	private static final String DATE_FORMAT = "yyyy-MM-dd-HH.mm.ss";

	@Test
	void shouldReturnAnExceptionWhenNoDataIsFound() throws ParseException {

		Either<Exception, ResponseDTO> res = complementoServiceImp.findPrices(
				new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-10.00.00"), Long.valueOf(1234), Long.valueOf(1234));

		ErrorService errorService = new ErrorService();
		Error error = errorService.getError(res.left().value());

		assertEquals(HttpStatus.NO_CONTENT, error.getStatus());
		assertTrue(res.isLeft());
	}

	@Test
	void shouldBeSuccessfulTest1() throws ParseException {

		List<Prices> pricesList = new ArrayList<>();

		Brand brand = new Brand();
		brand.setIdBrand(Long.valueOf(1));
		brand.setName("Zara");

		Prices prices = new Prices();
		prices.setBrandId(Long.valueOf(1));
		prices.setCrr("EUR");
		prices.setStartDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-00.00.00").getTime()));
		prices.setEndDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-12-31-23.59.59").getTime()));
		prices.setIdBrandPK(brand);
		prices.setIdPrices(Long.valueOf(1));
		prices.setPriceList(Long.valueOf(1));
		prices.setPriority(Long.valueOf(0));
		prices.setProductId(Long.valueOf(35455));
		prices.setPrice(Float.valueOf("35.50"));

		pricesList.add(prices);

		when(pricesRepository.findAllPricesMatches(any(), anyLong(), anyLong())).thenReturn(pricesList);

		Either<Exception, ResponseDTO> res = complementoServiceImp.findPrices(
				new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-10.00.00"), Long.valueOf(35455), Long.valueOf(1));

		assertTrue(res.isRight());
		assertEquals(35.50, ((int) (res.right().value().getPrice() * 100)) / 100.00);
	}

	@Test
	void shouldBeSuccessfulTest2() throws ParseException {

		List<Prices> pricesList = new ArrayList<>();

		Brand brand = new Brand();
		brand.setIdBrand(Long.valueOf(1));
		brand.setName("Zara");

		Prices prices1 = new Prices();
		prices1.setBrandId(Long.valueOf(1));
		prices1.setCrr("EUR");
		prices1.setStartDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-15.00.00").getTime()));
		prices1.setEndDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-18.30.00").getTime()));
		prices1.setIdBrandPK(brand);
		prices1.setIdPrices(Long.valueOf(1));
		prices1.setPriceList(Long.valueOf(2));
		prices1.setPriority(Long.valueOf(1));
		prices1.setProductId(Long.valueOf(35455));
		prices1.setPrice(Float.valueOf("25.45"));

		pricesList.add(prices1);

		Prices prices2 = new Prices();
		prices2.setBrandId(Long.valueOf(1));
		prices2.setCrr("EUR");
		prices2.setStartDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-00.00.00").getTime()));
		prices2.setEndDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-12-31-23.59.59").getTime()));
		prices2.setIdBrandPK(brand);
		prices2.setIdPrices(Long.valueOf(1));
		prices2.setPriceList(Long.valueOf(1));
		prices2.setPriority(Long.valueOf(0));
		prices2.setProductId(Long.valueOf(35455));
		prices2.setPrice(Float.valueOf("35.50"));

		pricesList.add(prices2);

		when(pricesRepository.findAllPricesMatches(any(), anyLong(), anyLong())).thenReturn(pricesList);

		Either<Exception, ResponseDTO> res = complementoServiceImp.findPrices(
				new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-16.00.00"), Long.valueOf(35455), Long.valueOf(1));

		assertTrue(res.isRight());
		assertEquals(25.45, ((int) (res.right().value().getPrice() * 100)) / 100.00);
	}

	@Test
	void shouldBeSuccessfulTest3() throws ParseException {

		List<Prices> pricesList = new ArrayList<>();

		Brand brand = new Brand();
		brand.setIdBrand(Long.valueOf(1));
		brand.setName("Zara");

		Prices prices = new Prices();
		prices.setBrandId(Long.valueOf(1));
		prices.setCrr("EUR");
		prices.setStartDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-00.00.00").getTime()));
		prices.setEndDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-12-31-23.59.59").getTime()));
		prices.setIdBrandPK(brand);
		prices.setIdPrices(Long.valueOf(1));
		prices.setPriceList(Long.valueOf(1));
		prices.setPriority(Long.valueOf(0));
		prices.setProductId(Long.valueOf(35455));
		prices.setPrice(Float.valueOf("35.50"));

		pricesList.add(prices);

		when(pricesRepository.findAllPricesMatches(any(), anyLong(), anyLong())).thenReturn(pricesList);

		Either<Exception, ResponseDTO> res = complementoServiceImp.findPrices(
				new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-21.00.00"), Long.valueOf(35455), Long.valueOf(1));

		assertTrue(res.isRight());
		assertEquals(35.50, ((int) (res.right().value().getPrice() * 100)) / 100.00);
	}

	@Test
	void shouldBeSuccessfulTest4() throws ParseException {

		List<Prices> pricesList = new ArrayList<>();

		Brand brand = new Brand();
		brand.setIdBrand(Long.valueOf(1));
		brand.setName("Zara");

		Prices prices1 = new Prices();
		prices1.setBrandId(Long.valueOf(1));
		prices1.setCrr("EUR");
		prices1.setStartDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-15-00.00.00").getTime()));
		prices1.setEndDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-15-11.00.00").getTime()));
		prices1.setIdBrandPK(brand);
		prices1.setIdPrices(Long.valueOf(1));
		prices1.setPriceList(Long.valueOf(3));
		prices1.setPriority(Long.valueOf(1));
		prices1.setProductId(Long.valueOf(35455));
		prices1.setPrice(Float.valueOf("30.50"));

		pricesList.add(prices1);

		Prices prices2 = new Prices();
		prices2.setBrandId(Long.valueOf(1));
		prices2.setCrr("EUR");
		prices2.setStartDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-00.00.00").getTime()));
		prices2.setEndDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-12-31-23.59.59").getTime()));
		prices2.setIdBrandPK(brand);
		prices2.setIdPrices(Long.valueOf(1));
		prices2.setPriceList(Long.valueOf(1));
		prices2.setPriority(Long.valueOf(0));
		prices2.setProductId(Long.valueOf(35455));
		prices2.setPrice(Float.valueOf("35.50"));

		pricesList.add(prices1);

		when(pricesRepository.findAllPricesMatches(any(), anyLong(), anyLong())).thenReturn(pricesList);

		Either<Exception, ResponseDTO> res = complementoServiceImp.findPrices(
				new SimpleDateFormat(DATE_FORMAT).parse("2020-06-15-10.00.00"), Long.valueOf(35455), Long.valueOf(1));

		assertTrue(res.isRight());
		assertEquals(30.50, ((int) (res.right().value().getPrice() * 100)) / 100.00);
	}

	@Test
	void shouldBeSuccessfulTest5() throws ParseException {

		List<Prices> pricesList = new ArrayList<>();

		Brand brand = new Brand();
		brand.setIdBrand(Long.valueOf(1));
		brand.setName("Zara");

		Prices prices1 = new Prices();
		prices1.setBrandId(Long.valueOf(1));
		prices1.setCrr("EUR");
		prices1.setStartDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-15-16.00.00").getTime()));
		prices1.setEndDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-12-31-23.59.59").getTime()));
		prices1.setIdBrandPK(brand);
		prices1.setIdPrices(Long.valueOf(1));
		prices1.setPriceList(Long.valueOf(4));
		prices1.setPriority(Long.valueOf(1));
		prices1.setProductId(Long.valueOf(35455));
		prices1.setPrice(Float.valueOf("38.95"));

		pricesList.add(prices1);

		Prices prices2 = new Prices();
		prices2.setBrandId(Long.valueOf(1));
		prices2.setCrr("EUR");
		prices2.setStartDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-06-14-00.00.00").getTime()));
		prices2.setEndDate(new Timestamp(new SimpleDateFormat(DATE_FORMAT).parse("2020-12-31-23.59.59").getTime()));
		prices2.setIdBrandPK(brand);
		prices2.setIdPrices(Long.valueOf(1));
		prices2.setPriceList(Long.valueOf(1));
		prices2.setPriority(Long.valueOf(0));
		prices2.setProductId(Long.valueOf(35455));
		prices2.setPrice(Float.valueOf("35.50"));

		pricesList.add(prices2);

		when(pricesRepository.findAllPricesMatches(any(), anyLong(), anyLong())).thenReturn(pricesList);

		Either<Exception, ResponseDTO> res = complementoServiceImp.findPrices(
				new SimpleDateFormat(DATE_FORMAT).parse("2020-06-16-21.00.00"), Long.valueOf(35455), Long.valueOf(1));

		assertTrue(res.isRight());
		assertEquals(38.95, ((int) (res.right().value().getPrice() * 100)) / 100.00);
	}
}

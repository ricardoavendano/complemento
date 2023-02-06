package com.co.complemento.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.co.complemento.domain.Prices;

@Component
public interface PricesRepository extends CrudRepository<Prices, Long> {

	@Query("SELECT p FROM Prices p WHERE p.startDate <= :applicationDate AND p.endDate >= :applicationDate AND p.productId = :productId AND p.brandId = :brandId ORDER BY p.priority DESC")
	List<Prices> findAllPricesMatches(@Param("applicationDate") Timestamp applicationDate,
			@Param("productId") Long productId, @Param("brandId") Long brandId);
}

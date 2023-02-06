package com.co.complemento.datatransfer;

import java.util.Date;

import com.co.complemento.domain.Brand;

public class PricesDTO {

	private Long idPrices;
	private Brand group;
	private Long brandId;
	private Date startDate;
	private Date endDate;
	private Long priceId;
	private Long productId;
	private Long pririty;
	private Float price;
	private String crr;

	public Long getIdPrices() {
		return idPrices;
	}

	public void setIdPrices(Long idPrices) {
		this.idPrices = idPrices;
	}

	public Brand getGroup() {
		return group;
	}

	public void setGroup(Brand group) {
		this.group = group;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPririty() {
		return pririty;
	}

	public void setPririty(Long pririty) {
		this.pririty = pririty;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCrr() {
		return crr;
	}

	public void setCrr(String crr) {
		this.crr = crr;
	}

}

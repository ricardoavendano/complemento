package com.co.complemento.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
public class Prices implements Serializable {

	private static final long serialVersionUID = -5936329650033303260L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "idprices")
	private Long idPrices;

	@JoinColumn(name = "IDBRANDPK", referencedColumnName = "IDBRAND", nullable = false)
	@ManyToOne(optional = false)
	private Brand idBrandPK;

	@Column(nullable = false, name = "brandid")
	private Long brandId;

	@Column(nullable = false, name = "startdate")
	private Timestamp startDate;

	@Column(nullable = false, name = "enddate")
	private Timestamp endDate;

	@Column(nullable = false, name = "pricelist")
	private Long priceList;

	@Column(nullable = false, name = "productid")
	private Long productId;

	@Column(nullable = false, name = "priority")
	private Long priority;

	@Column(nullable = false, name = "price")
	private Float price;

	@Column(nullable = false, name = "curr")
	private String crr;

	public Long getIdPrices() {
		return idPrices;
	}

	public void setIdPrices(Long idPrices) {
		this.idPrices = idPrices;
	}

	public Brand getIdBrandPK() {
		return idBrandPK;
	}

	public void setIdBrandPK(Brand idBrandPK) {
		this.idBrandPK = idBrandPK;
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

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
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

	@Override
	public int hashCode() {
		return Objects.hash(brandId, crr, endDate, idBrandPK, idPrices, price, priceList, priority, productId,
				startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prices other = (Prices) obj;
		return Objects.equals(brandId, other.brandId) && Objects.equals(crr, other.crr)
				&& Objects.equals(endDate, other.endDate) && Objects.equals(idBrandPK, other.idBrandPK)
				&& Objects.equals(idPrices, other.idPrices) && Objects.equals(price, other.price)
				&& Objects.equals(priceList, other.priceList) && Objects.equals(priority, other.priority)
				&& Objects.equals(productId, other.productId) && Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "Prices [idPrices=" + idPrices + ", idBrandPK=" + idBrandPK + ", brandId=" + brandId + ", startDate="
				+ startDate + ", endDate=" + endDate + ", priceList=" + priceList + ", productId=" + productId
				+ ", priority=" + priority + ", price=" + price + ", crr=" + crr + "]";
	}

}

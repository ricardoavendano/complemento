package com.co.complemento.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand implements Serializable {

	private static final long serialVersionUID = -629636322850605729L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "idbrand")
	private Long idBrand;

	@Column(nullable = false, name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idBrandPK")
	private List<Prices> brandList;

	public Long getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(Long idBrand) {
		this.idBrand = idBrand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Prices> getbrandList() {
		return brandList;
	}

	public void setbrandList(List<Prices> brandList) {
		this.brandList = brandList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brandList, idBrand, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brand other = (Brand) obj;
		return Objects.equals(brandList, other.brandList) && Objects.equals(idBrand, other.idBrand)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Brand [idbrand=" + idBrand + ", name=" + name + ", brandList=" + brandList + "]";
	}

}

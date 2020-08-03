package com.product.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cityId;
	private String name;
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", name=" + name + "]";
	}
	
	
	
	
	
	
}

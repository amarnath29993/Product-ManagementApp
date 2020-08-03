package com.product.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class State {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stateId;
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="countryId")
	private Country country;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", name=" + name + ", country=" + country + "]";
	}

		

}
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
import javax.persistence.OneToMany;

@Entity
public class Country1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countryId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "CountryId",referencedColumnName = "CountryId")
	private Set<State1> states=new HashSet<State1>();

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<State1> getStates() {
		return states;
	}

	public void setStates(Set<State1> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", name=" + name + ", states=" + states + "]";
	}
	
	
	
	
	
	
}
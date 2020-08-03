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
public class State1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stateId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "stateId",referencedColumnName = "stateId")
	private Set<City1> cities=new HashSet<City1>();

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

	public Set<City1> getCities() {
		return cities;
	}

	public void setCities(Set<City1> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", name=" + name + ", cities=" + cities + "]";
	}
	
	
	

}
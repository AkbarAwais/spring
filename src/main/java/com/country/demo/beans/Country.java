package com.country.demo.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Country")
public class Country {
	
	@Id
	@Column(name="id")
	int id;
	
	@Column(name="country_name")
	String countryName;
	
	@Column(name="capital")
	String countryCapital;
	
	
	public Country(int id, String countryName, String countryCapital) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
	}
	public Country()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCounrtyName() {
		return countryName;
	}
	public void setCountryName(String countyName) {
		this.countryName = countyName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	
}

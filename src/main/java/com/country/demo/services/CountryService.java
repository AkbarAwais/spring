package com.country.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.country.demo.beans.Country;
import com.country.demo.controllers.AddResponse;
import com.country.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRep;
	
	
	public List<Country> getAllCountries()
	{
		return countryRep.findAll();
	}
	
	public Country getCountryId(int id)
	{
		return countryRep.findById(id).get();
	}
	
	public Country getCountryByName(String countryName)
	{
		List<Country> countries = countryRep.findAll();
		Country country = null;
		for(Country con:countries)
		{
			if(con.getCounrtyName().equals(countryName)) {
				country = con;
			}
		}
		return country;
		
	}
	
	
	public Country addCountry(Country country) 
	{
		country.setId(getMaxId());
		countryRep.save(country);
		return country;
	}
	
	
	public int getMaxId()
	{
		return countryRep.findAll().size()+1;
	}
	
	
	public Country updateCountry(Country country)
	{
		countryRep.save(country);
		return country;
	}
	
	
	public AddResponse deleteCountry(int id)
	{
		countryRep.deleteById(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Deleted");
		return res;
	}
	
}

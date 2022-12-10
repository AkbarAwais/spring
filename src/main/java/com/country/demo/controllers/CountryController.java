package com.country.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.country.demo.beans.Country;
import com.country.demo.services.CountryService;

@RestController
//@CrossOrigin
public class CountryController { // REST CONTROLLER CLASS
	
	
	@Autowired
	CountryService countryService;
	

	
	
	@GetMapping("/getcountries")
	public List<Country> getCountries()
	{
		return countryService.getAllCountries();
	}
	
	
	
	
//	@GetMapping("/getcountries/{id}")
	@RequestMapping(value = "getcountries/{id}", method = RequestMethod.GET)
	public ResponseEntity<Country> getCountryId(@PathVariable (value="id") int id) 
	{
		try {
			Country country = countryService.getCountryId(id);
			return new ResponseEntity<Country>(country,HttpStatus.FOUND);
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
//	@GetMapping("/getcountries/{countryname}")
	@RequestMapping(value = "getcountries/countryname", method = RequestMethod.GET)
	public ResponseEntity<Country> getCountryByName(@RequestParam(value="name") String countryName) {
		try {
			Country country = countryService.getCountryByName(countryName);
			return new ResponseEntity<Country>(country,HttpStatus.FOUND);
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country)
	{
		return countryService.addCountry(country);
	}
	
	
	
	
	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable (value="id") int id,@RequestBody Country country)
	{
		try {
		Country existCountry = countryService.getCountryId(id);
		
		
		existCountry.setCountryName(country.getCounrtyName());
		existCountry.setCountryCapital(country.getCountryCapital());
		
		
		Country updated_country = countryService.updateCountry(existCountry);
		return new ResponseEntity<Country>(updated_country,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id)
	{
		return countryService.deleteCountry(id);
	}
	
	
}

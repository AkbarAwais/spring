package com.country.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.country.demo.beans.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer>// first arg->POJO class which performs db,
										// 2nd param which is a primary key of db of type integer
{
	
}

package com.epam.jjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jjp.domain.City;
import com.epam.jjp.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repo;
	
	public void addCity(City city) {
		repo.addCity(city);
	}
	
	public List<City> getCities() {
		return repo.getCities();
	}

	public City getCityByName(String name) {
		return repo.getCityByName(name);
	}

}

package com.epam.jjp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.jjp.domain.City;

@Repository
public class CityRepository {

		private final List<City> cities = new ArrayList<>();
		
		
	{
		City bp = new City();
		bp.setName("Budapest");
		bp.setTimeZoneCorrection(1);
		
		City london = new City();
		london.setName("London");
		london.setTimeZoneCorrection(0);

		cities.add(bp);
		cities.add(london);

	}


	public void addCity(City city) {
		cities.add(city);
		
	}


	public List<City> getCities() {
		return cities;
	}


	public City getCityByName(String name) {
		for(City city: cities) {
			if(city.getName().equals(name)) {
				return city;
			}
		}
		return null;
	}

	
}

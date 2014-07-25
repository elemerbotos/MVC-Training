package com.epam.jjp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirController {
	private static final int CHANGE_FROM_S_TO_MILLIS = 1000;
	private List<Flight> flights;
	private List<Route> route;

	private Date date;

	public List<Flight> getFlightsToCity(City city) {
		List<Flight> result = new ArrayList<>();
		for (Flight flight : flights) {
			if (flight.getDestination().equals(city)) {
				result.add(flight);
			}
		}
		return result;
	}

	public List<Flight> getFlyingPlanes() {
		date = new Date();
		List<Flight> result = new ArrayList<>();
		for (Flight flight : flights) {
			if (flight.getArrival().before(date)
					&& flight.getDeparture().after(date)) {
				result.add(flight);
			}
		}
		return result;
	}

	public List<Flight> getDepartingPlanes(long forTimeInSeconds) {
		date = new Date();
		date.setTime(date.getTime()
				+ (forTimeInSeconds * CHANGE_FROM_S_TO_MILLIS));
		List<Flight> result = new ArrayList<>();
		for (Flight flight : flights) {
			if (flight.getDeparture().before(date)) {
				result.add(flight);
			}
		}
		return result;
	}
	
	public List<Flight> getArrivedPlanes(long forTimeInSeconds) {
		date = new Date();
		date.setTime(date.getTime()
				+ (forTimeInSeconds * CHANGE_FROM_S_TO_MILLIS));
		List<Flight> result = new ArrayList<>();
		for (Flight flight : flights) {
			if (flight.getArrival().after(date)) {
				result.add(flight);
			}
		}
		return result;
	}
	
	public void Controll() {
		
	}
	
}

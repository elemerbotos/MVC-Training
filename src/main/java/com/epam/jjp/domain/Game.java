package com.epam.jjp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game implements Runnable{
	List<Flight> flights = new ArrayList<>();
	
	List<Plane> planes = new ArrayList<>();
	List<Route> routes = new ArrayList<>();
	
	public void addRoute(Route route) {
		System.out.println("add route: " + route);
		routes.add(route);
	}
	
	public void addPlane(Plane plane) {
		System.out.println("add plane: " + plane);
		planes.add(plane);
	}

	@Override
	public void run() {
		while(true) {
			if(routes.size() > 0 && planes.size() > 0) {
				startRoute();
				sleep();
			} else {
				sleep();
				System.out.println("No planes!!!!");
			}
		}		
	}

	private void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void startRoute() {
		Route route = routes.remove(0);
		Plane plane = null;
		Flight flight = new Flight();
		boolean found = false;
		for(int i = 0 ; !found && i < planes.size() ; ++i) {
			plane = planes.get(i);
			if(plane.getFuel() > route.getFuelNecessary()) {
				planes.remove(i);
				found = true;
			}
		}
		if(!found) {
			plane = planes.remove(0);
			tank(plane, route.getFuelNecessary());
		}
		
		flight.setRoute(route);
		flight.setPlane(plane);
		flight.setDeparture(new Date());
		
		flights.add(flight);
	}

	private void tank(Plane plane, long fuelNecessary) {
		while(plane.getFuel()< fuelNecessary) {
			plane.setFuel(plane.getFuel()+100);
			System.out.println("Tanking from " + plane.getFuel() + " to " + fuelNecessary);
			sleep();
		}
		
	}
	
	public List<Flight> getFlights() {
		return flights;
	}
	
}

package com.epam.jjp.domain;

import java.util.Date;

public class Flight {
	private Route route;
	private Plane plane;
	private Date departure;
	private Date arrival;
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Plane getPlane() {
		return plane;
	}
	
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	
	public Date getDeparture() {
		return departure;
	}
	
	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public City getDestination() {
		return route.getTo();
	}
	
}

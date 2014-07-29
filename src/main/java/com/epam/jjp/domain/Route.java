package com.epam.jjp.domain;

import java.util.ArrayList;
import java.util.List;

public class Route {
	private City from;
	private City to;
	private long lenght;
	private long fuelNecessary;
	private String id;
	private List<City> vias = new ArrayList<>();
	
	private static int increment = 0;
	
	public Route() {
		++increment;
		id = "route" + increment;
	}
	
	public void addVia(City city) {
		vias.add(city);
	}
	
	public List<City> getVias() {
		return vias;
	}

	public City getFrom() {
		return from;
	}
	
	public void setFrom(City string) {
		this.from = string;
	}
	
	public City getTo() {
		return to;
	}
	
	public void setTo(City to) {
		this.to = to;
	}
	
	public long getLenght() {
		return lenght;
	}
	
	public void setLenght(long lenght) {
		this.lenght = lenght;
	}
	
	public long getFuelNecessary() {
		return fuelNecessary;
	}
	
	public void setFuelNecessary(long fuelNecessary) {
		this.fuelNecessary = fuelNecessary;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Route [from=" + from + ", to=" + to + ", lenght=" + lenght
				+ ", fuelNecessary=" + fuelNecessary + ", id=" + id + ", vias="
				+ vias + "]";
	}
	
	
	
}

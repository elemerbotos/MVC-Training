package com.epam.jjp.domain;

public class Route {
	private City from;
	private City to;
	private long lenght;
	private long fuelNecessary;
	
	public City getFrom() {
		return from;
	}
	
	public void setFrom(City from) {
		this.from = from;
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
	
	
	
}

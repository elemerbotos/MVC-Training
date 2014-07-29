package com.epam.jjp.controller;

public class PlaneForm {
	private String name;
	private long id;
	private long fuel;
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFuel() {
		return fuel;
	}

	public void setFuel(long fuel) {
		this.fuel = fuel;
	}
	
	
}

package com.epam.jjp.domain;

import java.util.ArrayList;
import java.util.List;

public class Plane {
	private long id;
	private String name;
	private List<String> errorLog;
	private int fuel;
	
	public Plane() {
		errorLog = new ArrayList<>();
	}
	
	public void logError(String msg) {
		errorLog.add(msg);
	}
	
	public void useFuel(int amount) {
		fuel -= amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public List<String> getErrorLog() {
		return errorLog;
	}
	
}

package com.epam.jjp.domain;

public class City {
	private String name;
	private int timeZoneCorrection;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getTimeZone() {
		return timeZoneCorrection;
	}

	public void setTimeZoneCorrection(int timeZoneCorrection) {
		this.timeZoneCorrection = timeZoneCorrection;
	}
	
	@Override
	public String toString() {
		return "Name: " + name;
	}
}

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

	public int getTimeZoneCorrection() {
		return timeZoneCorrection;
	}

	public void setTimeZoneCorrection(int timeZoneCorrection) {
		this.timeZoneCorrection = timeZoneCorrection;
	}
}

package com.epam.jjp.controller;

import java.util.ArrayList;
import java.util.List;

public class RouteForm {
	
	private String from;
	private String to;
	private long length;
	private long fuel;
	private List<String> vias = new ArrayList<>();

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public long getLength() {
		System.out.println("GET LEN: " + length);
		return length;
	}

	public long getFuel() {
		return fuel;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setLength(long length) {
		System.out.println("SET LEN: " + length);
		this.length = length;
	}

	public void setFuel(long fuel) {
		System.out.println("SET FUEL: " + fuel);
		this.fuel = fuel;
	}
	
	public void setVias(String via) {
		vias.add(via);
	}

	public List<String> getVias() {
		return vias;
	}

}

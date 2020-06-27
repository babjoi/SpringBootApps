package com.virusstats.models;

public class LocationStats {
	private String state;
	private String location;
	private int casesPerLocation;
	
	public LocationStats() {}
	public LocationStats(String state, String location, int casesPerLocation) {
		super();
		this.state = state;
		this.location = location;
		this.casesPerLocation = casesPerLocation;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCasesPerLocation() {
		return casesPerLocation;
	}
	public void setCasesPerLocation(int casesPerLocation) {
		this.casesPerLocation = casesPerLocation;
	}
	

}

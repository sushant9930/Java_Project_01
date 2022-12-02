package com.Pojo;

public class Location {
	
	private String location_id, location_city, location_state, location_country;

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getLocation_city() {
		return location_city;
	}

	public void setLocation_city(String location_city) {
		this.location_city = location_city;
	}

	public String getLocation_state() {
		return location_state;
	}

	public void setLocation_state(String location_state) {
		this.location_state = location_state;
	}

	public String getLocation_country() {
		return location_country;
	}

	public void setLocation_country(String location_country) {
		this.location_country = location_country;
	}

	public Location(String location_id, String location_city, String location_state, String location_country) {
		super();
		this.location_id = location_id;
		this.location_city = location_city;
		this.location_state = location_state;
		this.location_country = location_country;
	}
	
	public String toString() 
	{
		return(getLocation_id()+"         "+getLocation_city()+"       "+getLocation_state()+"        "+getLocation_country());
	}

}

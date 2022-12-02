package com.Pojo;

public class Theater {

	private String theater_id,Theater_name,theater_location_id,
					theater_address;
	private Float theater_rating;
	private int theater_screen;
	
	
		

	public int getTheater_screen() {
		return theater_screen;
	}
	public void setTheater_screen(int theater_screen) {
		this.theater_screen = theater_screen;
	}

	public String getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(String theater_id) {
		this.theater_id = theater_id;
	}
	public String getTheater_name() {
		return Theater_name;
	}
	public void setTheater_name(String theater_name) {
		Theater_name = theater_name;
	}
	public String getTheater_location_id() {
		return theater_location_id;
	}
	public void setTheater_location_id(String theater_location_id) {
		this.theater_location_id = theater_location_id;
	}
	public String getTheater_address() {
		return theater_address;
	}
	public void setTheater_address(String theater_address) {
		this.theater_address = theater_address;
	}
	public Float getTheater_rating() {
		return theater_rating;
	}
	public void setTheater_rating(Float theater_rating) {
		this.theater_rating = theater_rating;
	}
	
	public String toString() 
	{
		return(getTheater_id()+"     "+getTheater_name()+"       "+getTheater_address()+"                 "+getTheater_location_id()+"           "+getTheater_address()+"           "+getTheater_rating());
		
	}
	
}

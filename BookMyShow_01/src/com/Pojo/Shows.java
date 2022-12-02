package com.Pojo;

import java.sql.Date;
import java.sql.Time;

public class Shows {
	
	private int slot_id,normal, executive, premium;
	private String  theater_id, movie_id,  screen_id;
	private Time show_start_time, show_last_time;
	private Date show_date;
	
	public Shows(int slot_id, int normal, int executive, int premium,
			Time show_start_time, Time show_last_time, String theater_id, String movie_id, Date show_date,
			String screen_id) {
		super();
		this.slot_id = slot_id;
		this.normal = normal;
		this.executive = executive;
		this.premium = premium;
		this.show_start_time = show_start_time;
		this.show_last_time = show_last_time;
		this.theater_id = theater_id;
		this.movie_id = movie_id;
		this.show_date = show_date;
		this.screen_id = screen_id;
	}
	public int getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(int slot_id) {
		this.slot_id = slot_id;
	}
	public int getNormal() {
		return normal;
	}
	public void setNormal(int normal) {
		this.normal = normal;
	}
	public int getExecutive() {
		return executive;
	}
	public void setExecutive(int executive) {
		this.executive = executive;
	}
	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}
	
	public Time getShow_start_time() {
		return show_start_time;
	}
	public void setShow_start_time(Time show_start_time) {
		this.show_start_time = show_start_time;
	}
	public Time getShow_last_time() {
		return show_last_time;
	}
	public void setShow_last_time(Time show_last_time) {
		this.show_last_time = show_last_time;
	}
	public String getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(String theater_id) {
		this.theater_id = theater_id;
	}
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public Date getShow_date() {
		return show_date;
	}
	public void setShow_date(Date show_date) {
		this.show_date = show_date;
	}
	public String getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(String screen_id) {
		this.screen_id = screen_id;
	}

	
	public  String toString() 
	{
		return(getSlot_id()+"          "+getShow_start_time()+"            "+getShow_last_time()+"                 "+getTheater_id()
					+"             "+getMovie_id()+"            "+getShow_date()+"             "+getScreen_id()+"            "+
					getNormal()+"            "+getExecutive()+"            "+getPremium());
	}
	
	
	

}

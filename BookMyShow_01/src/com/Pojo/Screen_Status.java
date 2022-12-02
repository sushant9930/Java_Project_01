package com.Pojo;

public class Screen_Status {
	
	private int id, chair;
	private String seat_status, seat_type, theater_id, screen_id,row; 
	
	public Screen_Status(int id, int chair, String seat_status, String seat_type, String theater_id, String screen_id,
			String row) {
		super();
		this.id = id;
		this.chair = chair;
		this.seat_status = seat_status;
		this.seat_type = seat_type;
		this.theater_id = theater_id;
		this.screen_id = screen_id;
		this.row = row;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChair() {
		return chair;
	}
	public void setChair(int chair) {
		this.chair = chair;
	}
	public String getSeat_status() {
		return seat_status;
	}
	public void setSeat_status(String seat_status) {
		this.seat_status = seat_status;
	}
	public String getSeat_type() {
		return seat_type;
	}
	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}
	public String getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(String theater_id) {
		this.theater_id = theater_id;
	}
	public String getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(String screen_id) {
		this.screen_id = screen_id;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}

	
	public String toString() 
	{
		return(getId()+"              "+getRow()+"          "+getChair()+"          "+getSeat_status()+"         "+getSeat_type()+"           "+getTheater_id()+"           "+getScreen_id());
	}

}

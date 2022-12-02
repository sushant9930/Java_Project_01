package com.Pojo;

public class Screen {

	private int screen_num;
	private String screen_id,theater_id, movie_id;
	public Screen(int screen_num, String screen_id, String theater_id, String movie_id) {
		super();
		this.screen_num = screen_num;
		this.screen_id = screen_id;
		this.theater_id = theater_id;
		this.movie_id = movie_id;
	}
	public int getScreen_num() {
		return screen_num;
	}
	public void setScreen_num(int screen_num) {
		this.screen_num = screen_num;
	}
	public String getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(String screen_id) {
		this.screen_id = screen_id;
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
	
	public String toString() 
	{
		return(getScreen_id()+"                "+getTheater_id()+"           "+getMovie_id()+"           "+getScreen_num());
	}
}

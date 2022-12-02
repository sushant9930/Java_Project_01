package com.Pojo;

import java.sql.*;

public class Booking {
	
	private int booking_id,  price_per_seat, total_price, no_of_seat, user_id;
	private String mov_name;
	private Date show_date;
	private Date booking_date;
	private Time show_time_start;
	

       public  Booking(int booking_id, int price_per_seat, int total_price, int no_of_seat, int user_id, String mov_name,
			Date show_date, Date booking_date, Time show_time_start) {
		super();
		this.booking_id = booking_id;
		this.price_per_seat = price_per_seat;
		this.total_price = total_price;
		this.no_of_seat = no_of_seat;
		this.user_id = user_id;
		this.mov_name = mov_name;
		this.show_date = show_date;
		this.booking_date = booking_date;
		this.show_time_start = show_time_start;
	}

public int getBooking_id() {
	return booking_id;
}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getPrice_per_seat() {
		return price_per_seat;
	}
	public void setPrice_per_seat(int price_per_seat) {
		this.price_per_seat = price_per_seat;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getNo_of_seat() {
		return no_of_seat;
	}
	public void setNo_of_seat(int no_of_seat) {
		this.no_of_seat = no_of_seat;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMov_name() {
		return mov_name;
	}
	public void setMov_name(String mov_name) {
		this.mov_name = mov_name;
	}
	public Date getShow_date() {
		return show_date;
	}
	public void setShow_date(Date show_date) {
		this.show_date = show_date;
	}
	public Time getShow_time_start() {
		return show_time_start;
	}
	public void setShow_time_start(Time show_time_start) {
		this.show_time_start = show_time_start;
	}
	

	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	public String toStringh() 
	{
		return(getBooking_id()+"        "+getBooking_date()+"        "+getShow_time_start()+"        "+getMov_name()+"        "+getShow_date()+"        "+getUser_id()+"        "+getNo_of_seat()+"        "+getPrice_per_seat()+"        "+getTotal_price());
	}
	
	
	
	
	
	

}

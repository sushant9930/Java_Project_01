package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;

import com.Pojo.*;
import com.utility.DBConnection;


public class Convert_db_list 
{
	public static void user(ArrayList<User> alu) throws ClassNotFoundException, SQLException 
	{
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from users");
		while(rs.next()) 
		{
			int user_id=rs.getInt(1);
			String user_name=rs.getString(4);
			String user_email=rs.getString(6);
			String user_location=rs.getString(7);
			String user_contact=rs.getString(5);
			String user_first_name = rs.getString(2);
			String user_last_name=rs.getString(3);
			String password=rs.getString(8);
			
			User u=new User();
			u.setUser_id(user_id);
			u.setUser_first_name(user_first_name);
			u.setUser_last_name(user_last_name);
			u.setUser_name(user_name);
			u.setUser_email(user_email);
			u.setPassword(password);
			u.setUser_contact(user_contact);
			u.setUser_location(user_location);
					
			alu.add(u);
		}
	/*	
		System.out.println("User _id   \tFull name     \tUser name    \temail id         \tcontact ");
		Iterator<User> itr=alu.iterator();
		while(itr.hasNext()) 
		{
			User u=itr.next();
			System.out.println(u+"\n");
		}*/
	}
		public static void Movies(ArrayList<Movies> alm) throws ClassNotFoundException, SQLException 
		{
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from movies");
			while(rs.next()) 
			{
				
				String mid=rs.getString(1);
				String mname=rs.getString(2);
				String mlang=rs.getString(3);
				String mredate=rs.getString(4);
				float mmr= rs.getFloat(5);
				float dur=rs.getFloat(6);
				
				Movies m=new Movies();
				m.setMovie_id(mid);
				m.setMovie_name(mname);
				m.setRelease_date(mredate);
			    m.setLang(mlang);
			    m.setMovie_rating(mmr);
			    m.setDuration(dur);
				
		
				
				alm.add(m);
			}
			
			
			/*System.out.println("Movie Id   \tMovie name     \tLangauge          \tRating         \tDuration ");
			Iterator<Movies> itr=alm.iterator();
			while(itr.hasNext()) 
			{
				Movies u=itr.next();
				System.out.println(u+"\n");
			}*/
		
	}
		
		public static void theater_01(ArrayList<Theater> alt) throws ClassNotFoundException, SQLException 
		{
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from theater");
			while(rs.next()) 
			{
				
				String tid=rs.getString(1);
				String tname=rs.getString(2);
				String tloc=rs.getString(3);
				String tadd=rs.getString(4);
				Float trate=rs.getFloat(5);
				int thsc=rs.getInt(6);
				
				
				Theater t=new Theater();
				t.setTheater_id(tid);
				t.setTheater_name(tname);
				t.setTheater_location_id(tloc);
				t.setTheater_address(tadd);
				t.setTheater_rating(trate);
				t.setTheater_screen(thsc);
								
				alt.add(t);
			}
			
	/*		
			Iterator<Theater> itr=alt.iterator();
			while(itr.hasNext()) 
			{
				Theater u=itr.next();
				System.out.println(u+"\n");
			}*/
		
	}

		public static void location(ArrayList<Location> all) throws ClassNotFoundException, SQLException 
		{
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Location");
			while(rs.next()) 
			{
				
				String lid=rs.getString(1);
				String lcity=rs.getString(2);
				String lstate=rs.getString(3);
				String lcontry=rs.getString(4);		
				all.add(new Location(lid,lcity,lstate,lcontry));
			}
			
			
		/*	Iterator<Location> itr=all.iterator();
			while(itr.hasNext()) 
			{
				Location u=itr.next();
				System.out.println(u+"\n");
			}*/
		
	}
		
		public static void shows(ArrayList<Shows> all) throws ClassNotFoundException, SQLException 
		{
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Shows");
			while(rs.next()) 
			{
				int sid=rs.getInt(1);
				Time stimest=rs.getTime(2);
				Time stimeend=rs.getTime(3);
				String tid=rs.getString(4);
				String mid=rs.getString(5);		
				Date showdate=rs.getDate(6);
				String scid=rs.getString(7);
				int normal=rs.getInt(8);
				int ex=rs.getInt(9);
				int pre=rs.getInt(10);
				
				all.add(new Shows(sid,normal,ex,pre,stimest,stimeend,tid,mid,showdate,scid));
			}
			
			
	/*		Iterator<Shows> itr=all.iterator();
			while(itr.hasNext()) 
			{
				Shows u=itr.next();
				System.out.println(u+"\n");
			}*/
		
	}
		public static void screen(ArrayList<Screen> all) throws ClassNotFoundException, SQLException 
		{
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Screen");
			while(rs.next()) 
			{
				String scid=rs.getString(1);
				String tid=rs.getString(2);
				int snum=rs.getInt(3);
				String mid=rs.getString(4);
				
				all.add(new Screen(snum, scid,tid,mid));
			}
			
			
			/*Iterator<Screen> itr=all.iterator();
			while(itr.hasNext()) 
			{
				Screen u=itr.next();
				System.out.println(u+"\n");
			}
		*/
	}
		
		public static void screen_status(ArrayList<Screen_Status> all) throws ClassNotFoundException, SQLException 
		{
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Screen_Status");
			while(rs.next()) 
			{
				int ssid=rs.getInt(1);
				String row=rs.getString(2);
				int ch=rs.getInt(3);
				String status=rs.getString(4);
				String stype=rs.getString(5);
				String tid=rs.getString(6);
				String scid=rs.getString(7);
				
				all.add(new Screen_Status(ssid,ch,status, stype, tid,scid, row));
			}
			
			
		/*	Iterator<Screen_Status> itr=all.iterator();
			while(itr.hasNext()) 
			{
				Screen_Status u=itr.next();
				System.out.println(u+"\n");
			}*/
		
	}
		
		public static void booking(ArrayList<Booking> alb) throws ClassNotFoundException, SQLException 
		{
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Booking_01");
			while(rs.next()) 
			{
				int bid=rs.getInt(1);
				Date bdate=rs.getDate(2);
				Time stime=rs.getTime(3);
				String mname=rs.getString(4);
				int userid=rs.getInt(5);
				int price_seat=rs.getInt(6);
				int totalprice=rs.getInt(7);
				int totalseat =rs.getInt(8);
				Date shdate=rs.getDate(9);
				
				Booking b=new Booking(bid, price_seat, totalprice, totalseat, userid, mname, shdate, bdate, stime);
			
				
				
			}
			
			
		/*	Iterator<Booking> itr=alb.iterator();
			while(itr.hasNext()) 
			{
				Booking u=itr.next();
				System.out.println(u+"\n");
			}*/
		
	}
}

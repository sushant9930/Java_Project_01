package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.Dao.Interfaces.Choose_method_interface;
import com.Pojo.Movies;
import com.Pojo.Screen_Status;
import com.utility.DBConnection;

public class Choose_methods implements Choose_method_interface
{

	
	
	/// alll chhose directly methods
	
	public void show_Theater_Selected(String mov, String ulocc) //throws ClassNotFoundException, SQLException 
	{
				
		try(Connection con=DBConnection.getConnection();)
		{
			System.out.println();
			    System.out.println("============================================================================================================");
				System.out.println("\nSelect theater and shows from below list where available selected movie shows......\n");
				System.out.println("=============================================================================================================\n");
				
			    Statement st111=con.createStatement();
				String str111="select s.theater_id, t.theater_name,s.slot_id, s.SHOW_DATE, s.show_time_start, s.normal, s.executive, s.premium  from  shows s  join theater t where s.theater_id=t.theater_id and t.theater_id=(select t.theater_id from theater t join shows s where t.theater_id=s.theater_id and t.location_id=(select location_id from location where location_city='"+ulocc+"') and s.movie_id='"+mov+"')";
				ResultSet rs111=st111.executeQuery(str111);	
			    while(rs111.next()) {
			    	
			    	String s1=rs111.getString("theater_id");
			    	String s2=rs111.getString("theater_name");
			    	int s3=rs111.getInt("slot_id");
			    	Time s4=rs111.getTime("show_time_start");
			    	Date s5=rs111.getDate("show_date");
			    	int s6=rs111.getInt("normal");
			    	int s7=rs111.getInt("executive");
			    	int s8=rs111.getInt("premium");
			    	
			    	System.out.println("Theater Id  :  "+s1+"    "+"Theater name  :  "+s2+"\n"
			    					  +"Show Id  :  "+s3+"    "+"Show Time  :  "+s4+"    "+"Show Date  :  "+s5+"    "+"\n"+
			    					   "Normal  :  "+s6+"    "+"Executive  :  "+s7+"    "+"Premium  :  "+s8);
	    }
	    
				    st111.close();
				    rs111.close(); 		    				    
	   }
		catch(Exception e) 
		{
	    	System.out.println("Error");
	    }
	}
	
	public String get_User_Location(String userid,String ulocc) throws SQLException, ClassNotFoundException 
	{
		Connection con=DBConnection.getConnection();
	  	Statement st0112=con.createStatement();
	  	String str000="select user_location from users where user_name='"+userid+"'";
		ResultSet rs0112=st0112.executeQuery(str000);
		System.out.println();
		while(rs0112.next()) 
		{
			String locc=rs0112.getString(1);
			return ulocc=locc;
		}
		
		return ulocc;
		
	}
	
	public int show_Selected_Move(String mov, int flag01 ,String temp, String userid, String ulocc, ArrayList<Movies> al) throws ClassNotFoundException, SQLException 
	{		
			System.out.println("=============================================================================================================");	
			Convert_db_list.Movies(al);
			Iterator<Movies> itr=al.iterator();
			while(itr.hasNext()) 
			{
				Movies m=itr.next();
					if(m.getMovie_id().equalsIgnoreCase(mov) ) 
					{
						System.out.println("Movie Id           :"+m.getMovie_id()+"\n"
										  +"Movie name         :"+m.getMovie_name()+"\n"
										  +"Movie langauge     :"+m.getLang()+"\n"
										  +"Movie release date :"+m.getRelease_date()+"\n"
										  +"Movie duration     :"+m.getDuration());
						return flag01=1;
					}
			}
			System.out.println("=============================================================================================================");
		
		return flag01;
	}
	public String mov_Name(String mov) throws ClassNotFoundException, SQLException 
	{	
		
		Connection con=DBConnection.getConnection();
	  	Statement st01=con.createStatement();
		ResultSet rs1000=st01.executeQuery("select * from movies");
		String temp="";
		while(rs1000.next()) 
		{			
					if(mov.equalsIgnoreCase(rs1000.getString(1))) 
					{
						temp=rs1000.getString(2);
						return temp;
					}
		}
		
		return temp;	
	}
	
	public int check_Availability(String tid,int flag4 ) throws SQLException, ClassNotFoundException 
	{
		
		Connection con=DBConnection.getConnection();
		System.out.println("=============================================================================================================");
		System.out.println("\nSEAT AVAILABILITY......\n");
		System.out.println("=============================================================================================================\n");
			
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select count(id) as 'booked_seat' from screen_status where seat_status='Booked' and theater_id='"+tid+"'");
		while(rs.next()) 
		{
			int bookedseat=rs.getInt(1);
			if(bookedseat>=100) 
			{
				return flag4=1;
			}
			else 
			{
				
				return flag4=bookedseat;
			}
		}
		rs.close();
		
		
		return flag4;
	}
	
	public void show_Hall(String tid, int sid, String userid, ArrayList<Screen_Status> al, int flag4) throws SQLException, ClassNotFoundException 
	{
		Connection con=DBConnection.getConnection();
		
		System.out.println();
			System.out.println("-------------------------Seating arrangement------------------\n");
			Pattern p=new Pattern();
			p.hall();
			System.out.println();	
			System.out.println("=============================================================================================================");
			System.out.println("\nSEATING ARRANGEMENT......\n");
			System.out.println("=============================================================================================================\n");
			Statement st1=con.createStatement();
			ResultSet rs10=st1.executeQuery("select row_01, chair, seat_status, seat_type from screen_status where theater_id='"+tid+"'and screen_id=(select screen_id from shows where slot_id="+sid+" and theater_id='"+tid+"')");	
			
			System.out.println("Row  \tchair  \tSeat available \tSeat type");
			while(rs10.next() )
			{		  				
					System.out.println(rs10.getString(1)+"       "+rs10.getInt(2)+"            "+rs10.getString(3)+"        "+rs10.getString(4));		  	
					Convert_db_list.screen_status(al);		
			}		
		
			
			rs10.close();
			st1.close();
	}
	
	

	public void seat_Selection_Proc(String ch, int cnum, String tid, int sid, String userid, int sn) throws SQLException, ClassNotFoundException 
	{
		Connection con=DBConnection.getConnection();
			String str12="update screen_status set seat_status='Booked' where row_01='"+ch+"' and chair='"+cnum+"' and theater_id='"+tid+"' and screen_id=(select screen_id from shows where slot_id="+sid+" and theater_id='"+tid+"')";
			Statement st12=con.createStatement();
			st12.executeUpdate(str12);
			String str122="update screen_status set   booking_id=(SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = \"bookmyseat\" AND TABLE_NAME = \"booking_01\") , user_id=(select user_id from users where user_name='"+userid+"') where theater_id='"+tid+"' and screen_id=(select screen_id from shows where slot_id="+sn+") and row_01='"+ch+"' and chair="+cnum+"";
			Statement st122=con.createStatement();
			st122.executeUpdate(str122);
			
			String str13="insert into booking_seat(chair_id,row_id, user_name, slot_id) values(?,?,?,?)";
			PreparedStatement per011=con.prepareStatement(str13);
			
		per011.setInt(1,cnum);
		per011.setString(2, ch);
		per011.setString(3, userid);
		per011.setInt(4, sid);
		
		per011.addBatch();
		int aa[]=per011.executeBatch();
	}
	
	public void booking_Conf(String type,int sid,String userid,int sn, String tid, String mov) throws SQLException, ClassNotFoundException 
	{
		Connection con=DBConnection.getConnection();
		String str02="call Booking(?,?,?,?,?,?)";
			PreparedStatement pr02=con.prepareStatement(str02);
			pr02.setString(1, type);
			pr02.setInt(2, sid);
			pr02.setString(3, tid);
			pr02.setString(4, mov);
			pr02.setString(5, userid);
			pr02.setInt(6, sn);
			pr02.addBatch();
			int[] a=pr02.executeBatch();
			
			String str10="update booking_seat set booking_id = (select booking_id from booking_01 where booking_id=last_insert_id()) order by id desc limit "+sn+"";
			Statement st1006=con.createStatement();
			st1006.executeUpdate(str10);
			System.out.println("=============================================================================================================\n");
			String str="select * from booking_01 where booking_id=last_insert_id();";
			Statement st1005=con.createStatement();
			ResultSet rs1005=st1005.executeQuery(str);
			while(rs1005.next()) 
			{
				
				System.out.println("Booking Id no.   :    "+rs1005.getInt(1)+"\n"+
								   "Booking Date     :    "+rs1005.getDate(2)+"\n"+
								   "Show Time        :    "+rs1005.getTime(3)+"\n"+
								   "Movie Name       :    "+rs1005.getString(4)+"\n"+
								   "User Id          :    "+rs1005.getInt(5)+"\n"+
								   "Price per seat   :    "+rs1005.getInt(6)+"\n"+
								   "Total price      :    "+rs1005.getInt(7)+"(Including 18% GST)\n"+
								   "Total seats      :    "+rs1005.getInt(8)+"\n"+
								   "Show Date        :    "+rs1005.getDate(9));
			}
			System.out.println("\n");
			String str201="select * from bookmyseat.booking_seat where booking_id=(select booking_id from booking_01 where booking_id=last_insert_id())";
			Statement st1008=con.createStatement();
			ResultSet rs1008=st1008.executeQuery(str201);
			
			System.out.println("Chair\tRow  \tBooking_id");
			while(rs1008.next()) 
			{			
				System.out.println(rs1008.getInt(2)+"        "+rs1008.getString(3)+"        "+rs1008.getInt(6));
				
			
			}
			st1005.close();
			rs1005.close();
			st1006.close();
			System.out.println("=============================================================================================================\n");
			System.out.println("                                         BOOKING DONE");
			System.out.println("=============================================================================================================\n");
			con.close();
			
	}
		
	public int login(int flag, String userid, String pass, String ulocc, char ch_01) throws ClassNotFoundException, SQLException 
	{
		Connection con=DBConnection.getConnection();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("=============================================================================================================");
		System.out.println("                       User Login");
		System.out.println("=============================================================================================================");
		System.out.println("Enter your username : ");
		userid=sc.next();
		System.out.println();
		System.out.println("Enter your password :");
		pass=sc.next();
		sc.nextLine();
		System.out.println("=============================================================================================================");
		try{
		SignIn si=new SignIn();
		flag = si.userLogin(userid, pass, ulocc, flag);
		}
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
	  		System.out.println(e.getMessage());
		}catch(SQLException e) 
		{
			e.printStackTrace();
	  		System.out.println(e.getMessage());
		}
		if(flag==1) {						
			System.out.println("Log in successfully.....");
		}
		
		SignIn s1=new SignIn();
		ulocc=s1.forLocation(userid, pass, ulocc);
		con.close();
		return flag;
	}
	
	public String callMainMethod(String point) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("=============================================================================================================");
			System.out.println("go to main menu");
			System.out.println("Enter menu");
  		point=sc.next();
  		System.out.println("=============================================================================================================");
  		return point;
	}
	
	public String callLog(String log) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("=============================================================================================================");
		System.out.println("go to login option");
		System.out.println("Enter log");
  		log=sc.next();
  		System.out.println("=============================================================================================================");
  		return log;
	}




}

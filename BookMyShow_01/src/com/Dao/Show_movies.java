package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Dao.Interfaces.Show_Movies_Interface;
import com.utility.DBConnection;

public class Show_movies implements Show_Movies_Interface
{

	
	public void show(String ulocc) throws ClassNotFoundException, SQLException 
	{
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select m.* from movies m join shows s join theater t where m.movie_id=s.movie_id and s.theater_id=t.theater_id and t.location_id=(select location_id from location where location_city='"+ulocc+"');");
		
		while(rs.next()) 
		{
			System.out.println("Movie id : "+rs.getString(1)+"\n"
							  +"Movie name : "+rs.getString(2)+"    \n"
							  +"Langauge : "+rs.getString(3)+"    \n"
							  +"Release Date : "+rs.getDate(4)+"    \n"
							  +"Rating : "+rs.getFloat(5)+"    \n"
							  +"Duration : "+rs.getFloat(6)+"\n");
		}
		st.close();
		rs.close();
		con.close();
	}
	
}

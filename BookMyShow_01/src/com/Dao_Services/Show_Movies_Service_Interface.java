package com.Dao_Services;

import java.sql.SQLException;

import com.Dao.Show_movies;

public interface Show_Movies_Service_Interface 
{
	void show(String ulocc) throws ClassNotFoundException, SQLException; 

}

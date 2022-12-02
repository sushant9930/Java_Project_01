package com.Dao_Services_Implements;

import java.sql.SQLException;

import com.Dao.Show_movies;
import com.Dao_Services.Show_Movies_Service_Interface;

public class Show_Movies_Service implements Show_Movies_Service_Interface
{
	Show_movies dao3;
	
	
	
	public Show_movies getDao3() {
		return dao3;
	}



	public void setDao3(Show_movies dao3) {
		this.dao3 = dao3;
	}



	public Show_Movies_Service(Show_movies dao3) {
		super();
		this.dao3 = dao3;
	}



	@Override
	public void show(String ulocc) throws ClassNotFoundException, SQLException {
		
		dao3=new Show_movies();
		dao3.show(ulocc);
	}

}

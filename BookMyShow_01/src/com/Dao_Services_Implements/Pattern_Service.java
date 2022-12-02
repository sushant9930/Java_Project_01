package com.Dao_Services_Implements;

import java.sql.SQLException;

import com.Dao.Pattern;
import com.Dao_Services.Pattern_Service_Interface;

public class Pattern_Service implements Pattern_Service_Interface
{
	Pattern dao2;

	
	
	public Pattern getDao2() {
		return dao2;
	}



	public void setDao2(Pattern dao2) {
		this.dao2 = dao2;
	}



	public Pattern_Service(Pattern dao2) {
		super();
		this.dao2 = dao2;
	}



	@Override
	public void hall() throws ClassNotFoundException, SQLException {
		dao2=new Pattern();
		dao2.hall();
		
	}
	
	

}

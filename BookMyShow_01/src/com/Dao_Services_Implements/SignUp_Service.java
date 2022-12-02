package com.Dao_Services_Implements;

import java.sql.SQLException;

import com.Dao.SignUp;
import com.Dao_Services.SignUp_Service_Interface;

public class SignUp_Service implements SignUp_Service_Interface
{
	
	SignUp dao5;

	
	
	public SignUp getDao5() {
		return dao5;
	}



	public void setDao5(SignUp dao5) {
		this.dao5 = dao5;
	}



	public SignUp_Service(SignUp dao5) {
		super();
		this.dao5 = dao5;
	}



	@Override
	public void signup() throws SQLException, ClassNotFoundException {
		
		dao5=new SignUp();
		dao5.signup();
		
	}
	
	
}

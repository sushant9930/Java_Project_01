package com.Dao_Services_Implements;

import java.sql.SQLException;

import com.Dao.SignIn;
import com.Dao_Services.SignIn_Service_Interface;

public class SignIn_Service implements SignIn_Service_Interface
{
	SignIn dao4;
	
	public SignIn_Service(SignIn dao4) {
		super();
		this.dao4 = dao4;
	}

	public SignIn getDao4() {
		return dao4;
	}

	public void setDao4(SignIn dao4) {
		this.dao4 = dao4;
	}

	@Override
	public int userLogin(String uid, String pas, String ulocc, int flag) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao4.userLogin(uid, pas, ulocc, flag);
	}

	@Override
	public String forLocation(String userid, String pass, String ulocc) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao4.forLocation(userid, pass, ulocc);
	}
	
	
		
}

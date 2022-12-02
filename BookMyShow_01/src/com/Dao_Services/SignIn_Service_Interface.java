package com.Dao_Services;

import java.sql.SQLException;

import com.Dao.SignIn;

public interface SignIn_Service_Interface
{
	int userLogin(String uid, String pas, String ulocc, int flag) throws ClassNotFoundException, SQLException;
	String forLocation(String userid, String pass, String ulocc) throws ClassNotFoundException, SQLException;
	
}

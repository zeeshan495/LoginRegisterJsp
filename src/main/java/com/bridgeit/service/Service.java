package com.bridgeit.service;

import java.sql.SQLException;
import com.bridgeit.dao.UserDao;
import com.bridgeit.model.UserInfo;

public class Service {
	
	public int save(UserInfo info) throws SQLException
	{
		UserDao user=new UserDao();
		int status=user.saveUser(info);
		return status;
	}
	
	public boolean checkRegisterUser(String mail) throws SQLException
	{
		UserDao user=new UserDao();
		boolean status=user.checkRegisterUser(mail);
		return status;
	}
	
	public boolean checkLoginUser(String mail,String pwd)throws SQLException
	{
		UserDao user=new UserDao();
		boolean status=user.checkLoginUser(mail,pwd);
		return status;
	}

}

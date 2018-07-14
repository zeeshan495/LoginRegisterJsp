package com.bridgeit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bridgeit.model.UserInfo;

public class UserDao {
	
	 public static Connection getConnection()
		{ 
		 String Driver_db="com.mysql.jdbc.Driver";
		 String name="root";
		 String pwd="root";
		 String URL="jdbc:mysql://localhost:3306/Registration";
		 Connection con=null;
			try {
				Class.forName(Driver_db);
				con=DriverManager.getConnection(URL,name,pwd);
							
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return con;	
		}	
	 
	 
	public  int saveUser(UserInfo info) throws SQLException
	{
		int status=0;
		PreparedStatement ps=getConnection().prepareStatement("insert into user values(?,?,?,?)");
		ps.setString(1, info.getUserName());
		ps.setString(2, info.getFullName());
		ps.setString(3, info.getMailId());
		ps.setString(4, info.getPassword());
		status=ps.executeUpdate();
		getConnection().close();
		return status;
	}
	
	public static List<UserInfo> getAllUsers()
	{
		List<UserInfo> list=new ArrayList<UserInfo>();
		try {
			PreparedStatement ps=getConnection().prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				UserInfo info=new UserInfo();
				info.setUserName(rs.getString(1));
				info.setFullName(rs.getString(2));
				info.setMailId(rs.getString(3));
				info.setPassword(rs.getString(4));
				list.add(info);
			}
		getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean checkRegisterUser(String mail) throws SQLException
	{
		List<UserInfo> list=new ArrayList<UserInfo>();
		
			PreparedStatement ps=getConnection().prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				UserInfo info=new UserInfo();
				info.setMailId(rs.getString("mailId"));
				list.add(info);
			}
			for(UserInfo data:list)
			{
				if(data.getMailId().equals(mail))
				{
					return true;
				}
			}
		getConnection().close();
		return false;
	}
	
	public boolean checkLoginUser(String mail,String pwd) throws SQLException
	{
		List<UserInfo> list=new ArrayList<UserInfo>();
		
			PreparedStatement ps=getConnection().prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				UserInfo info=new UserInfo();
				info.setMailId(rs.getString("mailId"));
				info.setPassword(rs.getString("password"));
				list.add(info);
			}
			for(UserInfo data:list)
			{
				if(data.getMailId().equals(mail) && data.getPassword().equals(pwd))
				{
					return true;
				}
			}
		getConnection().close();
		return false;
	}

}

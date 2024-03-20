package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;

public class UserDao {

	private Connection conn;
	
	public UserDao(Connection conn)
	{
		this.conn=conn;
	}
	
	
	public boolean registerUser(User user)
	{
		boolean f=false;
		try {
			String sql="insert into users(uname, upwd, uemail, umobile) values(?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,user.getUname());
			ps.setString(2,user.getUpwd());
			ps.setString(3,user.getUemail());
			ps.setString(4,user.getUmobile());
			int i=ps.executeUpdate();
			if (i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	
	public User LoginUser(String email,String pwd)
	{
	
		 User user = null;
		try {
			
		String sql="select * from users where uemail=? and upwd=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, pwd);
		ResultSet rs=ps.executeQuery();
		if (rs.next()) {
            
            user = new User();
            user.setUname(rs.getString("uname"));     
     
        }
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> AllUser()
	{
		List<User>list=new ArrayList<User>();
		User user=null;
		
		try {
			String sql="select * from users";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				user=new User();
				user.setId(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setUemail(rs.getString(4));
				user.setUmobile(rs.getString(5));
				list.add(user);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public User getUserById(int id)
{
	User s=null;
	try {
		String sql="select * from Users where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			s=new User();
			s.setId(rs.getInt(1));
			s.setUname(rs.getString(2));
			s.setUemail(rs.getString(4));
			s.setUmobile(rs.getString(5));
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
      return s;
}
	
	
	public boolean UpdateUser(User user)
	{
		boolean f=false;
		try {
			String sql="update users set uname = ?, uemail = ?, umobile = ? where id = ?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,user.getUname());
			ps.setString(2, user.getUemail());
			ps.setString(3, user.getUmobile());
			ps.setInt(4, user.getId());
			int i=ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteStudent(int id)
	{
		boolean f=false;
		try {
			String sql="delete from users where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			
			if (i==1) 
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	
}

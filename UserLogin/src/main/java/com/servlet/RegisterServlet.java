package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.UserDao;
import com.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname=req.getParameter("name");
		String uemail=req.getParameter("email");
		String upwd=req.getParameter("pass");
		String umobile=req.getParameter("contact");
		
		User user=new User(uname, uemail, upwd, umobile);
		UserDao dao=new UserDao(DBConnect.getConn());
	    
		boolean f=dao.registerUser(user);
	    RequestDispatcher rd=req.getRequestDispatcher("registration.jsp");;
	    
	    if (f) {
			req.setAttribute("status", "success");
			
			
		}else {
			req.setAttribute("status", "failed");	
			
		}
		rd.forward(req, resp);
	}
	
	
	

}

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
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uemail=req.getParameter("username");
		String upwd=req.getParameter("password");
		
		UserDao dao=new UserDao(DBConnect.getConn());
		User user=dao.LoginUser(uemail, upwd);
		HttpSession session=req.getSession();
		RequestDispatcher rd;
         if (user != null) {
        	 session.setAttribute("loginuser",user.getUname());
			resp.sendRedirect("index.jsp");
		} else {
			req.setAttribute("status", "failed");
			rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
		
	}
	
	

}

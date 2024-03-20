package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.UserDao;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		UserDao dao=new UserDao(DBConnect.getConn());
		boolean f=dao.deleteStudent(id);

		HttpSession session=req.getSession();
		
		if (f) {
			session.setAttribute("succMsg","student Delete submit sucessfully...");
			resp.sendRedirect("userlist.jsp");
			
		}else {
			session.setAttribute("errorMsg","student Delete not submitted");
			resp.sendRedirect("userlist.jsp");
			
		}
	}
	
	

}

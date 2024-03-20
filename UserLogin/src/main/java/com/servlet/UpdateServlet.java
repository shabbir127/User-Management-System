package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.UserDao;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     String uname=req.getParameter("name");
     String uemail=req.getParameter("email");
     String ucontact=req.getParameter("mobile");
     int id=Integer.parseInt(req.getParameter("id"));
     
     User user=new User(id, uname, uemail, ucontact);
     UserDao dao=new UserDao(DBConnect.getConn());
     boolean f=dao.UpdateUser(user);

		HttpSession session=req.getSession();
		
	
		if (f) {
			session.setAttribute("succMsg","student Detail submit sucessfully...");
			resp.sendRedirect("userlist.jsp");
			
		}else {
			session.setAttribute("errorMsg","student Detail not submitted");
			resp.sendRedirect("editlist.jsp");
			
		}
    		 
    		 
		
	}
	
	

}

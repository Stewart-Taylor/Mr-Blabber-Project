package uk.ac.dundee.computing.stewarttaylor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


public class Logout extends HttpServlet
 {


		public void doGet(HttpServletRequest req, HttpServletResponse res)   throws ServletException, java.io.IOException
		 {
				
				HttpSession session = req.getSession(true);	 
			    session.invalidate();
							
				res.sendRedirect("/stewarttaylor/");
		 }
	   
   
}
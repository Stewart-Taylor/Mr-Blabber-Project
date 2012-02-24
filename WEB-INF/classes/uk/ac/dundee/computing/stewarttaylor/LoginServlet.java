package uk.ac.dundee.computing.stewarttaylor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


import java.math.*;
import java.security.*;

public class LoginServlet extends HttpServlet 
{


		public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, java.io.IOException
		{
				
			  res.sendRedirect("/stewarttaylor/login.jsp");
			
		}
	   
	   
	   
	   
	   public void doPost(HttpServletRequest req, HttpServletResponse res) throws java.io.IOException, ServletException
		{
  
				try
				{	    
					
					 //get login information 
					 UserBean user = new UserBean();
					 user.setUserName(req.getParameter("un"));
					 user.setPassword(encryptPassword(req.getParameter("pw")));

					 user = UserDAO.login(user);
								
					 if (user.isValid())
					 {
						   
						  HttpSession session = req.getSession(true);	    
						  session.setAttribute("userBean",user); 
						  
						  res.sendRedirect("/stewarttaylor/newsfeed"); //logged-in page    
					 }	
					 else 
					 {
						  res.sendRedirect("/stewarttaylor/login.jsp?attempt=1"); //error page . Invalid login 
					  }
				} 	
				catch (Throwable theException) 	    
				{
					 System.out.println(theException); 
				}
		}
		
		
		
		public String encryptPassword(String s)
		{
		
			try
			{
			   MessageDigest m=MessageDigest.getInstance("MD5");
			   m.update(s.getBytes(),0,s.length());
			  
			   return  (new BigInteger(1,m.digest()).toString(16));
			}
			catch(Exception e)
			{
				//Wont fail Required for algorithm not found exception
				return s;
			}
		}
   
}
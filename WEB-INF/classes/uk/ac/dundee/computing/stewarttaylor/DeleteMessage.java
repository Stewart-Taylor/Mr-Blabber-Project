package uk.ac.dundee.computing.stewarttaylor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import java.text.*;
import java.util.*;
import java.sql.*;


public class DeleteMessage extends HttpServlet
 {


		public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, java.io.IOException
		{

					    HttpSession session = req.getSession(true);
					   
					   if(null == session.getAttribute("userBean"))
					   {  
							res.sendRedirect("/stewarttaylor/index.jsp");
					   }
					   
					   
					 String postNumber = req.getRequestURI();
 
					 // Extract part after unfollow/
					  if( postNumber.length() > 29)
					  {
							postNumber =  postNumber.substring(29);
							
							UserBean userBean = (UserBean)session.getAttribute("userBean");
							
							try
							{
									int id = userBean.getUser_id();
									int postNumb =  Integer.parseInt(postNumber);
									
									deleteMsg(postNumb ,id);
									
							}
							catch(Exception e)
							{
								//res.sendRedirect("/stewarttaylor/newsfeed/error");
							}
					}
					   
			 //Send Back to the profile Page
			 res.sendRedirect("/stewarttaylor/newsfeed/" );
		 }
					   


	   private void deleteMsg(int id ,int userID)
	   {
				String query = "DELETE FROM message WHERE message_id = " + id + " AND user_id = " + userID  ;

				Connection currentCon = null;
				ResultSet rs = null;  
				Statement stmt = null; 
		 
			 try 
			 {
				 //connect to DB 
				 currentCon = ConnectionManager.getConnection();
				 stmt=currentCon.createStatement();
				 stmt.executeUpdate(query);	        
			} 
		  catch (Exception ex) 
		  {
				System.out.println("NO Delete  MADE! :  " + ex);
		  } 

		  
		 finally 
		  {
			 if (rs != null)	{
				try {
				   rs.close();
				} catch (Exception e) {}
				   rs = null;
				}
		
			 if (stmt != null) {
				try {
				   stmt.close();
				} catch (Exception e) {}
				   stmt = null;
				}
			 if (currentCon != null) {
				try {
				   currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			 }
		  }
	   
	   
	   
	}
	
	
  
}
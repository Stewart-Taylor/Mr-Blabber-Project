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


public class PostMessage extends HttpServlet 
{


      static Connection currentCon = null;
      static ResultSet rs = null;  
	  PreparedStatement stmt = null; 

public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, java.io.IOException
{

try
{

		String msg = req.getParameter("msg");
		msg = msg.trim();
		msg = msg.replaceAll("[\n\r]", " ");
	   
	   int userID =  getUserID(req);
	   
	   if( (userID != -1) && (msgValid(msg)))
	   {
				postMsg(msg, userID);
	   }
  
          res.sendRedirect("/stewarttaylor/newsfeed"); 
		  
		  }
		  catch(Exception e)
		  {
		  
		  }
		   res.sendRedirect("/stewarttaylor/newsfeed"); 
} 
		
		
   
	
	
		private int getUserID(HttpServletRequest req)
		{
					HttpSession session = req.getSession(true);
						   
					 if(null == session.getAttribute("userBean"))
					{  
						return -1;
					}

					
					UserBean userBean = (UserBean)session.getAttribute("userBean");
	  
				  try
				  {
						int id = userBean.getUser_id();
						return id;
					}
					catch(Exception e)
					{
					return -1;
					}
		}
	
	
	
	
	
	
		private void postMsg(String msg , int id)
		{

		 msg = msg.replaceAll("<", "");
		 msg = msg.replaceAll(">", "");
		
				String query = "  INSERT INTO message (message_text, user_id )VALUES (?,?) ";

				 try 
				{
				

			currentCon = ConnectionManager.getConnection();

			currentCon.setAutoCommit(false);
			stmt =  currentCon.prepareStatement(query);

			stmt.setString(1,msg);
			stmt.setInt(2,id);	
	
			
			stmt.executeUpdate();	
			currentCon.commit();


				
				 
				} 
				 catch (Exception ex) 
			   {
					System.out.println("NO POST MADE ERROR! :  " + ex);
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
	
	
		private boolean msgValid(String msg)
		{
				if(msg.length() < 2)
				{
						return false;
				}
				else if ( msg.length() >140)
				{
						return false;
				}
				
			return true;
		}
	

}
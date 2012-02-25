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


public class UnFollowServlet extends HttpServlet
{

    static Connection currentCon = null;
    static ResultSet rs = null;  
	Statement stmt = null; 

	public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, java.io.IOException
	{

		HttpSession session = req.getSession(true);			   
		if(null == session.getAttribute("userBean"))
		{  
			res.sendRedirect("/stewarttaylor/index.jsp");
		}
					   
					   
		String profileName = req.getRequestURI();
 
		// Extract part after unfollow/
		if( profileName.length() > 24)
		{
			profileName =  profileName.substring(24);
							   
			
			//Extract ID
			UserBean userBean = (UserBean)session.getAttribute("userBean");
			try
			{
				int id = userBean.getUser_id();
				int fID = getID(profileName);
											
				if(( fID != -1) &&  (fID != id) )
				{
					unFollow( fID, id ,res);	
				}
			}
			catch(Exception e)
			{
				
			}
		}
					   
		//Send Back to the profile Page
		res.sendRedirect("/stewarttaylor/profile/" + profileName);
	}
					   


	private int getID(String name)
	{
		int id= -1;
		   
		String searchQuery =   "select * from user where username='" + name + "'" ;
						  
		try 
		{
			//connect to DB 
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);	        
			boolean more = rs.next();
				   
			
			if (!more) 
			{
				id = -1;
			} 
			else if (more) 
			{
				id =  rs.getInt("user_id"); // Fetch ID
			}
		} 
		catch (Exception ex) 
		{
			System.out.println("Log In failed: An Exception has occurred! " + ex);
		} 
				
		//some exception handling
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
		   
		return id;  
	}
   
   
	   private void unFollow(int id_Followed , int id_follower , HttpServletResponse res)
	   {
			String query = "DELETE FROM follow WHERE user_id = " + id_Followed + " and followed_id = " + id_follower ;

			Connection currentCon2 = null;
			ResultSet rs2 = null;  
			Statement stmt2 = null; 
		 
			try 
			{
				//connect to DB 
				currentCon2 = ConnectionManager.getConnection();
				stmt2=currentCon2.createStatement();
				stmt2.executeUpdate(query);	        
			} 
		    catch (Exception ex) 
			{
				System.out.println("NO UNFOLLOW MADE! :  " + ex);
			} 

		 finally 
		  {
			 if (rs2 != null)	{
				try {
				   rs2.close();
				} catch (Exception e) {}
				   rs2 = null;
				}
		
			 if (stmt2 != null) {
				try {
				   stmt2.close();
				} catch (Exception e) {}
				   stmt2 = null;
				}
			 if (currentCon2 != null) {
				try {
				   currentCon2.close();
				} catch (Exception e) {
				}
				currentCon2 = null;
			 }
		  }

	}

}
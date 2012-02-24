package uk.ac.dundee.computing.stewarttaylor;

import java.text.*;
import java.util.*;
import java.sql.*;

   public class UserDAO 	
   {
     
	 static Connection currentCon = null;
      static ResultSet rs = null;  
	
	
	
      public static UserBean login(UserBean bean) 
	  {
	
         //Statement stmt = null;

		PreparedStatement stmt = null;		 
	
         String username = bean.getUsername();    
         String password = bean.getPassword();   
	    
         String searchQuery = "select * from user where username = ? AND password = ? ";
	    
		  try 
		  {
	
			 //connect to DB 
			 currentCon = ConnectionManager.getConnection();
			 //stmt=currentCon.createStatement();
			 //rs = stmt.executeQuery(searchQuery);	 

			currentCon.setAutoCommit(false);
			 stmt =  currentCon.prepareStatement(searchQuery);

			stmt.setString(1,username);
			stmt.setString(2,password);	
	
			
			rs = stmt.executeQuery();	
			currentCon.commit();
			 
			 boolean more = rs.next();
			   
			 // if user does not exist set the isValid variable to false
			 if (!more) 
			 {
				bean.setValid(false);
			 } 
				
			 //if user exists set the isValid variable to true
			 else if (more) 
			 {
				
				int id = rs.getInt("user_id");
				
		
			
				bean.setUser_id(id);
				bean.setValid(true);
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
		
			 if (currentCon != null) 
			 {
				try {
				   currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			 }
		  }

		return bean;
	
      }	
   }
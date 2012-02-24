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


public class FollowServlet extends HttpServlet
 {

      static Connection currentCon = null;
      static ResultSet rs = null;  

	  Statement stmt = null; 

public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, java.io.IOException
 {
					HttpSession session = req.getSession(true);  
					 if(null == session.getAttribute("userBean"))
					 {  
						res.sendRedirect("/stewarttaylor/index.jsp");
					 }
					   
					String profileName = req.getRequestURI();
 
					  // Cut off afeter FOLLOW/sdsd
					  if( profileName.length() > 22)
					  {
							profileName =  profileName.substring(22);
					   
					   
				//Extract ID
			  	UserBean userBean = (UserBean)session.getAttribute("userBean");
				  try
				  {
								int id = userBean.getUser_id();
								int fID = getID(profileName);
									
									if( ( fID != -1) && ( fID != id))
									{
										addFollow( fID, id );
										res.sendRedirect("/stewarttaylor/profile/" + profileName);										
									}
					}
					catch(Exception e)
					{
					
					}
					}
	   
		 res.sendRedirect("/stewarttaylor/newsfeed");
}
					   

		
		
   
   
   private int getID(String name)
   {
   
		int id= -1;
   
   
            String searchQuery =
               "select * from user where username='" + name + "'" ;
                  



      try 
      {
         //connect to DB 
         currentCon = ConnectionManager.getConnection();
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);	        
         boolean more = rs.next();
	       
         // if user does not exist set the isValid variable to false
         if (!more) 
         {
            System.out.println("User does not exist");
             id = -1;
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) 
         {
             id =  rs.getInt("user_id");
            
	     	
           
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
   
   
   
   
   
   
   
		   private void addFollow(int id_ToFollow , int id_follower)
		   {

					String query = "  INSERT INTO follow (user_id, followed_id )VALUES ('" + id_ToFollow + "',' " + id_follower + " ') ";

			  try 
			  {
				
				 currentCon = ConnectionManager.getConnection();
				 stmt=currentCon.createStatement();
			   
				stmt.executeUpdate(query);	        
				 
			  } 

			  catch (Exception ex) 
			  {
				 System.out.println("NO FOLLOW MADE! :  " + ex);
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
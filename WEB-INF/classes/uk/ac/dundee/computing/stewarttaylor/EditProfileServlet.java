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
import java.math.*;
import java.security.*;

public class EditProfileServlet extends HttpServlet
{

    static Connection currentCon = null;
    static ResultSet rs = null;  
	Statement stmt = null; 
	  
	String username ;

	public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, java.io.IOException
	{
		//Not logged In Redirect
		HttpSession session = req.getSession(true);   
		if(null == session.getAttribute("userBean"))
		{  
			 res.sendRedirect("/stewarttaylor/index.jsp");
		}
		 
		 res.sendRedirect("/stewarttaylor/editprofile.jsp"); 
	} 
		
		
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
	{   
		//Not logged In Redirect
		HttpSession session = req.getSession(true);   
		if(null == session.getAttribute("userBean"))
		{  
			res.sendRedirect("/stewarttaylor/index.jsp");
		}

		UserBean uuBean = (UserBean)session.getAttribute("userBean");
		username = uuBean.getUsername();

		//Get Edit Data
		String email = req.getParameter("email");
		String passwordOld = req.getParameter("password");
		String passwordNew = req.getParameter("password2");
		String imageLink  = req.getParameter("image");
		
		
		//Input Cleaning
		email = email.trim();
		imageLink = imageLink.trim();
		
		
		if(email.length() > 4)
		{
			setEmail(email);
		}
		
		
		if(passwordNew.length() > 2)
		{
			setPassword(passwordOld , passwordNew , username);
		}
		
		if(imageLink.length() > 4)
		{
			setImage(imageLink);
		}
		
		res.sendRedirect("/stewarttaylor/profile");
	}


	private void setEmail(String email)
	{
	
	   Connection currentCon = null;
       ResultSet rs = null;  
	   PreparedStatement stmt = null; 
	  
	   String query = "  UPDATE user SET email= ?  WHERE username= ? ";

	   
		try 
		{
			//connect to DB 
			currentCon = ConnectionManager.getConnection();

			currentCon.setAutoCommit(false);
			stmt =  currentCon.prepareStatement(query);

			stmt.setString(1,email);
			stmt.setString(2,username);	
	
			stmt.executeUpdate();	
			currentCon.commit();
		} 
		catch (Exception ex) 
		{
			System.out.println("Profile Edit Error :  " + ex);
		} 
	  
	   finally 
      {
         if (rs != null){
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
	
	
	private void setPassword(String passwordOld , String passwordNew , String userName)
	{
		passwordOld = encryptPassword( passwordOld);
		passwordNew = encryptPassword( passwordNew);
	
	
		Connection currentCon = null;
		ResultSet rs = null;  
		PreparedStatement stmt = null; 
		  
		String query = " UPDATE user SET password= ?  WHERE password= ? and username = ? ";

		try 
		{
			//connect to DB 
			currentCon = ConnectionManager.getConnection();

			currentCon.setAutoCommit(false);
			stmt =  currentCon.prepareStatement(query);

			stmt.setString(1,passwordNew);
			stmt.setString(2,passwordOld);	
			stmt.setString(3,username);	
			
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
	
	
	private void setImage(String link)
	{
	
		Connection currentCon = null;
        ResultSet rs = null;  
	    PreparedStatement stmt = null; 
	  
	  	String query = "  UPDATE user SET image_link= ?  WHERE username= ? ";

	  try 
      {
        //connect to DB 
		currentCon = ConnectionManager.getConnection();

		currentCon.setAutoCommit(false);
		stmt =  currentCon.prepareStatement(query);

		stmt.setString(1,link);
		stmt.setString(2,username);	
	
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
	
}
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

public class SignupServlet extends HttpServlet
{

    Connection currentCon = null;
    ResultSet rs = null;  
	PreparedStatement stmt = null; 
	   
	boolean accountCreated = false;

	public void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, java.io.IOException
	{
		res.sendRedirect("/stewarttaylor/signup.jsp");
	}
	   
	     
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws java.io.IOException, ServletException
	{
		   
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String password2 = req.getParameter("password2");
		   
		username.trim();
		   
		if(nameValid(username) == false)
		{
			res.sendRedirect("/stewarttaylor/signup.jsp?attempt=3");
		}
		   
		   
		   
		if( password.equals(password2)) // Passwords verified
		{
			username = username.trim();
			password = encryptPassword(password);
				
			createAccount(username ,password);
			  
			if(accountCreated == true)
			{
				//Log User in after account created 
				UserBean user = new UserBean();
				user.setUserName(username);
				user.setPassword(password);

				user = UserDAO.login(user);
					  
					  
				if (user.isValid())
				{	   
					HttpSession session = req.getSession(true);	    
					session.setAttribute("userBean",user); 
						  
					res.sendRedirect("/stewarttaylor/profile"); //logged-in page    
				}	
					  
			}
			else
			{
				res.sendRedirect("/stewarttaylor/signup.jsp?attempt=3");
			}
		}
		else
		{
			//Passwords don't match!
			res.sendRedirect("/stewarttaylor/signup.jsp?attempt=2");
		}
			
		res.sendRedirect("/stewarttaylor/newsfeed");   
	}
	
	

	private void createAccount(String username , String password)
	{
			
		String query = "  INSERT INTO user (username, password )VALUES (?,?) ";
		
		try 
		{
			 //connect to DB 
			currentCon = ConnectionManager.getConnection();

			currentCon.setAutoCommit(false);
			stmt =  currentCon.prepareStatement(query);

			stmt.setString(1,username);
			stmt.setString(2,password);	
	
			stmt.executeUpdate();	
			currentCon.commit();
			
			accountCreated = true;
		  } 
		catch (Exception ex) 
		{
			 System.out.println("ACCOUNT CREATION ERROR :  " + ex);
		} 
	}
		

	private boolean nameValid(String name)
	{	
		if (name.length() < 3)
		{
			return false;
		}
		else if (isValidChar(name) == false)
		{
			return false;
		}
		else if (name.length() > 9)
		{
			return false;
		}
		
		return true;
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
		

	public boolean isValidChar(CharSequence seq)
	{
		int len = seq.length();
		for(int i=0;i<len;i++) {
			char c = seq.charAt(i);
			// Test for all positive cases
			if('0'<=c && c<='9') continue;
			if('a'<=c && c<='z') continue;
			if('A'<=c && c<='Z') continue;
			if(c==' ') continue;
			if(c=='-') continue;
			// ... insert more positive character tests here
			// If we get here, we had an invalid char, fail right away
        return false;
    }
    // All seen chars were valid, succeed
    return true;
	}

}
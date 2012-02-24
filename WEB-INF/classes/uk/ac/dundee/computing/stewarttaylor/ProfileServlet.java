package uk.ac.dundee.computing.stewarttaylor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.sql.*;


public class ProfileServlet extends HttpServlet 
{

      static Connection currentCon = null;
      static ResultSet rs = null;  


		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, java.io.IOException 
		{
							   HttpSession session = req.getSession(true);
							   if(null == session.getAttribute("userBean"))
							   {  
									res.sendRedirect("/stewarttaylor/index.jsp");
								}
							   
							UserBean userBean = (UserBean)session.getAttribute("userBean");
							 int user_id = userBean.getUser_id();

							 
							String profileName = req.getRequestURI();
							
							 // Extract Profile Name   after -  /profile/NAME
							  if( profileName.length() > 23)
							  {
									profileName =  profileName.substring(23);
							   
									session.setAttribute("profileBean",fillData(profileName ,res ,user_id)); 
								MessageBean msgBean = getMessage(profileName , user_id);	
								session.setAttribute("msgBean",msgBean); 								
							   }
							   else 
							   {
										//show own profile
										 UserBean uuBean = (UserBean)session.getAttribute("userBean");
										 
										  
										try
										{
										
									
										
											String userName = uuBean.getUsername();
											session.setAttribute("profileBean",fillData(userName ,res ,user_id));
											MessageBean msgBean = getMessage(profileName ,user_id);
											session.setAttribute("msgBean",msgBean); 
										}
										catch(Exception e)
										{
															   RequestDispatcher dispatcher = req.getRequestDispatcher("/profile");
																dispatcher.forward(req, res);
										}
							   }
							   
							   
							   
							   		
									
							   
			RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
			dispatcher.forward(req, res);		   
		}
	   
	   
	   
	   
	   
	   
	   
		   private ProfileBean fillData(String username , HttpServletResponse res , int user_id)
		   {

					ProfileBean profile = new ProfileBean();
			
					PreparedStatement stmt = null;    
					String searchQuery =  "select * from user where username= ? ";
							
						 try 
						  {
							 //connect to DB 
							currentCon = ConnectionManager.getConnection();
							currentCon.setAutoCommit(false);
							stmt =  currentCon.prepareStatement(searchQuery);
							stmt.setString(1,username);
							
					
							
							rs = stmt.executeQuery();	
							currentCon.commit();       
							


							boolean more = rs.next();
							   
							 // if user does not exist set the isValid variable to false
							 if (!more) 
							 {
									//User Not Found
									  res.sendRedirect("/stewarttaylor/profile");
							 } 
								
							 //if user exists set the isValid variable to true
							 else if (more) 
							 {
							 
									String userName = rs.getString("username");
									int id = rs.getInt("user_id");
									int msgCount ;
									
									String date = rs.getString("date_joined");
									String image = rs.getString("image_link");
								
								if( date != null)
								{
										date =  date.substring(0,10);
								}

								profile.setUserName(userName);
								profile.setID(id);
								profile.setJoindate(date);
								profile.setImage(image);
								
								setFollows(profile ,id);
								setFollowers(profile ,id);
								
								
								
								if( user_id ==id)
								{
									profile.setOwnProfile(true);
								}
								else
								{
									profile.setOwnProfile(false);
								}
								
								
								//check if user follows them
								Statement stmt2 = null;    
								String searchQuery2 =  "SELECT * from follow where followed_id = " + user_id +  "  and user_id =  " + id ;
											
								 stmt2 =currentCon.createStatement();
								ResultSet  rs2 = stmt2.executeQuery(searchQuery2);	        
								 boolean more2 = rs2.next();
								
								 if (!more2) 
								 {
									profile.setFollowed(false);
								 } 
								 else if (more2) 
								 {
									profile.setFollowed(true);
								 }
							 
								 Statement stmt3 = null;    
								String searchQuery3 =  "SELECT COUNT(*) from message where user_id = " + id +  " " ;
											
								stmt3 =currentCon.createStatement();
								ResultSet  rs3 = stmt3.executeQuery(searchQuery3);	        
							 
							 while (rs3.next())
							 {
									profile.setMessageCount(rs3.getInt(1));
							}
							 
							 

							 }
						  } 

				  catch (Exception ex) 
				  {
					 System.out.println("Log In failed: An Exception has occurred! " + ex);
				  } 
		   
		   
		   
		   
		   

		   return profile;
		   
		   }
		   
		   
		   
		   private ProfileBean setFollows(ProfileBean profile ,int user_id)
		   {
		   
				try
				{
					
						Connection MyConnection= DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk/stewarttaylor","stewarttaylor","ac31004");

						Statement st    = null;
						ResultSet rs;
						 st = MyConnection.createStatement();


					rs = st.executeQuery("SELECT * FROM follow join user on user.user_id = follow.user_id where follow.followed_id = " + user_id );


					int count = 0;

					while (rs.next()) 
					{
						++count;
						// Get data from the current row and use it
					}

						String[ ] follows = new String[count] ;

						rs.first();
						rs.previous();
						
						int i = 0;
						
						 while (rs.next() )
						 {
									
									follows[i] = rs.getString("username");
									
									i++;
						}
						
						profile.setFollows(follows);

					}
					catch(Exception e)
					{
					
							System.out.println("Error: " + e);
					}
		   
		   
				return profile;
		   }
		   
		   
		   
		   
		   
		   	private ProfileBean setFollowers(ProfileBean profile ,int user_id)
		   {
		   
				try
				{
					
						Connection MyConnection= DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk/stewarttaylor","stewarttaylor","ac31004");

						Statement st    = null;
						ResultSet rs;
						 st = MyConnection.createStatement();


					rs = st.executeQuery("SELECT * FROM follow join user on user.user_id = follow.followed_id where follow.user_id = " + user_id );


					int count = 0;

					while (rs.next()) 
					{
						++count;
						// Get data from the current row and use it
					}

						String[ ] follows = new String[count] ;

						rs.first();
						rs.previous();
						
						int i = 0;
						
						 while (rs.next() )
						 {
									
									follows[i] = rs.getString("username");
									
									i++;
						}
						
						profile.setFollowers(follows);

					}
					catch(Exception e)
					{
					
							System.out.println("Error: " + e);
					}
		   
		   
				return profile;
		   }
		   
		   
		   
		   
		   
		   
		   
		   
		 private MessageBean getMessage(String name , int userID)
		{
			MessageBean msgBean = new MessageBean();
		

			try
			{
				
				Connection MyConnection= DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk/stewarttaylor","stewarttaylor","ac31004");

				Statement st    = null;
				ResultSet rs;
				 st = MyConnection.createStatement();


			rs = st.executeQuery("Select * from message   JOIN user ON message.user_id = user.user_id where user.username = '" + name + "' ORDER BY message_id DESC  LIMIT 5");


			int count = 0;

			while (rs.next()) 
			{
				++count;
				// Get data from the current row and use it
			}

				String[ ] names = new String[count] ;
				int[ ] ids = new int[count] ;
				String[ ] msgs = new String[count];
				String[ ] dates = new String[count];
				String[ ] images = new String[count];
				boolean[ ] deletes = new boolean[count];

				rs.first();
				rs.previous();
				
				int i = 0;
				
				 while (rs.next() )
				 {
							
							names[i] = rs.getString("username");
							ids[i] = rs.getInt("message_id");
							msgs[i] = rs.getString("message_text");
							images[i] = rs.getString("image_link");
							dates[i] = DateDisplay.formatDate(rs.getString("date"));
							
							
							//check for id
							if( rs.getInt("user.user_id") == userID)
							{
								deletes[i] = true;
							}
							else
							{
								deletes[i] = false;
							}
							
							
							i++;
				}
				
				msgBean.setUsername(names);
				msgBean.setID(ids);
				msgBean.setMessage(msgs);
				msgBean.setDate(dates);
				msgBean.setImage(images);
				msgBean.setCanDelete(deletes);
				
				
				}
				catch(Exception e)
				{
				
						System.out.println("Error: " + e);
				}
			
			return msgBean;
		}
		
		
		
	
		   

}
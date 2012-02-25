package uk.ac.dundee.computing.stewarttaylor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.util.*;
import java.sql.*;


public class NewsfeedServlet extends HttpServlet
{

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, java.io.IOException 
		{
		
			HttpSession session = req.getSession(true);
			if(null == session.getAttribute("userBean"))
			{  
				res.sendRedirect("index.jsp");
			}
							   	   
			UserBean uBean = (UserBean)session.getAttribute("userBean");
			int userID  = uBean.getUser_id();
							   
			MessageBean msgBean = getMessage(userID);		
			session.setAttribute("msgBean",msgBean); 
							
			RequestDispatcher dispatcher = req.getRequestDispatcher("/newsfeed.jsp");
			dispatcher.forward(req, res);	   
		} 
		
		
		private MessageBean getMessage(int userID)
		{
			MessageBean msgBean = new MessageBean();

			try
			{
				
				Connection MyConnection= DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk/stewarttaylor","stewarttaylor","ac31004");

				Statement st  = null;
				ResultSet rs;
				st = MyConnection.createStatement();

				rs = st.executeQuery("select * from message join user on user.user_id = message.user_id  where message.user_id in  (SELECT follow.user_id FROM follow join user on user.user_id = follow.user_id where follow.followed_id = " + userID + " ) or  message.user_id = " + userID + " ORDER BY message_id DESC ");

				int count = 0;

				while (rs.next()) 
				{
					++count;
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
							
					//check for id so display delete can be shown
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
	
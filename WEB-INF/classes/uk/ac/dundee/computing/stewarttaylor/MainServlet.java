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

public class MainServlet extends HttpServlet
 {


		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, java.io.IOException 
		{
		
					
	
					HttpSession session = req.getSession(true);
					  if(null == session.getAttribute("userBean"))
					  {  
							  res.sendRedirect("/stewarttaylor/newsfeed");
					  }
							   
							   
					
			MessageBean msgBean = getMessage();
			session.setAttribute("msgBean",msgBean); 
					
					
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, res);	   
		} 
		
		
		
		
		private MessageBean getMessage()
		{
			MessageBean msgBean = new MessageBean();
		
			try
			{
				
				Connection MyConnection= DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk/stewarttaylor","stewarttaylor","ac31004");

				Statement st    = null;
				ResultSet rs;
				 st = MyConnection.createStatement();


			rs = st.executeQuery("Select * from message   JOIN user ON message.user_id = user.user_id ORDER BY message_id DESC LIMIT 2 ");


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
				boolean[] deletes = new boolean[count];

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
							
							deletes[i] = false;
							
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
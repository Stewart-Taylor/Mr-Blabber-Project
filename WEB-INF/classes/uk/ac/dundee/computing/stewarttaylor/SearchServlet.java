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


public class SearchServlet extends HttpServlet
{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, java.io.IOException
	{
						
		String term = req.getParameter("search");
		 	
		if(term.length() > 1)
		{				
			res.sendRedirect("/stewarttaylor/profile/" + term);
		}
		else
		{
			res.sendRedirect("/stewarttaylor/");
		}		 
	}
					   
}
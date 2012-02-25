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
import java.util.StringTokenizer; 

public class DateDisplay
{

	public static String formatDate(String date)
	{
		String output ;
		
		date = date.substring(0,10);
		
		StringTokenizer st = new StringTokenizer( date, "-") ;
		
		String year =  st.nextToken(); 
		String month = st.nextToken();
		String day = st.nextToken();
		
		output = day + "/" + month + "/" + year ;
		
		return output;
	}
}
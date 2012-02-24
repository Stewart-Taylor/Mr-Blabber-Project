package uk.ac.dundee.computing.stewarttaylor;


import java.sql.*;
import java.util.*;


public class ConnectionManager 
{
	  static Connection con;
      static String url;
            
      public static Connection getConnection()
      {
        
         try
         {
            Class.forName("org.gjt.mm.mysql.Driver");
            
            try
            {      

				//Connection String
               con = DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk/stewarttaylor","stewarttaylor","ac31004");
                								  
            }
            
            catch (SQLException ex)
            {
               ex.printStackTrace();
            }
         }
         catch(ClassNotFoundException e)
         {
            System.out.println(e);
         }

      return con;
	}
}
<jsp:useBean
	id="userBean"
	scope="session"
	class="uk.ac.dundee.computing.stewarttaylor.UserBean" />

	

	
	
	<%@ page import="java.util.*,java.sql.*"%>
	














<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

	<meta charset="utf-8" />

	<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

	<title> </title>

	<meta name="keywords" content="" />

	<meta name="description" content="" />

	<link rel="stylesheet" href="/stewarttaylor/style.css" type="text/css" media="screen, projection" />

</head>



<body>






<div id="wrapper">
	
	
	
	
<%@ include file="parts/header.jsp" %>

		
		
			
	
		
		
		
		
		

 
    
    
	
  
    
    <div id="content">
    
	

	
	
	<div id="middle_content">
	

	
	
	
	<%@ include file="parts/messageBox.jsp" %>
	
	
	 <div id="mainnewsbox">
	        <h2>News Feed </h2>
       

	   


	   
	   <%@ include file="parts/messagesDisplay.jsp" %>
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

	   
	   

	</div>
     
     
        
  
    
        
        </div><!--end of middle content-->



    
            
      


    
	 <div style="clear: both;">
	</div><!-- #content-->



	<footer id="footer">

		<p>Created By Stewart Taylor</p>

	</footer><!-- #footer -->



</div><!-- #wrapper -->



</body>

</html>
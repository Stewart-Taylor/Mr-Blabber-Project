<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">



<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta charset="utf-8" />
	<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<title> </title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link rel="stylesheet" href="style.css" type="text/css" media="screen, projection" />
	
	<script language="javascript" src="md5.js"></script>
</head>



<body>

	<div id="wrapper">

	
		<div id="header">
			
			<div id = "logobox">
				<img src="Images/Logo.png" alt="Logo" />
			</div>

		</div>


		<div id="content">

				
		<div id="middle_content">

				<% 
				
				try
				{
				
					 String atmpt =request.getParameter("attempt");
					
					if(atmpt.equals("1"))
					{
						out.print("<h2> Username already Exists </h2>");
					}
					else if(atmpt.equals("2"))
					{
						out.print("<h2> Passwords Don't Match </h2>");
					}
					else if(atmpt.equals("3"))
					{
						out.print("<h2> Invalid Username or password </h2>");
					}
			
				
				}catch(Exception E)
				{
				
				
				}
				
				
				%>
			
				<jsp:include page="parts/Signup.jsp"/>
			
		</div><!--end of left content-->

		<div style="clear: both;">
		</div><!-- #content-->

		
		<footer id="footer">
			<p>Created By Stewart Taylor</p>
		</footer><!-- #footer -->


	</div><!-- #wrapper -->



</body>

</html>
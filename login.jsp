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
	
	
<script language="javascript">
	function passResponse()
	 {
	document.hform.un.value = document.login.un.value;
	document.hform.pw.value = MD5(document.login.pw.value);
	document.login.pw.value = "";
	document.hform.submit();
	}
</script>
	

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
	
	
	

	
	
	
	
	
	
						<div id="signup_box">		
						
						
							<h2> Login </h2>
	
	
		<% 
	
	try
	{
	
	 String atmpt =request.getParameter("attempt");
	
	
	if(atmpt.equals("1"))
	{
	
	out.print("<h3> Invalid Username or password </h3>");
	
	}
	}
	catch(Exception e)
	{
	
	
	}
	
	
	%>
						
						
											<form name="hform" action="/stewarttaylor/login/" method="post" >
<input type="hidden" name="un">
<input type="hidden" name="pw">
			</form>		
						
						
			<form name="login" method="post">
				
				<div id="signup_item" >
				Username <input type="text" class ="tb3" name="un"/>	
				</div>
				
				<div id="signup_item" >
				
				 Password <input type="password" class ="tb3" name="pw"/>
				
				</div>
				
		
				
				
				
				<input type="submit" onClick="passResponse(); return false;"   class="btn1" value="Login" />
				
				
			</form>
			
			
			</div>
	
	
	
     
     
        
 
    
        
        </div><!--end of left content-->



    


	 <div style="clear: both;">

	</div><!-- #content-->



	<footer id="footer">

		<p>Created By Stewart Taylor</p>

	</footer><!-- #footer -->



</div><!-- #wrapper -->



</body>

</html>
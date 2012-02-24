


<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta charset="utf-8" />
		<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
		<title> </title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<link rel="stylesheet" href="/stewarttaylor/style.css" type="text/css" media="screen, projection" />

		<script language="javascript" src="md5.js"></script>
		
	</head>

<body>

	<div id="wrapper">




		<div id="header">


<script language="javascript">
function passResponse()
 {
document.hform.un.value = document.login.un.value;
document.hform.pw.value = MD5(document.login.pw.value);
document.login.pw.value = "";
document.hform.submit();


}

</script>
		
		
			<div id = "logobox">
				<img src="Images/Logo.png" alt="Logo" />
			</div>

				<div id="loginbox">		
				
							<form name="hform" action="/stewarttaylor/login/" method="post" >
<input type="hidden" name="un">
<input type="hidden" name="pw">
			</form>
				
				
					<form name="login" method="post" >
						
						<div id="loginbox_item" >
							Username <input type="text" name="un" />
						</div>
						
						<div id="loginbox_item" >
							Password <input type="password" name="pw" />
						</div>
						
						<div id="loginbox_button">
							<input onClick="passResponse(); return false;" type="submit"   class="btn2" value="Login" />
						</div>
						
					</form>
				</div>

		</div>


		<div id="content">

				
		<div id="left_content">
		
		<div id="recentmsgbox">
		
					<h2>Recent Blab </h2>

			  
				
			<%@ include file="parts/messagesDisplay.jsp" %>
			 
			 
			
			   
			   
		</div>
		
		
		
		 
		 
			
	 
		
			
			</div><!--end of left content-->



			<div id="right_content">
			
				<%@ include file="parts/Signup.jsp" %>
				
			</div><!--end of right content-->


		 <div style="clear: both;">
		 </div><!-- #content-->



		<footer id="footer">
			<p>Created By Stewart Taylor</p>
		</footer><!-- #footer -->

	</div><!-- #wrapper -->



</body>

</html>
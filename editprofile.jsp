<jsp:useBean
	id="profileBean"
	scope="session"
	class="uk.ac.dundee.computing.stewarttaylor.ProfileBean" />


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
				
				
				<div id = "middle_content">
				
						<div id="signup_box">
						
							<h4>Edit Profile</h4>
							
							<form name="register" action="/stewarttaylor/editprofile" method="Post">
							
								<div id="signup_item">
									Email  <input type="text"  class ="tb3" name="email" maxlength="30" />
								</div>
								
								<div id="signup_item">
									Old Password  <input type="password"  class ="tb3" name="password" maxlength="30" />
								</div>
											
								<div id="signup_item">
									New Password  <input type="password"  class ="tb3" name="password2" maxlength="30" />
								</div>
									
								<div id="signup_item">
									Image Link  <input type="text"  class ="tb3" name="image"  />
								</div>
						
								<input type="submit" class="btn1" value="Confirm Changes" />
							
							</form>
						
						</div>
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
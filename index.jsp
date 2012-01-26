<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"><head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<title>Twitter Clone</title>

<link rel="stylesheet" type="text/css" href="style.css" media="screen">

</head>



<body>




<div id="main_container">

	

	<div id="header">

    	

		<div id = "logobox">

			<img src="images/Logo.png" alt="Logo" HEIGHT="50" WIDTH="300"/>

		</div>

		

		

		

		


		


		

		

		


 

    </div>

    

	

  

    

    <div id="main_content">

    

	

	<?php

	

	

	if($loggedIn == true)

	{

	

	include('newsFeed.php'); 

	

	}

	else

	{

	

	?>

	

	

	<div id="left_content">

        <h2>Scrob</h2>

        <p>

This is a twitter clone its made of twitters and clones.  

        </p>

        

        


     

        

  

    

        

        </div><!--end of left content-->







    	<div id="right_content">

        

        	

			<div id="signup_box">

			<h4>Join Today</h4>

			<form name="register" action="registerInitial.php" method="post">

				<h3> Username </h3> <input type="text"  class ="tb3" name="username" maxlength="30" /></br>

				<h3> Password:</h3> <input type="password" class ="tb3" name="pass1" /></br>

				<h3> Password Again:</h3> <input type="password"  class ="tb3"name="pass2" /></br>

		<input type="submit" value="Register" />

	</form>

			

		<!--	<input type="submit" value="Sign Up" /> -->

			

			</form>

            

			

            </div>

            

            



        </div><!--end of right content-->





		<?php

		

		}

		

		?>

    

    <div style=" clear:both;"></div>

    </div><!--end of main content-->

 



 

 

 

 

     <div id="footer">

     	

		

		

		

        	<div class="footer_links">









        </div>



    

    

    </div>  

 

   



</div> <!--end of main container-->





</body>

</html>
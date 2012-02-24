<jsp:useBean
	id="profileBean"
	scope="session"
	class="uk.ac.dundee.computing.stewarttaylor.ProfileBean" />


<!DOCTYPE html>


<%@ page import="java.util.*,java.sql.*"%>

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
    
	

	<div id="profileContent">
	
	
	
	<div id="profileBox" >
	
	
	

	
	
	<h2> 	<jsp:getProperty
	name="profileBean"
	property="Username"/> </h2>
	
	
	
	
	
	<img class="avtbig" src="<jsp:getProperty name="profileBean" property="image"/>" alt="avatar" />
	

	
	
	<p>Joined <br/><jsp:getProperty
	name="profileBean"
	property="joindate"/> </p>
	
	</div>
	
	
		<div id="profileStats" >
	<p>Blabs: <jsp:getProperty
	name="profileBean"
	property="messagecount"/> </p>
	
					

	
	</div>
	
	
	
	
	
	<%
	
	if( profileBean.getOwnProfile() == false)
	{
		if( profileBean.getFollowed() == false)
		{
		
		%>
			<form name="login" action="/stewarttaylor/follow/<jsp:getProperty name="profileBean"property="Username"/>" >
	<input type="submit"   class="btn2" value="Follow" />
	</form>
	<%
	
		}
		else
		{
		
				%>
			<form name="login" action="/stewarttaylor/unfollow/<jsp:getProperty name="profileBean"property="Username"/>" >
	<input type="submit"   class="btn2" value="UnFollow" />
	</form>
	<%
		
		
		
		}
		
	}
	
	
	
	

	%>
	
					<div id="profileFriendsBox" >
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<h3> Follows</h3>
	
<%

	try 
	{

		String[] follows = profileBean.getFollows();

	 

	 for(int i = 0 ; i< follows.length ; i++)
	 {
	 
	 
		 %> 
			<div id="profileFriend">
				<a href="/stewarttaylor/profile/<% out.println(follows[i]); %>"><% out.println(follows[i]); %></a>
			</div>
		   
			<% 
	 
	 }
	 }
	 catch(Exception E)
	 {
		//out.println("<h3> No Posts Retrieved</h3>");
	}
	
%> 


		</div>
		
		
		
		
		
		
							<div id="profileFriendsBox" >
	
	<h3> Followers</h3>
	
	<%

	try 
	{

		String[] followers = profileBean.getFollowers();

	 

	 for(int i = 0 ; i< followers.length ; i++)
	 {
	 
	 
		 %> 
			<div id="profileFriend">
				<a href="/stewarttaylor/profile/<% out.println(followers[i]); %>"><% out.println(followers[i]); %></a>
			</div>
		   
			<% 
	 
	 }
	 }
	 catch(Exception E)
	 {
		//out.println("<h3> No Posts Retrieved</h3>");
	}
	
%> 
	

		</div>
	
	
	
	

	
	
	

	
	</div>
	
	<div id="right_content">
	


	<%
	
	

	
	if(profileBean.getOwnProfile() == true)
	{
	
	
	%>
	
	<h2><a href="/stewarttaylor/editprofile/">Edit Profile</a></h2>
	
	
	
		   <%@ include file="parts/messageBox.jsp" %>
		
		<%
		}
						
%>	
	
	
	
	
	
	 <div id="mainnewsbox">
	        <h2>Recent Posts</h2>
       
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
<jsp:useBean
	id="userBean2"
	scope="session"
	class="uk.ac.dundee.computing.stewarttaylor.UserBean" />

	<div id="header">
    	
		<div id = "logobox">
			<a href="/stewarttaylor/newsfeed" >
			<img src="/stewarttaylor/Images/Logo.png" alt="Logo" />
			</a>
		</div>
		
		
		
		
		<div id = "searchbar">
				<form name="search" action="/stewarttaylor/search/" method="get" >
					 <input type="text" name="search" />
					<input type="submit"   class="btn2" value="Search" />
				</form>
		</div>
		
		
		
		
				<div id = "Profilebox">

	
		<div class="hbuttons">
		
		<%
						uk.ac.dundee.computing.stewarttaylor.UserBean uBean2 = (uk.ac.dundee.computing.stewarttaylor.UserBean)session.getAttribute("userBean");
				String sName = uBean2.getUsername();
		
		%>
		
			<a href="/stewarttaylor/profile/<% out.print(sName); %>"><% out.print(sName);    %> </a> 

			<a href="/stewarttaylor/newsfeed">Home </a> 

			<a href="/stewarttaylor/Logout">Logout </a> 

			</div>

		</div>


		</div>



		<jsp:useBean
	id="msgBean"
	scope="session"
	class="uk.ac.dundee.computing.stewarttaylor.MessageBean" />
	   <%
try 
{

	String[] names = msgBean.getUsername();
	String[] dates = msgBean.getDate();
	String[] messages = msgBean.getMessage();
	String[] images = msgBean.getImage();
	boolean[] canDelete = msgBean.getCanDelete();
	int[] id = msgBean.getID();
 
 
 
 for(int i = 0 ; i< names.length ; i++)
 {

	 %>
	 <div id="msgbox">
	   
	   
	   	   		<div id="msgUser">
				<a href="/stewarttaylor/profile/<% out.println(names[i]); %>"><% out.println(names[i]); %></a>
				 <%
				if (canDelete[i] == true)
				{
			   %>
				<div id="msgDelete">
					<a href="/stewarttaylor/deletemessage/<% out.println(id[i]); %>"><img src="/stewarttaylor/Images/Delete.png" alt="Delete" /> </a>
				</div>
				 <%
				}
				%>

				</div>
	   
	   
	    <div id="msgProfile">
					<div id="msgImage">
					<img src="<% out.println(images[i]); %>" alt="Avatar" width="80" height="80"/>
			   </div>
			   
			   
							 <div id="msgTime">
				<p><% out.println(dates[i]); %></p>
			   </div>
	
		   </div>
		 
		   	<div id="msgText">
		   <p>
		   <% out.println(messages[i]); %>
		   </p>
		   </div>  
	   
	   </div>
 		<% 
 
 }
 }
 catch(Exception E)
 {
    out.println("<h3> No Posts Retrieved</h3>");
	
}
%> 
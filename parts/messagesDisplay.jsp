	
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
		   <a href="/stewarttaylor/profile/<% out.println(names[i]); %>"> <% out.println(names[i]); %></a>
		   </div>
		  
		  <div id="msgTime">
		   <p><% out.println(dates[i]); %></p>
		   
		   
		   <%
		   
			   
				if (canDelete[i] == true)
				{
			   
			   %>
					<a href="/stewarttaylor/deletemessage/<% out.println(id[i]); %>">Delete </a>
			   
			   <%
			   
			 
				}
		   
		   
		   
		   
		   %>
		   
		   
		  <!-- <a href="deletemessage/12">Delete </a> -->
		   </div>
		   
			<div id="msgImage">
				<img src="<% out.println(images[i]); %>" alt="Avatar" />
		   </div>
		   
		   
		   <div id="msgText">
		   <p><xmp><% out.println(messages[i]); %></xmp>
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
	
	
	
	
	
	
	

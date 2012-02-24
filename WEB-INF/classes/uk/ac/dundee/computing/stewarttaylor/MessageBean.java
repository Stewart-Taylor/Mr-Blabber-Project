package uk.ac.dundee.computing.stewarttaylor;


   public class MessageBean {
	
      private String[] username  ;
      private int[] messageid ;
	  private String[] message ;
	  private String[] date ;
	  private String[] image ;
	  private boolean[] canDelete;
	
	
	
	 public boolean[] getCanDelete() 
	  {
         return canDelete;
	  }

      public void setCanDelete(boolean[] delT)
	  {
         canDelete = delT;
	  }
	
	
	
		 public String[] getImage() 
	  {
         return image;
	  }

      public void setImage(String[] imageT)
	  {
         image = imageT;
	  }
	
	
	
	 public String[] getUsername() 
	  {
         return username;
	  }

      public void setUsername(String[] uname)
	  {
         username = uname;
	  }
	  
	  public int[] getID() 
	  {
         return messageid;
	  }

      public void setID(int[] idT)
	  {
         messageid = idT;
	  }
	  
	  public String[] getMessage() 
	  {
         return message;
	  }

      public void setMessage(String[] messageT)
	  {
         message = messageT;
	  }
	  
	   public String[] getDate() 
	  {
         return date;
	  }

      public void setDate(String[] dateT)
	  {
         date = dateT;
	  }
	
 
  
}
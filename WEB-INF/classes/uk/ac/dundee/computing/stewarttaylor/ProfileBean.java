package uk.ac.dundee.computing.stewarttaylor;


   public class ProfileBean {
	
      private String username;
      private int messagecount;
	  private int id;
      private String friendcount;
      private String firstName;
	  private String secondName;
	  private String joindate;
      public boolean valid;
	  public boolean followed;
	  public String image;
	  private String[] follows  ;
	  private String[] followers  ;
	  private boolean ownProfile;
	  
	
	public boolean getOwnProfile() 
	  {
         return ownProfile;
	  }
	  
	  	public void setOwnProfile(boolean own) 
	  {
         ownProfile = own;
	  }
	
	
		public String[] getFollows() 
	  {
         return follows;
	  }
	  
	  	public void setFollows(String[] followsT) 
	  {
         follows = followsT;
	  }
	  
	  public String[] getFollowers() 
	  {
         return followers;
	  }
	  
	  	public void setFollowers(String[] followsT) 
	  {
         followers = followsT;
	  }
	
	
	 public boolean getFollowed() 
	  {
         return followed;
	  }

      public void setFollowed(boolean fol)
	  {
         followed = fol;
	}
	
	
	 public int getID() 
	  {
         return id;
	  }

      public void setID(int idT) 
	  {
         id = idT;
	}
	
	
	
	 public String getImage() 
	  {
         return image;
	  }

      public void setImage(String img) {
         image = img;
	}
	
	
	
	
	  public String getJoindate() 
	  {
         return joindate;
	  }

      public void setJoindate(String date) {
         joindate = date;
	}
	
	
      public String getFirstName() 
	  {
         return firstName;
	  }

      public void setFirstName(String newFirstName) {
         firstName = newFirstName;
	}

	
      public String getSecondName() {
         return secondName;
			}

      public void setSecondName(String newLastName)
	  {
         secondName = newLastName;
	  }
			

    
      public String getUsername()
	  {
         return username;
			}

      public void setUserName(String newUsername) 
	  {
         username = newUsername;
	  }

			
      public void setMessageCount(int count) 
	  {
         messagecount = count;
	  }
	  
	  public int getMessageCount() 
	  {
         return messagecount;
	  }

      public void setFriendCount(String newUsername) 
	  {
         username = newUsername;
	  }
	  
	  public String getFriendCount() 
	  {
         return friendcount;
	  }  
  
}
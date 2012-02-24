package uk.ac.dundee.computing.stewarttaylor;


   public class UserBean {
	
      private String username;
      private String password;
      private String firstName;
      private String lastName;
      public boolean valid;
	  public int user_id;
	
	
	
		public int getUser_id() {
			 return user_id;
		}

		  public void setUser_id(int idT) {
			 user_id = idT;
		}
		
		
		  public String getFirstName() {
			 return firstName;
		}

		  public void setFirstName(String newFirstName) {
			 firstName = newFirstName;
		}

		
		  public String getLastName() {
			 return lastName;
				}

		  public void setLastName(String newLastName) {
			 lastName = newLastName;
				}
				

		  public String getPassword() {
			 return password;
		}

		  public void setPassword(String newPassword) {
			 password = newPassword;
		}
		
				
		  public String getUsername() {
			 return username;
				}

		  public void setUserName(String newUsername) {
			 username = newUsername;
				}

					
		  public boolean isValid() {
			 return valid;
		}

		  public void setValid(boolean newValid) {
			 valid = newValid;
		}	
}
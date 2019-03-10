package com.perscholas.springmvc_sba.models;

public class User {
	public int userId;
	public String userName;
	public String password;
	
	public User(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String pasword) {
		
	}

	public User(String password) {
		
	}
	
	public User() {
		
	}

	public int getUserId()
	    {
	        return userId;
	    }
	    
	  public void setUserId(int userId)
	    {
	        this.userId = userId;
	    }
	  public String getUserName()
	    {
	        return userName;
	    }
	    
	  public void setUserName(String userName)
	    {
	        this.userName = userName;
	    }
	  public String getPassword()
	    {
	        return password;
	    }
	    
	  public void setPassword(String password)
	    {
	        this.password = password;
	    }
	
}

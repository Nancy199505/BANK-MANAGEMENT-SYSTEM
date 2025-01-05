package com.bank.Model;

public class User {
    private String userId;
    private String username;
    private String password;


    public User() {}

    public User(String string, String username, String password) {
        this.userId = string;
        this.username = username;
        this.password = password;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserId(int int1) {
		// TODO Auto-generated method stub
		
	}
}
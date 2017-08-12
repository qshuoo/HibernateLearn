package com.hibernate.entity;

public class User {
	
	private int id; 
	private String username;
	private String realname;
	private String pwd;
	
	public User() {
	}
	
	public User(String username, String realname, String pwd) {
		this.username = username;
		this.realname = realname;
		this.pwd = pwd;
	}

	public User(int id, String username, String realname, String pwd) {
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getRealname() {
		return realname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", realname=" + realname + ", pwd=" + pwd + "]";
	}
	
	

	
}

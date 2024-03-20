package com.entity;

public class User {
	
	private int id;
	private String uname;
	private String uemail;
	private String upwd;
	private String umobile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUmobile() {
		return umobile;
	}
	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}
	public User(String uname, String uemail, String upwd, String umobile) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upwd = upwd;
		this.umobile = umobile;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String uname, String uemail, String umobile) {
		super();
		this.id = id;
		this.uname = uname;
		this.uemail = uemail;
		this.umobile = umobile;
	}
	
	
	
	

}

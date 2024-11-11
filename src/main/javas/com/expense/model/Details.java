package com.expense.model;

public class Details {
	private int S_No;
	private String UserName;
	private String Email;
	private String Passwd;
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Details(int s_No, String userName, String email, String passwd) {
		super();
		S_No = s_No;
		UserName = userName;
		Email = email;
		Passwd = passwd;
	}
	public int getS_No() {
		return S_No;
	}
	public void setS_No(int s_No) {
		S_No = s_No;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPasswd() {
		return Passwd;
	}
	public void setPasswd(String passwd) {
		Passwd = passwd;
	}
	@Override
	public String toString() {
		return "Details [S_No=" + S_No + ", UserName=" + UserName + ", Email=" + Email + ", Passwd=" + Passwd + "]";
	}
	
	
}



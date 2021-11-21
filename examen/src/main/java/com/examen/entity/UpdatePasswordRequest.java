package com.examen.entity;

public class UpdatePasswordRequest {
	
	private String username;
	private String newPassword;
	
	public UpdatePasswordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdatePasswordRequest(String username, String newPassword) {
		super();
		this.username = username;
		this.newPassword = newPassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	

}

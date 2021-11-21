package com.examen.entity;

public class AuthenticationResponse {
	
	private final String jwt;
	private boolean isUserExpired;
		
	public AuthenticationResponse(String jwt, boolean isUserExpired) {
		super();
		this.jwt = jwt;
		this.isUserExpired = isUserExpired;
	}
	
	public boolean isUserExpired() {
		return isUserExpired;
	}
	public void setUserExpirate(boolean isUserExpired) {
		this.isUserExpired = isUserExpired;
	}
	public String getJwt() {
		return jwt;
	}
	
	

}

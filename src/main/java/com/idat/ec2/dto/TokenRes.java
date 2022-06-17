package com.idat.ec2.dto;

public class TokenRes {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TokenRes(String token) {
		this.token = token;
	}
	
}

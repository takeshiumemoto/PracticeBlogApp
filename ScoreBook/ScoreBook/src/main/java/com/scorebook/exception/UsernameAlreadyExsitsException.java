package com.scorebook.exception;

@SuppressWarnings("serial")
public class UsernameAlreadyExsitsException extends RuntimeException{

	private final String username;
	
	public UsernameAlreadyExsitsException(String username) {
		super("このユーザー名は既に使用されています:" + username);
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
}

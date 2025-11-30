package com.scorebook.exception;

@SuppressWarnings("serial")
public class PasswordNotMatchException extends RuntimeException{

	public PasswordNotMatchException() {
		super("パスワードが一致しません");
	}
	
	public PasswordNotMatchException(String message) {
		super(message);
	}
}

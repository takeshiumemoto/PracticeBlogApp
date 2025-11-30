package com.scorebook.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistrationForm {

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@NotBlank(message="パスワードは必須です")
	@Size(min=6, max=100,message="パスワードは6文字以上で入力してください")
	private String password;
	
	@NotBlank(message="確認用パスワードは必須です")
	private String confirmPassword;
	
	@NotBlank(message="表示名は必須です")
	@Size(max=10, message="表示名は100文字以内で入力してください")
	private String displayName;
	
	@NotBlank(message="ユーザー名は必須です")
	@Size(min=3, max=50, message="ユーザー名は3~50文字で入力してください")
	private String username;
	
	
}

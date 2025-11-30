package com.scorebook.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name="user_account")
public class UserAccount {
	
	@Id
	public Long id;
	
	@Column(name="username")
	public String username;
	
	@Column(name="password")
	public String password;
	
	@Column(name="display_name")
	public String displayName;

	@Column(name="role")
	public String role;
	
	@Column(name="enabled")
	public Boolean enabled;
	
	public static UserAccount of(String username, String encodedPassword, String displayName) {
		UserAccount u = new UserAccount();
		u.username = username;
		u.password = encodedPassword;
		u.displayName = displayName;
		u.role = "ROLE_USER";
		u.enabled = true;
		return u;
	}
}

package com.scorebook.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scorebook.dao.UserAccountDao;
import com.scorebook.entity.UserAccount;
import com.scorebook.exception.PasswordNotMatchException;
import com.scorebook.exception.UsernameAlreadyExsitsException;
import com.scorebook.form.UserRegistrationForm;

@Service
public class UserAccountService implements UserDetailsService{
	
	private final UserAccountDao userDao;
	private final PasswordEncoder passwordEncoder;
	
	public UserAccountService(UserAccountDao userDao, PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<UserAccount> opt = userDao.findByUsername(username);
		UserAccount userAccount = opt.orElseThrow(() -> new UsernameNotFoundException("user not found" + username));
		if(userAccount.enabled == null || !userAccount.enabled) {
			throw new UsernameNotFoundException("user disabled" + username);
		}
		List<SimpleGrantedAuthority> auth = List.of(new SimpleGrantedAuthority(userAccount.role != null ? userAccount.role : "ROLE_USER"));
		return User.withUsername(userAccount.username)
				.password(userAccount.password)
				.authorities(auth)
				.build();
	}
	
	public UserAccount createUser(String username, String rawPassword, String displayName, String role) {
		UserAccount user = new UserAccount();
		user.username = username;
		user.password = passwordEncoder.encode(rawPassword);
		user.displayName = displayName;
		user.role = role == null ? "ROLE_USER" : role;
		user.enabled = true;
		userDao.insert(user);
		return user;
	}

	public void regist(@Valid UserRegistrationForm registrationForm) {
		//パスワードが一致しない場合
		if(registrationForm.getPassword().equals(registrationForm.getConfirmPassword())) {
			throw new PasswordNotMatchException();
		}
		
		//重複チェック
		Optional<UserAccount> userAccount = userDao.findByUsername(registrationForm.getUsername());
		if(userAccount.isPresent()) {
			throw new UsernameAlreadyExsitsException(registrationForm.getUsername());
		}
		
		String encodePassword = passwordEncoder.encode(registrationForm.getPassword());
		
		UserAccount user = UserAccount.of(registrationForm.getUsername(), encodePassword, registrationForm.getDisplayName());
		userDao.insert(user);
	}
}

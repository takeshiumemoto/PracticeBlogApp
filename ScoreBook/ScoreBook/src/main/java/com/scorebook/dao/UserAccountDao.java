package com.scorebook.dao;

import java.util.Optional;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.scorebook.entity.UserAccount;

@Dao
@ConfigAutowireable
public interface UserAccountDao {

	@Select
	Optional<UserAccount> findById(Long id);
	
	@Select 
	Optional<UserAccount> findByUsername(String username);
	
	@Insert
	int insert(UserAccount user);
	
	@Update
	int update(UserAccount user);
	
	@Delete
	int delete(UserAccount user);
}

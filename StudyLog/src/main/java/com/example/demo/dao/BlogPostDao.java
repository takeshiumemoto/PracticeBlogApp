package com.example.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BlogPost;

@Dao
@ConfigAutowireable
@Repository
public interface BlogPostDao {

	@Select
	List<BlogPost> findAll();
	
	@Select
	BlogPost selectById(Long id);
	
	@Insert
	int insert(BlogPost post);
	
	@Update
	int update(BlogPost post);
	
	@Delete
	int delete(BlogPost post);
}

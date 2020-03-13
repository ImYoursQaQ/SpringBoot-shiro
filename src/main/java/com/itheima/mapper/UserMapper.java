package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

	public User findByName(String name);
	
	public User findById(Integer id);
}

package com.jade.sbp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jade.sbp.domain.User;

public interface UserMapper {
	@Select("select uname from User where uid=#{uid}")
	public String getUname(@Param("id") String uid) throws Exception;
	
	public User getLoginInfo(@Param("id") String id) throws Exception;
	
	@Select("select * from User limit 100")
	public List<User> getUsers();
	
	public List<User> getAllBoard() throws Exception;
	
	public void createJson(User user);
	
	public void delete(String id);

}
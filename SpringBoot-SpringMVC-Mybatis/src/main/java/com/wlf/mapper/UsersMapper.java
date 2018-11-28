package com.wlf.mapper;

import java.util.List;

import com.wlf.pojo.Users;

public interface UsersMapper {

	public void insertUser(Users users);
	
	List<Users> selectUsersAll();
	
}

/**
 * 
 */
package com.wlf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlf.mapper.UsersMapper;
import com.wlf.pojo.Users;
import com.wlf.service.UsersService;

/**
 * @author wlf
 *
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public void insertUser(Users users) {
		usersMapper.insertUser(users);

	}

	@Override
	public List<Users> findUserAll() {
		return this.usersMapper.selectUsersAll();
	}

}

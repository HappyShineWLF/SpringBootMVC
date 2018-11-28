/**
 * 
 */
package com.wlf.service;

import java.util.List;

import com.wlf.pojo.Users;

/**
 * @author wlf
 *
 */
public interface UsersService {
	void insertUser(Users users);

	List<Users> findUserAll();
}

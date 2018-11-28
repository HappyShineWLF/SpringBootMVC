/**
 * 
 */
package com.wlf.service;

import java.util.List;

import com.wlf.pojo.Tel;
import com.wlf.pojo.Users;

/**
 * @author wlf
 *
 */
public interface TelService {

	List<Tel> selectTel(String num);
}

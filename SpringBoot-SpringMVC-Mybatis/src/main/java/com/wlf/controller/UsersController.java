package com.wlf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wlf.pojo.Tel;
import com.wlf.pojo.Users;
import com.wlf.service.TelService;
import com.wlf.service.UsersService;

@Controller
@RequestMapping("/usersmanage")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private TelService telService;

	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		System.out.println(page);
		return page;
	}

	@RequestMapping("/addUser")
	public String addUser(Users users) {
		usersService.insertUser(users);
		return "ok";

	}

	/**
	 * 查询全部用户
	 */
	@RequestMapping("/findUserAll")
	public String findUserAll(Model model) {
		List<Users> list = this.usersService.findUserAll();
		model.addAttribute("list", list);
		return "showUsers";
	}
	
	/**
	 * 查询全部用户
	 */
	@RequestMapping("/selectTel")
	public String selectTel(Model model,String num) {
		List<Tel> list = this.telService.selectTel(num);
		System.out.println("表"+num);
		model.addAttribute("list", list);
		return "showUsers";
	}
	
}

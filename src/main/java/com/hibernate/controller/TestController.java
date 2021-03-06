package com.hibernate.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hibernate.entity.vo.UsersVo;
import com.hibernate.service.UserService;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
    private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public void createUser(@RequestParam("mobile") String mobile, @RequestParam("password") String password) {
		logger.info("createUser.userId: {}", userService.createUser(mobile, password));
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectUser", method = RequestMethod.GET)
	public UsersVo selectUser(@RequestParam("mobile") String mobile) {
		logger.info("selectUser: {}", new Date());
		return userService.selectUser(mobile);
	}
	
	@ResponseBody
	@RequestMapping(value = "/selectUserList", method = RequestMethod.GET)
	public List<UsersVo> selectUserList() {
		logger.info("selectUserList: {}", new Date());
		return userService.selectUserList();
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public int updateUser(@RequestParam("mobile") String mobile, 
			@RequestParam("userName") String userName) {
		logger.info("updateUser: {}", new Date());
		return userService.updateUser(mobile, userName);
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public void deleteUser(@RequestParam("mobile") String mobile) {
		logger.info("deleteUser: {}", new Date());
	}
	
}

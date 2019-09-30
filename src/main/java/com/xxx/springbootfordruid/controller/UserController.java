package com.xxx.springbootfordruid.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.springbootfordruid.log.ControllerLogAnnotation;
import com.xxx.springbootfordruid.model.User;
import com.xxx.springbootfordruid.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUserById")
	@ResponseBody
	@ControllerLogAnnotation(desc="xiong.xinxin")
	public Map<String,Object> getUserById(String userId){
		Map<String,Object> result = new HashMap<>();
		
		try{
			User user = userService.getUserById(userId);
			result.put("admin", user);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
}

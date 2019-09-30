package com.xxx.springbootfordruid.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.springbootfordruid.service.MultiThreadService;
import com.xxx.springbootfordruid.service.UserService;

@Controller
public class TestController {
	private Integer num = 0;
	@Autowired
	private MultiThreadService multiThreadService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String, Object> map) {
		map.put("hello", "oweoweoi");
		return "aa";
	}
	
	@RequestMapping(value = "/testMultiThread",method=RequestMethod.GET)
	@ResponseBody
	public void testMultiThread(@RequestParam(name="filePath",required=false,defaultValue="C:/Users/HP/Desktop/testMultiThread.txt") String filePath){
		System.out.println(num++);
		multiThreadService.dealFile(filePath);
	}
	
}

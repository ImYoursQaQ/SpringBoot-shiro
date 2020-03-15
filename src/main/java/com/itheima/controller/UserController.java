package com.itheima.controller;


import com.alibaba.fastjson.JSONObject;
import com.itheima.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 测试方法
	 */
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		System.out.println("UserController.hello()");
		return "ok";
	}

	@PostMapping("/json")
	@RequiresGuest
	@ResponseBody
	public String testJson(HttpServletRequest request) throws Exception{
		try (ServletInputStream inputStream = request.getInputStream()) {
			User o = JSONObject.parseObject(inputStream, User.class);
			logger.info("{}",o.toString());
		}
		return "ok";
	}

	@RequestMapping("/add")
//	@RequiresRoles(value = "admin")
	@RequiresPermissions(value = "add")
	public String add(){
		return "/user/add";
	}

	@RequestMapping("/update")
	@RequiresPermissions(value = "update")
	public String update(){
		return "/user/update";
	}

	@RequestMapping("/toLogin")
	public String toLogin(){
//		return "未登录，禁止访问！";
		return "/login";
	}

	@RequestMapping("/noAuth")
//	@ResponseBody
	public String noAuth(){
//		return "未授权，禁止访问！";
		return "/noAuth";
	}

	/**
	 * 测试thymeleaf
	 */
	@RequestMapping("/testThymeleaf")
	public String testThymeleaf(Model model){
		//把数据存入model
		model.addAttribute("name", "黑马程序员");
		//返回test.html
		return "/test";
	}

	/**
	 * 登录逻辑处理
	 */
	@RequestMapping("/login")
	public String login(String name,String password,Model model){
		System.out.println("name="+name);
		/**
		 * 使用Shiro编写认证操作
		 */
		//1.获取Subject
		Subject subject = SecurityUtils.getSubject();
		if (subject.isRemembered()){
			logger.info("{} has been remembered!",name);
		}else {
			logger.info("{} is new login",name);
		}

		//2.封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		token.setRememberMe(true);
		//3.执行登录方法
		try {
			subject.login(token);
			//登录成功
			//跳转到test.html
			return "redirect:/testThymeleaf";
		} catch (UnknownAccountException e) {
			//e.printStackTrace();
			//登录失败:用户名不存在
			model.addAttribute("msg", "用户名不存在");
			return "login";
		}catch (IncorrectCredentialsException e) {
			//e.printStackTrace();
			//登录失败:密码错误
			model.addAttribute("msg", "密码错误");
			return "login";
		}
	}
}

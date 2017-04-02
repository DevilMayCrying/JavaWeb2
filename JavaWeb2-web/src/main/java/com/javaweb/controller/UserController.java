package com.javaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.dataobject.eo.UserSearchCondition;
import com.javaweb.dataobject.po.User;
import com.javaweb.help.GsonHelp;
import com.javaweb.help.ResponseResult;
import com.javaweb.service.rbac.UserService;

@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	//用户列表接口
	@PostMapping("/list")
	public String login(@RequestBody UserSearchCondition UserSearchCondition){
		ResponseResult responseResult = null;
		try{
			List<User> list =  userService.listUser(UserSearchCondition);
			
			//Page page = new Page();
			
			responseResult = new ResponseResult(200,"获取用户信息成功",list);
		}catch(Exception e){
			responseResult = new ResponseResult(500,e.getMessage(),null);
		}
		return new GsonHelp().fromJsonDefault(responseResult);
	}
	
}
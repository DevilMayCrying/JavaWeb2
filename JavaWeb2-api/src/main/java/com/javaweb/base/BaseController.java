package com.javaweb.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.code.kaptcha.impl.DefaultKaptcha;
//import com.javaweb.config.hbase.HbaseHandleService;
import com.javaweb.config.websocket.WebSocketHandleService;
import com.javaweb.task.TaskService;
import com.javaweb.web.service.ModuleService;
import com.javaweb.web.service.RoleService;
import com.javaweb.web.service.UserService;

public class BaseController extends BaseTool {
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected RoleService roleService;
	
	@Autowired
	protected ModuleService moduleService;
	
	@Autowired
	protected WebSocketHandleService webSocketHandleService;
	
	@Autowired  
	protected TaskService taskService;
	
	@Autowired
	protected DefaultKaptcha defaultKaptcha;
	
	//@Autowired
	//protected HbaseHandleService hbaseHandleService;
	
}

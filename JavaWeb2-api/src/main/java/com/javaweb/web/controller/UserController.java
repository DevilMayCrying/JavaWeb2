package com.javaweb.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.base.BaseController;
import com.javaweb.base.BaseResponseResult;
import com.javaweb.base.BaseValidatedGroup;
import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.util.core.DateUtil;
import com.javaweb.util.entity.Page;
import com.javaweb.web.eo.TokenData;
import com.javaweb.web.eo.user.RoleInfoResponse;
import com.javaweb.web.eo.user.UserListRequest;
import com.javaweb.web.po.User;
import com.javaweb.web.service.UserService;

@RestController
@RequestMapping("/web/sys/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/list")
	public BaseResponseResult userList(HttpServletRequest request,@RequestBody UserListRequest userListRequest){
		TokenData tokenData = getTokenData(request);
		userListRequest.setLevel(tokenData.getUser().getLevel());
		Page page = userService.userList(userListRequest);
		return new BaseResponseResult(SystemConstant.SUCCESS,getMessage("user.list.success"),page);
	}
	
	@DeleteMapping("/delete/{userId}")
	public BaseResponseResult userDelete(@PathVariable("userId") String userId){
		userService.userDelete(userId);
		return new BaseResponseResult(SystemConstant.SUCCESS,getMessage("user.delete.success"),null);
	}
	
	@PostMapping("/add")
	public BaseResponseResult userAdd(HttpServletRequest request,@RequestBody @Validated({BaseValidatedGroup.add.class}) User user,BindingResult bindingResult){
		BaseResponseResult baseResponseResult = new BaseResponseResult();
		if(bindingResult.hasErrors()){
			baseResponseResult = new BaseResponseResult(SystemConstant.VALIDATE_ERROR,getValidateMessage(bindingResult),CommonConstant.EMPTY_VALUE);
		}else{
			TokenData tokenData = getTokenData(request);
			User currentUser = tokenData.getUser();
			user.setUserId(UUID.randomUUID().toString());
			user.setParentId(currentUser.getUserId());
			user.setLevel(currentUser.getLevel()+1);
			user.setCreateDate(DateUtil.getDefaultDate());
			user.setCreator(currentUser.getUserName());
			userService.userAdd(user);
			baseResponseResult = new BaseResponseResult(SystemConstant.SUCCESS,getMessage("user.add.success"),null);
		}
		return baseResponseResult;
	}
	
	@PutMapping("/modify")
	public BaseResponseResult userModify(HttpServletRequest request,@RequestBody @Validated({BaseValidatedGroup.update.class}) User user,BindingResult bindingResult){
		BaseResponseResult baseResponseResult = new BaseResponseResult();
		if(bindingResult.hasErrors()){
			baseResponseResult = new BaseResponseResult(SystemConstant.VALIDATE_ERROR,getValidateMessage(bindingResult),CommonConstant.EMPTY_VALUE);
		}else{
			TokenData tokenData = getTokenData(request);
			User currentUser = tokenData.getUser();
			user.setUpdateDate(DateUtil.getDefaultDate());
			user.setUpdater(currentUser.getUserName());
			userService.userModify(user);
			baseResponseResult = new BaseResponseResult(SystemConstant.SUCCESS,getMessage("user.modify.success"),null);
		}
		return baseResponseResult;
	}
	
	@GetMapping("/detail/{userId}")
	public BaseResponseResult userDetail(@PathVariable("userId") String userId){
		User user = userService.userDetail(userId);
		return new BaseResponseResult(SystemConstant.SUCCESS,getMessage("user.detail.success"),user);
	}
	
	@GetMapping("/userRoleInfo/{userId}")
	public BaseResponseResult userRoleInfo(@PathVariable("userId") String userId){
		List<RoleInfoResponse> list = userService.userRoleInfo(userId);
		return new BaseResponseResult(SystemConstant.SUCCESS,getMessage("user.userRoleInfo.success"),list);
	}
	
	@PostMapping("/roleAssignment/{userId}")
	public BaseResponseResult roleAssignment(@PathVariable("userId") String userId,@RequestBody List<String> list){
		Map<String,Object> map = new HashMap<>();
		map.put("userId",userId);
		map.put("list",list);
		userService.roleAssignment(map);
		return new BaseResponseResult(SystemConstant.SUCCESS,getMessage("user.roleAssignment.success"),null);
	}
	
}
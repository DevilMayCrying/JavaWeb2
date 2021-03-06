package com.javaweb.web.dao.ds1;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.mybatis.api.DaoForMySql;
import com.javaweb.web.po.UserRole;

@Mapper
public interface UserRoleDao extends DaoForMySql<UserRole> {
	
	public List<UserRole> getUserRoleByUserId(String userId);
	
}
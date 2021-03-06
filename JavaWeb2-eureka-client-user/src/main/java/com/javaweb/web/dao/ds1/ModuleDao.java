package com.javaweb.web.dao.ds1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.javaweb.mybatis.api.DaoForMySql;
import com.javaweb.web.eo.module.ModuleIdAndNameResponse;
import com.javaweb.web.eo.module.ModuleLevelAndOrdersResponse;
import com.javaweb.web.eo.module.ModuleListRequest;
import com.javaweb.web.eo.module.ModuleListResponse;
import com.javaweb.web.po.Module;
import com.javaweb.web.po.Role;
import com.javaweb.web.po.User;

@Mapper
public interface ModuleDao extends DaoForMySql<Module> {
	
	public List<Module> getModuleByModuleId(List<String> list);
	
	public List<ModuleListResponse> moduleList(ModuleListRequest moduleListRequest);
	
	public Long moduleListCount(ModuleListRequest moduleListRequest);
	
	public void moduleDelete(String moduleId);
	
	public Module moduleDetail(String moduleId);
	
	public ModuleLevelAndOrdersResponse getModuleLevelAndOrdersByParentId(String parentId);
	
	public ModuleLevelAndOrdersResponse getModuleLevelAndOrdersWithoutParentId();
	
	public List<ModuleIdAndNameResponse> getModuleIdAndNameList(Map<String,String> map);
	
	public List<Role> getAllRoleByModuleId(String moduleId);
	
	public List<User> getAllUserByModuleId(String moduleId);
	
	public void setModuleParentIdNull(Module module);
	
	public List<Module> getModuleByParentId(String parentId);
	
}
package cn.com.fqy.core.service;


import java.util.List;

import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseService;
import cn.com.fqy.core.model.SysPermission;
import cn.com.fqy.core.model.SysRolePermRel;


/**
 * SysRolePermRel 服务接口类
 */
public interface SysRolePermRelService extends BaseService{
	
	/**
	 * 删除该角色下所有关联的权限
	 */
	public ResultInfo<SysRolePermRel> deleteByRoleId(String roleId);
	
	/**
	 * 删除该权限关联的角色关系
	 */
	public ResultInfo<SysRolePermRel> deleteByPermId(String permId);
	
	public ResultInfo<SysRolePermRel> add(SysRolePermRel sysRolePermRel);
	
	public List<SysPermission> getAllRolePermissions(String[] roleIds);
	
	public List<SysPermission> getMenuList(String[] roleId);

	public List<SysPermission> getMenuList2(String[] roleId);
	
	/**
	 * 根据模块名获取操作权限
	 * @param modelName
	 * @return
	 * @throws Exception
	 */
	String getHandleByModel(String modelName) throws Exception;
}

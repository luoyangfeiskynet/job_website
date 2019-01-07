package cn.com.fqy.core.service;


import java.util.List;

import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseService;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.model.SysRole;
import cn.com.fqy.core.model.SysUser;
import cn.com.fqy.core.model.SysUserRoleRel;


/**
 * SysUserRoleRel 服务接口类
 */
public interface SysUserRoleRelService extends BaseService{	
	public ResultInfo<SysUserRoleRel> delete(String roleId,String userId);
	
	public ResultInfo<SysUserRoleRel> add(SysUserRoleRel sysUserRoleRel);
	
	public List<SysUserRoleRel> queryAll(Query q);
	public List<SysUserRoleRel> getByUserId(String userId);
	
	/**
	 * 根据角色id删除角色用户关联表记录
	 * @param roleId
	 */
	public ResultInfo<SysUserRoleRel> deleteByRoleId(String roleId);
	/**
	 * 根据用户id删除角色用户关联表记录
	 * @param roleId
	 */
	
	public ResultInfo<SysUserRoleRel> deleteByUserId(String userId);
	/**
	 * 根据用户id得到角色列表
	 * @param userId
	 */	
	public List<SysRole> getAllUserRole(String userId);
	/**
	 * 根据角色id获取用户列表
	 */
	public List<SysUser> getAllUser(String roleId);
}

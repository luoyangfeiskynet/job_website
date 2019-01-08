package cn.com.stone.core.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.stone.core.common.BaseDao;
import cn.com.stone.core.model.SysRole;

/**
 * SysRole 数据库处理类
 */
public interface SysRoleDao extends BaseDao<SysRole,String> {
	public SysRole getRoleByName(@Param("roleName") String roleName);
}

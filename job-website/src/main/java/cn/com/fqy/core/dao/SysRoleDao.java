package cn.com.fqy.core.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.fqy.core.common.BaseDao;
import cn.com.fqy.core.model.SysRole;

/**
 * SysRole 数据库处理类
 */
public interface SysRoleDao extends BaseDao<SysRole,String> {
	public SysRole getRoleByName(@Param("roleName") String roleName);
}

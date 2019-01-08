package cn.com.stone.core.service;


import java.util.List;

import cn.com.stone.common.Operator;
import cn.com.stone.common.ResultInfo;
import cn.com.stone.core.common.BaseService;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.model.SysRole;


/**
 * SysRole 服务接口类
 */
public interface SysRoleService extends BaseService{
	
	public PageFinder<SysRole> pageList(Query q);
	
	public ResultInfo<SysRole> addOrEditSysRole(SysRole sysRole);	

	public ResultInfo<SysRole> delete(String userId, Operator operator);
	
	public List<SysRole> queryAll(Query q);
	
	/**
	 * 根据id获得系统角色
	 * @param roleId
	 * @return
	 */
	public SysRole detail(String roleId);
	
	/**
	 * 批量删除
	 * @param sysUserIds
	 * @return
	 */
	public ResultInfo<SysRole> batchDelete(String[] sysRoleIds, Operator operator);
	/**
	 * 根据角色名获取角色id
	 * */
	public SysRole getRoleByName(String roleName);

    /**
     * 新增或者修改系统角色（替换方法addOrEditSysRole 控制 二级菜单权限）
     * @param sysRole 系统角色
     * @return
     */
    void addOrUpdateSysRole(SysRole sysRole)throws Exception;
}

package cn.com.fqy.core.service;



import java.util.List;
import java.util.Map;

import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseService;
import cn.com.fqy.core.common.PageFinder;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.model.SysPermission;


/**
 * SysPermission 服务接口类
 */
public interface SysPermissionService extends BaseService{
	
	public PageFinder<SysPermission> pageList(Query q);
	
	public ResultInfo<SysPermission> addOrEditSysPermission(SysPermission sysPermission);	
	
	/**
	 * 根据id获得系统权限
	 * @param permissionId
	 * @return
	 */
	public SysPermission detail(String permissionId);

	public ResultInfo<SysPermission> delete(String permissionId);
	/**
	 * 批量删除
	 * @param sysPermissionIds
	 * @return
	 */
	public ResultInfo<SysPermission> batchDelete(String[] sysPermissionIds);
	
	public List<SysPermission> list(Query q);
	
	/**
	 * 查询对应角色的菜单资源
	 * @param roleId
	 * @return
	 */
	public List<Map<String, Object>> getMenuList(String[] roleId);
}

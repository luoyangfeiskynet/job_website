package cn.com.fqy.core.service;

import java.util.List;

import cn.com.fqy.common.Operator;
import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseService;
import cn.com.fqy.core.common.PageFinder;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.model.SysUser;


/**
 * SysUser 服务接口类
 */
public interface SysUserService extends BaseService{
	
	public PageFinder<SysUser> pageList(Query q);
	
	public PageFinder<SysUser> pageList2(Query q);
	
	public ResultInfo<SysUser> addOrEditSysUser(SysUser sysUser);
	

	public ResultInfo<SysUser> delete(String userId, Operator operator);
	
	/**
	 * 根据id获得系统用户
	 * @param userId
	 * @return
	 */
	public SysUser detail(String userId);
	
	/**
	 * 批量删除
	 * @param sysUserIds
	 * @return
	 */
		
	public ResultInfo<SysUser> batchDelete(String[] sysUserIds, Operator operator);
	
	/**
	 * 根据用户名密码得到用户 
	 * @param loginName
	 * @param loginPassword
	 * @return
	 */	
	public SysUser getSysUser(String loginName, String loginPassword);
	
	/**
	 * 根据主键数组，查询并返回一组Auction对象
	 * 
	 * @param ids
	 *            主键数组，数组中的主键值应当无重复值，如有重复值时，则返回的列表长度可能小于传入的数组长度
	 * @return
	 */
	public List<SysUser> getSysUserByIds(String[] ids);
	
}

package cn.com.fqy.core.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.common.constants.Constant;
import cn.com.fqy.core.dao.SysUserRoleRelDao;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.model.SysRole;
import cn.com.fqy.core.model.SysUser;
import cn.com.fqy.core.model.SysUserRoleRel;
import cn.com.fqy.core.service.SysUserRoleRelService;




/**
 * SysUserRoleRel 服务实现类
 */
@Service
public class SysUserRoleRelServiceImpl implements SysUserRoleRelService{
	
	@Resource
	private SysUserRoleRelDao sysUserRoleRelDao;
	
	private ResultInfo<SysUserRoleRel> resultInfo = new ResultInfo<SysUserRoleRel>();

	@Override
	@Transactional
	public ResultInfo<SysUserRoleRel> delete(String roleId, String userId) {
		try{
			int count=sysUserRoleRelDao.delete(roleId,userId);
			if(count==1){
				resultInfo.setCode(Constant.SUCCESS);
			}else{
				resultInfo.setCode(Constant.FAIL);
				resultInfo.setMsg("未找到此用户，删除失败！");
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(e.getMessage());
		}
		return resultInfo;
	}

	@Override
	@Transactional
	public List<SysUserRoleRel> getByUserId(String userId) {		
		List<SysUserRoleRel> list = sysUserRoleRelDao.getByUserId(userId);
		return list;
	}
	
	@Override
	@Transactional
	public ResultInfo<SysUserRoleRel> add(SysUserRoleRel sysUserRoleRel) {
		try {
			if (sysUserRoleRel != null) {
				sysUserRoleRel.setCreateTime(new Date());
				sysUserRoleRelDao.add(sysUserRoleRel);
				resultInfo.setCode(Constant.SUCCESS);
				resultInfo.setData(sysUserRoleRel);
			} else {
				resultInfo.setCode(Constant.FAIL);
				resultInfo.setMsg("系统用户关联角色不能为空！");
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(e.getMessage());
		}
		return resultInfo;
	}

	@Override
	public List<SysUserRoleRel> queryAll(Query q) {
		return sysUserRoleRelDao.queryAll(q);
	}
	
	@Override
	@Transactional
	public ResultInfo<SysUserRoleRel> deleteByRoleId(String roleId) {
		try{
			int count=sysUserRoleRelDao.deleteByRoleId(roleId);
			if(count==1){
				resultInfo.setCode(Constant.SUCCESS);
			}else{
				resultInfo.setCode(Constant.FAIL);
				resultInfo.setMsg("未找到此用户，删除失败！");
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(e.getMessage());
		}
		return resultInfo;
	}
	@Override
	@Transactional
	public ResultInfo<SysUserRoleRel> deleteByUserId(String userId) {
		try{
			int count=sysUserRoleRelDao.deleteByUserId(userId);
			if(count==1){
				resultInfo.setCode(Constant.SUCCESS);
			}else{
				resultInfo.setCode(Constant.FAIL);
				resultInfo.setMsg("未找到此角色，删除失败！");
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(e.getMessage());
		}
		return resultInfo;
	}

	@Override
	public List<SysRole> getAllUserRole(String userId) {		
		return sysUserRoleRelDao.getAllUserRole(userId);
	}

	@Override
	public List<SysUser> getAllUser(String roleId) {
		return sysUserRoleRelDao.getAllUser(roleId);
	}
	
}

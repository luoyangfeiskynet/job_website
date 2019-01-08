package cn.com.stone.controller.mgt;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.stone.common.Operator;
import cn.com.stone.common.ResultInfo;
import cn.com.stone.common.constants.Constant;
import cn.com.stone.common.util.ECMd5Utils;
import cn.com.stone.core.common.BaseController;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.model.SysRole;
import cn.com.stone.core.model.SysUser;
import cn.com.stone.core.model.SysUserRoleIds;
import cn.com.stone.core.service.SysRoleService;
import cn.com.stone.core.service.SysUserRoleRelService;
import cn.com.stone.core.service.SysUserService;

@Controller
@RequestMapping("sysUser")
public class SysUserController extends BaseController {
	
	@Resource
	public SysUserService sysUserService;
	@Resource
	public SysRoleService sysRoleService;
	@Resource
	public SysUserRoleRelService sysUserRoleRelService;
	
	/*
	 * 修改密码操作
	 */
	@RequestMapping("updatePassword")
	@ResponseBody
	public ResultInfo<SysUser> editPassword(SysUser sysUser,String oldPassword,HttpServletRequest request) {
		ResultInfo<SysUser> resultInfo=new ResultInfo<SysUser>();
		if(getLoginSysUser(request.getParameter("userId"))!=null){
			SysUser user=sysUserService.detail(sysUser.getUserId());
			if(user.getPassword().equals(ECMd5Utils.crypt(oldPassword))){
				user.setPassword(sysUser.getPassword());
				resultInfo=sysUserService.addOrEditSysUser(user);
			}else{
				resultInfo.setCode("3");
				resultInfo.setMsg("原密码输入不正确，请重新输入！");
			}
			
		}else{
			resultInfo.setCode("2");
			resultInfo.setMsg("登录超时，请重新登录！");
		}
		return resultInfo;
		
	}
	/*
	 * 添加或修改系统用户
	 */
	@RequestMapping("addOrEditSysUser")
	@ResponseBody
	public ResultInfo<SysUser> addOrEditSysUser(SysUserRoleIds sysUserRoleIds) {
		ResultInfo<SysUser> resultInfo  = new ResultInfo<>();
		//操作人
		Operator op = getOperator();
		SysUser sysUser = new SysUser();
		sysUser.setUserId(sysUserRoleIds.getUserId());
		sysUser.setUserName(sysUserRoleIds.getUserName());
		sysUser.setRealName(sysUserRoleIds.getRealName());
		sysUser.setIsAvailable(sysUserRoleIds.getIsAvailable());
		sysUser.setMemo(sysUserRoleIds.getMemo());
		sysUser.setPassword(sysUserRoleIds.getPassword());
		sysUser.setMobilePhone(sysUserRoleIds.getMobilePhone());
		sysUser.setSex(sysUserRoleIds.getSex());
		sysUser.setDeptId(sysUserRoleIds.getDeptId());
		if (sysUserRoleIds.getSysRole()!=null) {
			String[] roleIds = sysUserRoleIds.getSysRole();
			List<SysRole> sysRoles = new ArrayList<SysRole>();
			for(int i=0;i<roleIds.length;i++){
				SysRole sysRole = new SysRole();
				sysRole.setRoleId(roleIds[i]);
				sysRoles.add(sysRole);
			}
			sysUser.setSysRole(sysRoles);
		}else {
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg("请先选择角色");
			return resultInfo;
		}
		
		if(op != null){
			sysUser.setOperatorId(op.getOperatorId());
			sysUser.setOperatorType(op.getOperatorType());
		}
		resultInfo  = sysUserService.addOrEditSysUser(sysUser);		
		return resultInfo;		
	}
	
	/*
	 * 删除系统用户
	 */
	@RequestMapping("deleteSysUser")
	@ResponseBody
	public ResultInfo<SysUser> deleteSysUser(@RequestParam("userId") String userId) {
		return sysUserService.delete(userId,getOperator());
	}
	
	/*
	 * 分页展示系统用户
	 */
	@RequestMapping("getSysUserList")
	@ResponseBody
	public PageFinder<SysUser> getSysUserList(@ModelAttribute("sysUser") SysUser sysUser,Query query) {	
		sysUser.setIsDeleted(0);
		sysUser.setUserId(null);
		Query q = new Query(query.getPageNo(),query.getPageSize(),sysUser);
		return sysUserService.pageList2(q);
		
	}
	/*
	 * 根据角色获取用户列表
	 */
	@RequestMapping("getSysUserListByRole")
	@ResponseBody
	public List<SysUser> getSysUserListByRole(@RequestParam("roleName") String roleName) {	
		SysRole sysRole=sysRoleService.getRoleByName(roleName);
		return sysUserRoleRelService.getAllUser(sysRole.getRoleId());
	}
	
	/*
	 * 批量删除系统参数组
	 */
	@RequestMapping("batchDelete")
	@ResponseBody
	public ResultInfo<SysUser> batchDelete(@RequestParam("sysUserIds") String [] sysUserIds) {
		return sysUserService.batchDelete(sysUserIds,getOperator());
	}
	
	/*
	 * 详情
	 */
	@RequestMapping("detail")
	@ResponseBody
	public SysUser detail(@RequestParam("userId") String userId) {
		return sysUserService.detail(userId);
	}
}

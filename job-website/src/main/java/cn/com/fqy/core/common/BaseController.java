package cn.com.fqy.core.common;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import cn.com.fqy.common.Operator;
import cn.com.fqy.common.util.ECCustomerDateEditor;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.model.SysRole;
import cn.com.fqy.core.model.SysUser;
import cn.com.fqy.core.model.SysUserRoleRel;
import cn.com.fqy.core.service.SysParamService;
import cn.com.fqy.core.service.SysRoleService;
import cn.com.fqy.core.service.SysUserRoleRelService;

public class BaseController {

	@Resource
	HttpServletRequest request;
	@Resource
	private SysParamService sysParamService;
	@Resource
	private SysUserRoleRelService sysUserRoleRelService;
	@Resource
	private SysRoleService sysRoleService;
	@InitBinder    
	public void initBinder(WebDataBinder binder) {    
		binder.registerCustomEditor(Date.class, new ECCustomerDateEditor());
	}
	/**
	 * 取HttpSession对象
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return request.getSession();
	}

	/**
	 * 设置用户的登录信息
	 * 
	 * @Title: setLoginSysUser
	 * @Description: TODO
	 * @param request
	 * @param sysUser
	 * @return
	 */
	public static boolean setLoginSysUser(HttpServletRequest request, SysUser sysUser) {
		try {
//			request.getSession().setAttribute(ECMgtConstant.SESSION_KEY_OF_LOGIN_SYS_USER, sysUser);
			SysUserMapSingleton.getInstance().saveUser(sysUser.getUserId(), sysUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 取已登录的系统人员用户对象（数据来自session）
	 * 
	 * @return
	 */
	public SysUser getLoginSysUser(String userId) {
		SysUser sysUser = null;
		HttpSession session = getSession();
		if (session != null) {
//			sysUser = (SysUser) session.getAttribute(ECMgtConstant.SESSION_KEY_OF_LOGIN_SYS_USER); // 从session中取已登录的系统人员用户对象
			sysUser = (SysUser) SysUserMapSingleton.getInstance().getSysUserByUserId(userId);
		}
		return sysUser;
	}
	/**
	 * 设置用户的角色是否含系统管理员的标识信息
	 * 
	 * @Title: setLoginSysUser
	 * @Description: TODO
	 * @param request
	 * @param sysUser
	 * @return
	 */
	public boolean setLoginSysUserRoleAdmin(HttpServletRequest request,SysUser sysUser) {
		try {
			Integer roleAdminTag=0;
			//判断当前登录用户的角色是不是系统管理员
			if(sysUser!=null){
				List<SysUserRoleRel> list=sysUserRoleRelService.getByUserId(sysUser.getUserId());
				if(list!=null&&list.size()>0){
					SysRole sysRole=new SysRole();
					sysRole.setRoleName("系统管理员");
					List<SysRole> roleList=sysRoleService.queryAll(new Query(sysRole));
					if(roleList!=null&&roleList.size()>0){
						sysRole=roleList.get(0);
						for(SysUserRoleRel surr:list){
							if(surr.getRoleId().equals(sysRole.getRoleId())){
								roleAdminTag=1;
							}
						}
					}
				}
			}
			request.getSession().setAttribute(ECMgtConstant.SESSION_KEY_OF_LOGIN_SYS_ROLE_ADMIN_TAG, roleAdminTag);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 取已登录的系统人员用户角色是否含系统管理员的标识信息（数据来自session）
	 * 
	 * @return
	 */
	public Integer getLoginSysUserRoleAdmin() {
		Integer roleAdminTag=0;
		HttpSession session = getSession();
		if (session != null) {
			roleAdminTag = (Integer) session.getAttribute(ECMgtConstant.SESSION_KEY_OF_LOGIN_SYS_ROLE_ADMIN_TAG); // 从session中取已登录的系统人员用户对象
		}
		return roleAdminTag;
	}
	/**
	 * 移除session 属性
	 * 
	 * @Title: removeSessionAttribut
	 * @Description: TODO
	 * @param request
	 * @param key
	 */
	public static void removeSessionAttribut(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}

	/**
	 * 移除登陆用户
	 * 
	 * @Title: removeSessionAttribut
	 * @Description: TODO
	 * @param request
	 * @param key
	 */
	public static void removeSessionUser(HttpServletRequest request) {
		removeSessionAttribut(request, ECMgtConstant.SESSION_KEY_OF_LOGIN_SYS_USER);

	}

	/**
	 * 将系统平台人员用户对象，转为通用操作员对象
	 * 
	 * @param sysUser
	 * @return
	 */
	public Operator convertSysUser2Operator(SysUser sysUser) {
		Operator op = null;
		if (sysUser != null) {
			op = new Operator(ECCoreConstant.OPERATOR_TYPE_SYS_USER, sysUser.getUserId(), sysUser.getUserName(),sysUser.getRealName(),sysUser.getMobilePhone());
		}
		return op;
	}

	/**
	 * 取通用操作员对象（数据来自session中的SysUser对象，并转为Operator对象）
	 * 
	 * @return
	 */
	public Operator getOperator() {
		return convertSysUser2Operator(getLoginSysUser(request.getParameter("userId")));
	}

	public HttpServletRequest getRequest() {
		return request;
	}

}

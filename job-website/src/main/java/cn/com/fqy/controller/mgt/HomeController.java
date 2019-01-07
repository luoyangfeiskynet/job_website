package cn.com.fqy.controller.mgt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fqy.common.PermissionListSingleton;
import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.common.SessionUtil;
import cn.com.fqy.common.constants.Constant;
import cn.com.fqy.common.util.ECMd5Utils;
import cn.com.fqy.core.common.BaseController;
import cn.com.fqy.core.common.ECMgtConstant;
import cn.com.fqy.core.model.SysPermission;
import cn.com.fqy.core.model.SysRole;
import cn.com.fqy.core.model.SysUser;
import cn.com.fqy.core.model.SysUserRoleRel;
import cn.com.fqy.core.service.SysPermissionService;
import cn.com.fqy.core.service.SysRolePermRelService;
import cn.com.fqy.core.service.SysRoleService;
import cn.com.fqy.core.service.SysUserRoleRelService;
import cn.com.fqy.core.service.SysUserService;
import cn.com.fqy.vo.SysUserVo;

@Controller
@RequestMapping
public class HomeController extends BaseController {

	@Resource
	public SysUserService sysUserService;
	@Resource
	public SysRoleService sysRoleService;
	@Resource
	private SysUserRoleRelService sysUserRoleRelService;
	@Resource
	private SysPermissionService sysPermissionService;
	@Resource
	private SysRolePermRelService sysRolePermRelService;

	@RequestMapping("index")
	public String main() {
		return "index";
	}
	@RequestMapping("login")
	@ResponseBody
	public ResultInfo<SysUserVo> login(String loginName, String loginPassword, HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) {
		ResultInfo<SysUserVo> result = new ResultInfo<>();
		if (loginPassword != null) {
			loginPassword = ECMd5Utils.crypt(loginPassword);
		}
		// 查询用户是否存在
		SysUser sysUser = sysUserService.getSysUser(loginName, loginPassword);
		// 用户被删除则不让登录
		if (sysUser != null && Constant.DEL_STATE_YES != sysUser.getIsDeleted() && sysUser.getIsAvailable() != 0) {// 0:不可用

			// sysUser保存到session
			setLoginSysUser(request, sysUser);
			setLoginSysUserRoleAdmin(request, sysUser);
			// 加载资源(权限)
			if (sysUser.getSysRole() != null && sysUser.getSysRole().size() > 0) {
				List<SysRole> role = sysUser.getSysRole();
				// role保存到session
				SessionUtil.setDataToSession(request, ECMgtConstant.SESSION_KEY_OF_LOGIN_SYS_ROLE, role);
				// roleId保存到session
				SessionUtil.setDataToSession(request, ECMgtConstant.SESSION_KEY_OF_LOGIN_SYS_ROLEID, role);
				PermissionListSingleton perListSlt = null;
				String[] roleIds = new String[role.size()];
				for (int i = 0; i < role.size(); i++) {
					roleIds[i] = role.get(i).getRoleId();
					// 存单例模式
					perListSlt = PermissionListSingleton.getInstance(roleIds[i].toString());
					List<SysPermission> perList = sysRolePermRelService.getAllRolePermissions(roleIds);

					// 保存角色权限列表
					perListSlt.setPerList(perList);
					perListSlt.setPerUrlMap(perList);
					sysUser.getSysRole().get(i).setPermissionIds(roleIds);
					sysUser.getSysRole().get(i).setPerList(perList);
				}
				List<Map<String, Object>> menuList = getMenuList(roleIds, request);
				SysUserVo sysUserVo = new SysUserVo();
				sysUserVo.setPermissionTree(menuList);
				sysUserVo.setRoleName(role.get(0).getRoleName());
				sysUserVo.setUserName(sysUser.getRealName());
				sysUserVo.setUserId(sysUser.getUserId());
				sysUserVo.setIsAdmin(sysUser.getFlag());
				result.setCode(Constant.SUCCESS);
				result.setData(sysUserVo);
			}else {
				result.setCode(Constant.FAIL);
				result.setMsg("用户身份信息无法识别");
			}
			return result;
		} else {
			result.setCode(Constant.FAIL);
			result.setMsg("用户名或者密码错误");
			return result;
		}
	}

	/**
	 * 左菜单
	 * 
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/leftPage")
	@ResponseBody
	public List<Map<String, Object>> leftPage(HttpServletResponse response, HttpServletRequest request, ModelMap model)
			throws Exception {
		SysUser sysUser = getLoginSysUser(request.getParameter("userId"));
		if (sysUser == null) {
			return null;
		}
		// 加载资源(权限)
		List<SysUserRoleRel> sysUserRoleRel = sysUserRoleRelService.getByUserId(sysUser.getUserId());
		String[] roleIds = new String[sysUserRoleRel.size()];
		for (int i = 0; i < sysUserRoleRel.size(); i++) {
			roleIds[i] = sysUserRoleRel.get(i).getRoleId();
		}
		return getMenuList(roleIds, request);
	}

	@RequestMapping("loginOut")
	@ResponseBody
	public ResultInfo<String> loginOut(HttpServletRequest request) {
		ResultInfo<String> result = new ResultInfo<>();
		HttpSession session = request.getSession();
		removeSessionUser(request);
		if (session != null) {
			session.invalidate();
		}
		result.setCode(Constant.SUCCESS);
		return result;
	}

	public List<Map<String, Object>> getMenuList(String[] roleId, HttpServletRequest request) {
		List<SysPermission> sysPermissionList = sysRolePermRelService.getMenuList(roleId);
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		// 资源根据层级分组
		List<SysPermission> superResourceList = new ArrayList<SysPermission>();
		List<SysPermission> seResourceList = new ArrayList<SysPermission>();
		List<SysPermission> thResourceList = new ArrayList<SysPermission>();
		if (sysPermissionList != null && sysPermissionList.size() > 0) {
			Collections.sort(sysPermissionList, new ComparatorSysPermission());
			for (SysPermission temp : sysPermissionList) {
				if (temp.getLevel() == 1) {
					superResourceList.add(temp);
				} else if (temp.getLevel() == 2) {
					seResourceList.add(temp);
				} else {
					thResourceList.add(temp);
				}
			}
		}
		// 一级菜单
		for (SysPermission one : superResourceList) {
			Map<String, Object> viewSysPermission = new HashMap<String, Object>();
			viewSysPermission.put("path", "/"+one.getPermResource());
			// 二级菜单
			List<Map<String, Object>> twoList = new ArrayList<Map<String, Object>>();
			for (SysPermission two : seResourceList) {
				Map<String, Object> towMap = new HashMap<String, Object>();
				if (two.getParentId().equals(one.getPermId())) {
					towMap.put("path",two.getPermResource());
					twoList.add(towMap);
				}
				// 三级菜单
				List<Map<String, Object>> thrList = new ArrayList<Map<String, Object>>();
				for (SysPermission thr : thResourceList) {
					Map<String, Object> thrMap = new HashMap<String, Object>();
					if (thr.getParentId().equals(two.getPermId())) {
						thrMap.put("path", thr.getPermResource());
					}
				}
				towMap.put("children", thrList);
			}
			viewSysPermission.put("children", twoList);
			resultList.add(viewSysPermission);
		}
		return resultList;

	}

	/*
	 * 类型排序
	 */
	class ComparatorSysPermission implements Comparator<SysPermission> {

		@Override
		public int compare(SysPermission obj1, SysPermission obj2) {
			if (obj1.getRanking() != null && obj2.getRanking() != null) {
				return obj1.getRanking().compareTo(obj2.getRanking());
			} else {
				return 1;
			}
		}

	}
}
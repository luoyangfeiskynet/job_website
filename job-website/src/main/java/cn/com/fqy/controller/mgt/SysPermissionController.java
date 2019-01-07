package cn.com.fqy.controller.mgt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fqy.common.Operator;
import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseController;
import cn.com.fqy.core.common.PageFinder;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.model.SysPermission;
import cn.com.fqy.core.service.SysPermissionService;
import cn.com.fqy.core.service.SysRolePermRelService;

@Controller
@RequestMapping("/sysPermission")
public class SysPermissionController extends BaseController {
	@Resource
	public SysPermissionService sysPermissionService;
	@Resource
	public SysRolePermRelService sysRolePermRelService;

	/*
	 * 添加或修改系统权限
	 */
	@RequestMapping("/addOrEditSysPermission")
	@ResponseBody
	public ResultInfo<SysPermission> addOrEditSysPermission(SysPermission sysPermission) {
		//操作人
		Operator op = getOperator();
		if(op != null){
			sysPermission.setOperatorId(op.getOperatorId());
			sysPermission.setOperatorType(op.getOperatorType());
		}
		if (sysPermission.getPermType()==null) {
			sysPermission.setPermType(0);
		}
		ResultInfo<SysPermission> resultInfo = sysPermissionService.addOrEditSysPermission(sysPermission);
		return resultInfo;		
	}
	
	/*
	 * 删除系统权限
	 */
	@RequestMapping("deleteSysPermission")
	@ResponseBody
	public ResultInfo<SysPermission> deleteSysPermission(@RequestParam("permissionId") String permissionId) {
		return sysPermissionService.delete(permissionId);
	}
	
	/*
	 * 分页展示系统权限
	 */
	@RequestMapping("getSysPermissionList")
	@ResponseBody
	public PageFinder<SysPermission> getSysUserList(@ModelAttribute("sysPermission") SysPermission sysPermission,
			Query query) {				
		Query q = new Query(query.getPageNo(),query.getPageSize(),sysPermission);
		return sysPermissionService.pageList(q);
		
	}
	/*
	 * 批量删除系统权限
	 */
	@RequestMapping("batchDelete")
	@ResponseBody
	public ResultInfo<SysPermission> batchDelete(@RequestParam("sysPermissionIds") String [] sysPermissionIds) {
		return sysPermissionService.batchDelete(sysPermissionIds);
	}
	
	/**
	 * 内部url权限
	 * 
	 * @param roleId
	 * @param request
	 * @return
	 */
	@RequestMapping("getSysPermssionTree")
	@ResponseBody
	public List<Map<String, Object>> getSysPermssionTree(HttpServletRequest request) {
		String basePath = request.getParameter("appPath");
		if (basePath == null) {
			basePath = "";
		}
		SysPermission sysPermissin = new SysPermission();
		sysPermissin.setIsAvailable(1);
		Query q = new Query(sysPermissin);
		List<SysPermission> sysPermissionList = sysPermissionService.list(q);
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
			viewSysPermission.put("id", one.getPermId());
			viewSysPermission.put("name", one.getMenuName());
			viewSysPermission.put("iconName", one.getIconName());
			viewSysPermission.put("link", basePath + one.getPermResource());
			viewSysPermission.put("sort", one.getRanking());
			viewSysPermission.put("parentId", "#");
			// 二级菜单
			List<Map<String, Object>> twoList = new ArrayList<Map<String, Object>>();
			for (SysPermission two : seResourceList) {
				Map<String, Object> towMap = new HashMap<String, Object>();
				if (two.getParentId().equals(one.getPermId())) {
					towMap.put("id", two.getPermId());
					towMap.put("name", two.getMenuName());
					towMap.put("iconName", two.getIconName());
					towMap.put("link", basePath + two.getPermResource());
					towMap.put("sort", two.getRanking());
					towMap.put("parentId", two.getParentId());
					twoList.add(towMap);
				}
				// 三级菜单
				List<Map<String, Object>> thrList = new ArrayList<Map<String, Object>>();
				for (SysPermission thr : thResourceList) {
					Map<String, Object> thrMap = new HashMap<String, Object>();
					if (thr.getParentId().equals(two.getPermId())) {
						thrMap.put("id", thr.getPermId());
						thrMap.put("name", thr.getMenuName());
						thrMap.put("iconName", thr.getIconName());
						thrMap.put("link", thr.getPermResource());
						thrMap.put("sort", thr.getRanking());
						thrMap.put("parentId", thr.getParentId());
						thrList.add(thrMap);
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
	 * 根据角色id获取权限列表
	 * 
	 */
	@RequestMapping("getSysPermissionByRoleId")
	@ResponseBody
	public String[] getSysPermissionByRoleId(String[] roleIds) {
		List<SysPermission> list = sysRolePermRelService.getAllRolePermissions(roleIds);
		String[] permids = new String[list.size()];
		for(int i=0;i<list.size();i++) {
			permids[i] = list.get(i).getPermId();
		}
		return permids;
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
	
	/*
	 * 详情
	 */
	@RequestMapping("detail")
	@ResponseBody
	public  SysPermission detail(@RequestParam("permId") String permId) {
		return sysPermissionService.detail(permId);
	}
}

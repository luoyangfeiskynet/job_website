package cn.com.fqy.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/** 
 * SysUser 数据返回类
 */
public class SysUserVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2323922315871463692L;
	//权限树
	private List<Map<String, Object>> permissionTree;
	//用户名
	private String userName;
	//角色名称
	private String roleName;
	//用户id
	private String userId;
	//是否超级管理员
	private String isAdmin;
	public List<Map<String, Object>> getPermissionTree() {
		return permissionTree;
	}
	public void setPermissionTree(List<Map<String, Object>> permissionTree) {
		this.permissionTree = permissionTree;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
}

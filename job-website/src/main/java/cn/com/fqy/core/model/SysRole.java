package cn.com.fqy.core.model;

import java.util.Date;
import java.util.List;

import cn.com.fqy.common.Entity;

/** 
 * SysRole 数据实体类
 */
public class SysRole extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
	private String roleId;
	private String roleName;
	private String memo;
	private Integer isAvailable;
	private Integer isDeleted;
	private Date createTime;
	// 时间范围起（查询用）
	private Date createTimeStart;
	// 时间范围止（查询用）
	private Date createTimeEnd;	
	private Date updateTime;
	// 时间范围起（查询用）
	private Date updateTimeStart;
	// 时间范围止（查询用）
	private Date updateTimeEnd;	
	private Integer operatorType;
	private String operatorId;
	//权限集合id
	private String[] permissionIds;
	//权限集合
	private List<SysPermission> perList;
	/*Auto generated properties end*/
	
	
	
	/*Customized properties start*/
	
	/*Customized properties end*/
	
	
	
	/*Auto generated methods start*/
	
	@Override
	public String getPK(){
		return roleId;
	}
	
	public String getRoleId(){
		return roleId;
	}
	
	public void setRoleId(String roleId){
		this.roleId = roleId;
	}
	
	public String getRoleName(){
		return roleName;
	}
	
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
	public String getMemo(){
		return memo;
	}
	
	public void setMemo(String memo){
		this.memo = memo;
	}
	
	public Integer getIsAvailable(){
		return isAvailable;
	}
	
	public void setIsAvailable(Integer isAvailable){
		this.isAvailable = isAvailable;
	}
	
	public Integer getIsDeleted(){
		return isDeleted;
	}
	
	public void setIsDeleted(Integer isDeleted){
		this.isDeleted = isDeleted;
	}
	
	public Date getCreateTime(){
		return createTime;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public Date getCreateTimeStart(){
		return createTimeStart;
	}
	
	public void setCreateTimeStart(Date createTimeStart){
		this.createTimeStart = createTimeStart;
	}
	
	public Date getCreateTimeEnd(){
		return createTimeEnd;
	}
	
	public void setCreateTimeEnd(Date createTimeEnd){
		this.createTimeEnd = createTimeEnd;
	}	
	
	public Date getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTimeStart(){
		return updateTimeStart;
	}
	
	public void setUpdateTimeStart(Date updateTimeStart){
		this.updateTimeStart = updateTimeStart;
	}
	
	public Date getUpdateTimeEnd(){
		return updateTimeEnd;
	}
	
	public void setUpdateTimeEnd(Date updateTimeEnd){
		this.updateTimeEnd = updateTimeEnd;
	}	
	
	public Integer getOperatorType(){
		return operatorType;
	}
	
	public void setOperatorType(Integer operatorType){
		this.operatorType = operatorType;
	}
	
	public String getOperatorId(){
		return operatorId;
	}
	
	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}
	
	
	/*Auto generated methods end*/
	
	
	
	/*Customized methods start*/
	
	/*Customized methods end*/
	
	
	public String[] getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String[] permissionIds) {
		this.permissionIds = permissionIds;
	}

	public List<SysPermission> getPerList() {
		return perList;
	}

	public void setPerList(List<SysPermission> perList) {
		this.perList = perList;
	}

	@Override
	public String toString() {
		return "SysRole ["
		 + "roleId = " + roleId + ", roleName = " + roleName + ", memo = " + memo + ", isAvailable = " + isAvailable
		 + ", isDeleted = " + isDeleted + ", createTime = " + createTime + ", createTimeStart = " + createTimeStart + ", createTimeEnd = " + createTimeEnd + ", updateTime = " + updateTime + ", updateTimeStart = " + updateTimeStart + ", updateTimeEnd = " + updateTimeEnd + ", operatorType = " + operatorType
		 + ", operatorId = " + operatorId
		+"]";
	}
}

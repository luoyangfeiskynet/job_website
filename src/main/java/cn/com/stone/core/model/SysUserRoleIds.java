package cn.com.stone.core.model;

import java.util.Date;

import cn.com.stone.common.Entity;



/**
 * SysUser 数据库实体类
 */
public class SysUserRoleIds extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	//用户id
	private String userId;
	//用户名
	private String userName;
	//密码
	private String password;
	//真实姓名
	private String realName;
	//性别
	private String sex;
	//email
	private String email;
	//手机
	private String mobilePhone;
	//最近登陆时间
	private Date lastLoginTime;
	//所属部门id
	private String deptId;
	//备注
	private String memo;
	//账户是否可用（1、可用，0、不可用，默认1）
	private Integer isAvailable;
	//是否已删除（逻辑删除，1、已删除，0、未删除，默认0）
	private Integer isDeleted;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//操作人类型（0、系统自动操作，1、平台人员操作，2、商家人员操作，3、会员操作）
	private Integer operatorType;
	//操作人id（根据操作人类型会对应不同的表记录）
	private String operatorId;
	
	private String[] sysRole;
	
	@Override
	public String getPK(){
		return userId;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	public String getRealName(){
		return realName;
	}
	
	public void setRealName(String realName){
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getMobilePhone(){
		return mobilePhone;
	}
	
	public void setMobilePhone(String mobilePhone){
		this.mobilePhone = mobilePhone;
	}
	public Date getLastLoginTime(){
		return lastLoginTime;
	}
	
	public void setLastLoginTime(Date lastLoginTime){
		this.lastLoginTime = lastLoginTime;
	}
	
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
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
	public Date getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
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

	public String[] getSysRole() {
		return sysRole;
	}

	public void setSysRole(String[] sysRole) {
		this.sysRole = sysRole;
	}
}

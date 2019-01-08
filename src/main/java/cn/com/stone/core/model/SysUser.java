package cn.com.stone.core.model;

import java.util.Date;
import java.util.List;

import cn.com.stone.common.Entity;

/** 
 * SysUser 数据实体类
 */
public class SysUser extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
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
	//手机
	private String mobilePhone;
	//备注
	private String memo;
	//账户是否可用（1、可用，0、不可用，默认1）
	private Integer isAvailable;
	//是否已删除（逻辑删除，1、已删除，0、未删除，默认0）
	private Integer isDeleted;
	//所属部门id
	private String deptId;
	//创建时间
	private Date createTime;
	//创建时间 时间范围起（查询用）
	private Date createTimeStart;
	//创建时间 时间范围止（查询用）
	private Date createTimeEnd;	
	//更新时间
	private Date updateTime;
	//更新时间 时间范围起（查询用）
	private Date updateTimeStart;
	//更新时间 时间范围止（查询用）
	private Date updateTimeEnd;	
	//操作人类型（0、系统自动操作，1、平台人员操作，2、商家人员操作，3、会员操作）
	private Integer operatorType;
	//操作人id（根据操作人类型会对应不同的表记录）
	private String operatorId;
	private List<SysRole> sysRole;
	private String flag;
	/*Auto generated properties end*/
	
	
	
	/*Customized properties start*/
	
	/*Customized properties end*/
	
	
	
	/*Auto generated methods start*/
	
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

	public String getMobilePhone(){
		return mobilePhone;
	}
	
	public void setMobilePhone(String mobilePhone){
		this.mobilePhone = mobilePhone;
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
	
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
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
	
	public List<SysRole> getSysRole() {
		return sysRole;
	}
	
	public void setSysRole(List<SysRole> sysRole) {
		this.sysRole = sysRole;
	}
	
	/*Auto generated methods end*/
	
	
	
	/*Customized methods start*/
	
	/*Customized methods end*/
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "SysUser ["
		 + "userId = " + userId + ", userName = " + userName + ", password = " + password + ", realName = " + realName
		 + ", sex = " + sex + ", mobilePhone = " + mobilePhone + ", memo = " + memo + ", isAvailable = " + isAvailable
		 + ", isDeleted = " + isDeleted + ", createTime = " + createTime + ", createTimeStart = " + createTimeStart + ", createTimeEnd = " + createTimeEnd + ", updateTime = " + updateTime + ", updateTimeStart = " + updateTimeStart + ", updateTimeEnd = " + updateTimeEnd + ", operatorType = " + operatorType
		 + ", operatorId = " + operatorId
		+"]";
	}

}

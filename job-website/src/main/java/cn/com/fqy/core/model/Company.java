package cn.com.fqy.core.model;

import java.util.Date;

import cn.com.fqy.common.Entity;

/** 
 * 企业服务 数据实体类
 */
public class Company extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
	//公司ID
	private String companyId;
	//公司名称
	private String companyName;
	//公司简介
	private String companyBrief;
	//服务内容
	private String companyContent;
	//公司图片
	private String companyPic;
	//是否可用(0不可用 1 可用 默认0 )
	private Integer isAvailable;
	//是否删除(0未删除 1 删除 默认0)
	private Integer isDeleted;
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
	//操作人ID
	private String operatorId;
	//操作人类型
	private Integer operatorType;
	
	/*Auto generated properties end*/
	
	
	
	/*Customized properties start*/
	
	/*Customized properties end*/
	
	
	
	/*Auto generated methods start*/
	
	@Override
	public String getPK(){
		return companyId;
	}
	
	public String getCompanyId(){
		return companyId;
	}
	
	public void setCompanyId(String companyId){
		this.companyId = companyId;
	}
	
	public String getCompanyName(){
		return companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	
	public String getCompanyBrief(){
		return companyBrief;
	}
	
	public void setCompanyBrief(String companyBrief){
		this.companyBrief = companyBrief;
	}
	
	public String getCompanyContent(){
		return companyContent;
	}
	
	public void setCompanyContent(String companyContent){
		this.companyContent = companyContent;
	}
	
	public String getCompanyPic(){
		return companyPic;
	}
	
	public void setCompanyPic(String companyPic){
		this.companyPic = companyPic;
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
	
	public String getOperatorId(){
		return operatorId;
	}
	
	public void setOperatorId(String operatorId){
		this.operatorId = operatorId;
	}
	
	public Integer getOperatorType(){
		return operatorType;
	}
	
	public void setOperatorType(Integer operatorType){
		this.operatorType = operatorType;
	}
	
	
	/*Auto generated methods end*/
	
	
	
	/*Customized methods start*/
	
	/*Customized methods end*/
	
	
	@Override
	public String toString() {
		return "Company ["
		 + "companyId = " + companyId + ", companyName = " + companyName + ", companyBrief = " + companyBrief + ", companyContent = " + companyContent
		 + ", companyPic = " + companyPic + ", isAvailable = " + isAvailable + ", isDeleted = " + isDeleted + ", createTime = " + createTime + ", createTimeStart = " + createTimeStart + ", createTimeEnd = " + createTimeEnd
		 + ", updateTime = " + updateTime + ", updateTimeStart = " + updateTimeStart + ", updateTimeEnd = " + updateTimeEnd + ", operatorId = " + operatorId + ", operatorType = " + operatorType
		+"]";
	}
}

package cn.com.stone.core.model;

import java.util.Date;
import java.util.List;

import cn.com.stone.common.Entity;

/** 
 * 企业图库 数据实体类
 */
public class CompanyPic extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
	//企业图库ID
	private String companyPicId;
	//企业文化图片
	private String companyPic;
	//图片类型（1企业文化 2企业历史背景 3 加入我们 4 企业服务形象图）
	private Integer companyType;
	//是否可用（0不可用 1 可用 默认0）
	private Integer isAvailable;
	//是否删除(0 未删除 1 删除 默认 0）
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
	
	public List<JoinUs> joinUs;
	
	/*Auto generated properties end*/
	
	
	
	/*Customized properties start*/
	
	/*Customized properties end*/
	
	
	
	/*Auto generated methods start*/
	
	@Override
	public String getPK(){
		return companyPicId;
	}
	
	public List<JoinUs> getJoinUs() {
		return joinUs;
	}

	public void setJoinUs(List<JoinUs> joinUs) {
		this.joinUs = joinUs;
	}

	public String getCompanyPicId(){
		return companyPicId;
	}
	
	public void setCompanyPicId(String companyPicId){
		this.companyPicId = companyPicId;
	}
	
	public String getCompanyPic(){
		return companyPic;
	}
	
	public void setCompanyPic(String companyPic){
		this.companyPic = companyPic;
	}
	
	public Integer getCompanyType(){
		return companyType;
	}
	
	public void setCompanyType(Integer companyType){
		this.companyType = companyType;
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
		return "CompanyPic [companyPicId=" + companyPicId + ", companyPic=" + companyPic + ", companyType="
				+ companyType + ", isAvailable=" + isAvailable + ", isDeleted=" + isDeleted + ", createTime="
				+ createTime + ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd
				+ ", updateTime=" + updateTime + ", updateTimeStart=" + updateTimeStart + ", updateTimeEnd="
				+ updateTimeEnd + ", operatorId=" + operatorId + ", operatorType=" + operatorType + ", joinUs=" + joinUs
				+ "]";
	}
}

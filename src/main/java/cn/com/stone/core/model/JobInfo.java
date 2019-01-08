package cn.com.stone.core.model;

import java.util.Date;

import cn.com.stone.common.Entity;

/** 
 * JobInfo 职称信息 数据实体类
 */
public class JobInfo extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
	//id
	private String id;
	//姓名
	private String name;
	//身份证号
	private String idCard;
	//证书编号
	private String jobNo;
	//专业名称
	private String jobName;
	//等级
	private String jobLevel;
	//发证时间
	private String pubTime;
	//是否删除（0、未删除，1、已删除，默认0）
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getJobNo() {
		return jobNo;
	}
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getCreateTimeStart() {
		return createTimeStart;
	}
	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}
	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getUpdateTimeStart() {
		return updateTimeStart;
	}
	public void setUpdateTimeStart(Date updateTimeStart) {
		this.updateTimeStart = updateTimeStart;
	}
	public Date getUpdateTimeEnd() {
		return updateTimeEnd;
	}
	public void setUpdateTimeEnd(Date updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}
	@Override
	public String toString() {
		return "JobInfo [id=" + id + ", name=" + name + ", idCard=" + idCard + ", jobNo=" + jobNo + ", jobName="
				+ jobName + ", jobLevel=" + jobLevel + ", pubTime=" + pubTime + ", isDeleted=" + isDeleted
				+ ", createTime=" + createTime + ", createTimeStart=" + createTimeStart + ", createTimeEnd="
				+ createTimeEnd + ", updateTime=" + updateTime + ", updateTimeStart=" + updateTimeStart
				+ ", updateTimeEnd=" + updateTimeEnd + "]";
	}	
	
	/*Auto generated properties end*/
	
}

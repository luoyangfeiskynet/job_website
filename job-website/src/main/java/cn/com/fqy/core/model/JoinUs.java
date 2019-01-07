package cn.com.fqy.core.model;

import java.util.Date;

import cn.com.fqy.common.Entity;

/** 
 * 加入我们 数据实体类
 */
public class JoinUs extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
	//加入我们id
	private String joinUsId;
	//岗位名称
	private String stationName;
	//岗位要求
	private String stationDetaile;
	//是否可用（0不可用 1 可用 默认0 ）
	private Integer isAvailable;
	//是否删除（0未删除 1 删除 默认0）
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
	//数据类型（1企业文化 2企业历史背景 3 加入我们）
	private Integer type;
	/*Auto generated properties end*/
	
	
	
	/*Customized properties start*/
	
	/*Customized properties end*/
	
	
	
	/*Auto generated methods start*/
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String getPK(){
		return joinUsId;
	}
	
	public String getJoinUsId(){
		return joinUsId;
	}
	
	public void setJoinUsId(String joinUsId){
		this.joinUsId = joinUsId;
	}
	
	public String getStationName(){
		return stationName;
	}
	
	public void setStationName(String stationName){
		this.stationName = stationName;
	}
	
	public String getStationDetaile(){
		return stationDetaile;
	}
	
	public void setStationDetaile(String stationDetaile){
		this.stationDetaile = stationDetaile;
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
		return "JoinUs [joinUsId=" + joinUsId + ", stationName=" + stationName + ", stationDetaile=" + stationDetaile
				+ ", isAvailable=" + isAvailable + ", isDeleted=" + isDeleted + ", createTime=" + createTime
				+ ", createTimeStart=" + createTimeStart + ", createTimeEnd=" + createTimeEnd + ", updateTime="
				+ updateTime + ", updateTimeStart=" + updateTimeStart + ", updateTimeEnd=" + updateTimeEnd
				+ ", operatorId=" + operatorId + ", operatorType=" + operatorType + ", type=" + type + "]";
	}
}

package cn.com.stone.core.model;

import java.util.Date;

import cn.com.stone.common.Entity;

/** 
 * SysParam 数据实体类
 */
public class SysParam extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
	private String paramId;
	private String paramKey;
	private String paramName;
	private String paramValue;
	private String memo;
	private Integer isConfigurable;
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
	//参数值的类型
	private String paramValueType;
	//参数值的输入方式
	private String paramValueMode;
	//参数值的JSON集合
	private String paramValueJson;
	//序号
	private Integer seq;
	//参数组（1:业务运维，2:技术运维）
	private String paramGroup;
	//业务类型
	private String paramType;
	private String paramValue2;
	
	/*Auto generated properties end*/
	
	
	
	/*Customized properties start*/
	
	/*Customized properties end*/
	
	
	
	/*Auto generated methods start*/
	
	@Override
	public String getPK(){
		return paramId;
	}
	
	public String getParamId(){
		return paramId;
	}
	
	public void setParamId(String paramId){
		this.paramId = paramId;
	}
	
	public String getParamKey(){
		return paramKey;
	}
	
	public void setParamKey(String paramKey){
		this.paramKey = paramKey;
	}
	
	public String getParamName(){
		return paramName;
	}
	
	public void setParamName(String paramName){
		this.paramName = paramName;
	}
	
	public String getParamValue(){
		return paramValue;
	}
	
	public void setParamValue(String paramValue){
		this.paramValue = paramValue;
	}
	
	public String getMemo(){
		return memo;
	}
	
	public void setMemo(String memo){
		this.memo = memo;
	}
	
	public Integer getIsConfigurable(){
		return isConfigurable;
	}
	
	public void setIsConfigurable(Integer isConfigurable){
		this.isConfigurable = isConfigurable;
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
	
	public String getParamValueType(){
		return paramValueType;
	}
	
	public void setParamValueType(String paramValueType){
		this.paramValueType = paramValueType;
	}
	
	public String getParamValueMode(){
		return paramValueMode;
	}
	
	public void setParamValueMode(String paramValueMode){
		this.paramValueMode = paramValueMode;
	}
	
	public String getParamValueJson(){
		return paramValueJson;
	}
	
	public void setParamValueJson(String paramValueJson){
		this.paramValueJson = paramValueJson;
	}
	
	public Integer getSeq(){
		return seq;
	}
	
	public void setSeq(Integer seq){
		this.seq = seq;
	}
	
	public String getParamGroup(){
		return paramGroup;
	}
	
	public void setParamGroup(String paramGroup){
		this.paramGroup = paramGroup;
	}
	
	public String getParamType(){
		return paramType;
	}
	
	public void setParamType(String paramType){
		this.paramType = paramType;
	}
	
	public String getParamValue2(){
		return paramValue2;
	}
	
	public void setParamValue2(String paramValue2){
		this.paramValue2 = paramValue2;
	}
	
	
	/*Auto generated methods end*/
	
	
	
	/*Customized methods start*/
	
	/*Customized methods end*/
	
	
	@Override
	public String toString() {
		return "SysParam ["
		 + "paramId = " + paramId + ", paramKey = " + paramKey + ", paramName = " + paramName + ", paramValue = " + paramValue
		 + ", memo = " + memo + ", isConfigurable = " + isConfigurable + ", isDeleted = " + isDeleted + ", createTime = " + createTime + ", createTimeStart = " + createTimeStart + ", createTimeEnd = " + createTimeEnd
		 + ", updateTime = " + updateTime + ", updateTimeStart = " + updateTimeStart + ", updateTimeEnd = " + updateTimeEnd + ", operatorType = " + operatorType + ", operatorId = " + operatorId + ", paramValueType = " + paramValueType
		 + ", paramValueMode = " + paramValueMode + ", paramValueJson = " + paramValueJson + ", seq = " + seq + ", paramGroup = " + paramGroup
		 + ", paramType = " + paramType + ", paramValue2 = " + paramValue2
		+"]";
	}
}

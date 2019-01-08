package cn.com.stone.core.model;

import java.util.Date;

import cn.com.stone.common.Entity;

/** 
 * 商务合作 数据实体类
 */
public class Commerce extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
	//商务合作ID
	private String commerceId;
	//商务合作图片
	private String commercePic;
	//商务邮箱
	private String commerceEmail;
	//商务电话
	private String commerceMobile;
	//微信公众号二维码
	private String commerceQrCodePic;
	//是否可用(0不可用 1可用 默认0)
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
		return commerceId;
	}
	
	public String getCommerceId(){
		return commerceId;
	}
	
	public void setCommerceId(String commerceId){
		this.commerceId = commerceId;
	}
	
	public String getCommercePic(){
		return commercePic;
	}
	
	public void setCommercePic(String commercePic){
		this.commercePic = commercePic;
	}
	
	public String getCommerceEmail(){
		return commerceEmail;
	}
	
	public void setCommerceEmail(String commerceEmail){
		this.commerceEmail = commerceEmail;
	}
	
	public String getCommerceMobile(){
		return commerceMobile;
	}
	
	public void setCommerceMobile(String commerceMobile){
		this.commerceMobile = commerceMobile;
	}
	
	public String getCommerceQrCodePic(){
		return commerceQrCodePic;
	}
	
	public void setCommerceQrCodePic(String commerceQrCodePic){
		this.commerceQrCodePic = commerceQrCodePic;
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
		return "Commerce ["
		 + "commerceId = " + commerceId + ", commercePic = " + commercePic + ", commerceEmail = " + commerceEmail + ", commerceMobile = " + commerceMobile
		 + ", commerceQrCodePic = " + commerceQrCodePic + ", isAvailable = " + isAvailable + ", isDeleted = " + isDeleted + ", createTime = " + createTime + ", createTimeStart = " + createTimeStart + ", createTimeEnd = " + createTimeEnd
		 + ", updateTime = " + updateTime + ", updateTimeStart = " + updateTimeStart + ", updateTimeEnd = " + updateTimeEnd + ", operatorId = " + operatorId + ", operatorType = " + operatorType
		+"]";
	}
}

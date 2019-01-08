package cn.com.stone.core.model;

import java.util.Date;

import cn.com.stone.common.Entity;

/** 
 * Advert 数据实体类
 */
public class Advert extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
	//id
	private String advertId;
	//广告类型（1、banner 2、企业服务 3、集团简介4、服务优势5、服务案例6、团队风采7、子公司配置 8 启动页视频 9 企业文化-企业理念 10 企业文化-企业历史）
	private Integer advertType;
	//广告名称
	private String advertName;
	//排名（相同广告类型时的排名，数字小的优先，0为最小值）
	private Integer ranking;
	//广告图片url1
	private String advertPicUrl;
	//跳转链接url
	private String linkUrl;
	//内容
	private String advertTitle;
	//副标题
	private String advertSubtitle;
	//内容
	private String advertContent;
	//可用状态（1、可用，0、不可用，默认0）
	private Integer isAvailable;
	//是否删除（0、未删除，1、已删除，默认0）
	private Integer isDeleted;
	//操作人类型
	private Integer operatorType;
	//操作人id
	private String operatorId;
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
	
	/*Auto generated properties end*/
	
	
	
	/*Customized properties start*/
	
	/*Customized properties end*/
	
	
	
	/*Auto generated methods start*/
	
	@Override
	public String getPK(){
		return advertId;
	}
	
	public String getAdvertId(){
		return advertId;
	}
	
	public void setAdvertId(String advertId){
		this.advertId = advertId;
	}
	
	public Integer getAdvertType(){
		return advertType;
	}
	
	public void setAdvertType(Integer advertType){
		this.advertType = advertType;
	}
	
	public String getAdvertName(){
		return advertName;
	}
	
	public void setAdvertName(String advertName){
		this.advertName = advertName;
	}
	
	public Integer getRanking(){
		return ranking;
	}
	
	public void setRanking(Integer ranking){
		this.ranking = ranking;
	}
	
	public String getAdvertPicUrl(){
		return advertPicUrl;
	}
	
	public void setAdvertPicUrl(String advertPicUrl){
		this.advertPicUrl = advertPicUrl;
	}
	
	public String getLinkUrl(){
		return linkUrl;
	}
	
	public void setLinkUrl(String linkUrl){
		this.linkUrl = linkUrl;
	}
	
	public String getAdvertTitle(){
		return advertTitle;
	}
	
	public void setAdvertTitle(String advertTitle){
		this.advertTitle = advertTitle;
	}
	
	public String getAdvertSubtitle(){
		return advertSubtitle;
	}
	
	public void setAdvertSubtitle(String advertSubtitle){
		this.advertSubtitle = advertSubtitle;
	}
	
	public String getAdvertContent(){
		return advertContent;
	}
	
	public void setAdvertContent(String advertContent){
		this.advertContent = advertContent;
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
	
	
	/*Auto generated methods end*/
	
	
	
	/*Customized methods start*/
	
	/*Customized methods end*/
	
	
	@Override
	public String toString() {
		return "Advert ["
		 + "advertId = " + advertId + ", advertType = " + advertType + ", advertName = " + advertName + ", ranking = " + ranking
		 + ", advertPicUrl = " + advertPicUrl + ", linkUrl = " + linkUrl + ", advertTitle = " + advertTitle + ", advertSubtitle = " + advertSubtitle
		 + ", advertContent = " + advertContent + ", isAvailable = " + isAvailable + ", isDeleted = " + isDeleted + ", operatorType = " + operatorType
		 + ", operatorId = " + operatorId + ", createTime = " + createTime + ", createTimeStart = " + createTimeStart + ", createTimeEnd = " + createTimeEnd + ", updateTime = " + updateTime + ", updateTimeStart = " + updateTimeStart + ", updateTimeEnd = " + updateTimeEnd
		+"]";
	}
}

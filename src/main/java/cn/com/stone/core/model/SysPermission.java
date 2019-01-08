package cn.com.stone.core.model;

import java.util.Date;

import cn.com.stone.common.Entity;

/** 
 * SysPermission 数据实体类
 */
public class SysPermission extends Entity<String> {
	
	private static final long serialVersionUID = 1l;
	
	/*Auto generated properties start*/
	
	private String permId;
	private String permName;
	private String permCode;
	private String moduleName;
	private Integer permType;
	private String permResource;
	private String memo;
	private Integer isAvailable;
	private Integer isMenu;
	private Integer isMenuShow;
	private String menuName;
	private Integer level;
	private String parentId;
	private Integer ranking;
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
	private Integer identification;
	//图标名称
	private String iconName;
	
	/*Auto generated properties end*/
	
	
	
	/*Customized properties start*/
	
	/*Customized properties end*/
	
	
	
	/*Auto generated methods start*/
	
	@Override
	public String getPK(){
		return permId;
	}
	
	public String getPermId(){
		return permId;
	}
	
	public void setPermId(String permId){
		this.permId = permId;
	}
	
	public String getPermName(){
		return permName;
	}
	
	public void setPermName(String permName){
		this.permName = permName;
	}
	
	public String getPermCode(){
		return permCode;
	}
	
	public void setPermCode(String permCode){
		this.permCode = permCode;
	}
	
	public String getModuleName(){
		return moduleName;
	}
	
	public void setModuleName(String moduleName){
		this.moduleName = moduleName;
	}
	
	public Integer getPermType(){
		return permType;
	}
	
	public void setPermType(Integer permType){
		this.permType = permType;
	}
	
	public String getPermResource(){
		return permResource;
	}
	
	public void setPermResource(String permResource){
		this.permResource = permResource;
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
	
	public Integer getIsMenu(){
		return isMenu;
	}
	
	public void setIsMenu(Integer isMenu){
		this.isMenu = isMenu;
	}
	
	public Integer getIsMenuShow(){
		return isMenuShow;
	}
	
	public void setIsMenuShow(Integer isMenuShow){
		this.isMenuShow = isMenuShow;
	}
	
	public String getMenuName(){
		return menuName;
	}
	
	public void setMenuName(String menuName){
		this.menuName = menuName;
	}
	
	public Integer getLevel(){
		return level;
	}
	
	public void setLevel(Integer level){
		this.level = level;
	}
	
	public String getParentId(){
		return parentId;
	}
	
	public void setParentId(String parentId){
		this.parentId = parentId;
	}
	
	public Integer getRanking(){
		return ranking;
	}
	
	public void setRanking(Integer ranking){
		this.ranking = ranking;
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
	
	public Integer getIdentification(){
		return identification;
	}
	
	public void setIdentification(Integer identification){
		this.identification = identification;
	}
	
	public String getIconName(){
		return iconName;
	}
	
	public void setIconName(String iconName){
		this.iconName = iconName;
	}
	
	
	/*Auto generated methods end*/
	
	
	
	/*Customized methods start*/
	
	/*Customized methods end*/
	
	
	@Override
	public String toString() {
		return "SysPermission ["
		 + "permId = " + permId + ", permName = " + permName + ", permCode = " + permCode + ", moduleName = " + moduleName
		 + ", permType = " + permType + ", permResource = " + permResource + ", memo = " + memo + ", isAvailable = " + isAvailable
		 + ", isMenu = " + isMenu + ", isMenuShow = " + isMenuShow + ", menuName = " + menuName + ", level = " + level
		 + ", parentId = " + parentId + ", ranking = " + ranking + ", createTime = " + createTime + ", createTimeStart = " + createTimeStart + ", createTimeEnd = " + createTimeEnd + ", updateTime = " + updateTime + ", updateTimeStart = " + updateTimeStart + ", updateTimeEnd = " + updateTimeEnd
		 + ", operatorType = " + operatorType + ", operatorId = " + operatorId + ", identification = " + identification + ", iconName = " + iconName
		+"]";
	}
}

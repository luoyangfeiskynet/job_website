package cn.com.fqy.common.constants;

/**
 * 开发框架基础架构的公共常量设置类（行知网络使用此基础框架的项目均可使用此常量类）
 * @author fqy
 *
 */
public class Constant {
	
	/**整个应用0表示失败*/
	public static final String FAIL="0";
	/**整个应用1表示成功*/
	public static final String SUCCESS="1";
	/**未登录*/
	public static final String NO_LOGIN = "0";
	/**未授权*/
	public static final String NO_AUTHORITY = "0";
	
	/**整个应用0表示否*/
	public static final int NO = 0;
	/**整个应用1表示是*/
	public static final int YES = 1;
	
	/**待审核*/
	public static final int CENSORED_STATE_NO = 0;
	/**审核通过*/
	public static final int CENSORED_STATE_PASS = 1;
	/**审核不通过*/
	public static final int CENSORED_STATE_NOPASS = 2;
	
	/**禁用*/
	public static final int DISABLED = 0;
	/**启用*/
	public static final int ENABLED = 1;
	
	/**不删除*/
	public static final int DEL_STATE_NO = 0;
	/**已删除*/
	public static final int DEL_STATE_YES = 1;
	
	/**默认的分页每页记录数*/
	public static final int DEFAULT_PAGE_SIZE = 10;
	
	/**错误信息，参数无效或不合要求*/
	public static final String ERR_MSG_INVALID_ARG = "Invalid argument.";
	
	/**错误信息，捕获到异常*/
	public static final String ERR_MSG_EXCEPTION_CATCHED = "Exception catched.";
	
	/**错误信息，数据不存在*/
	public static final String ERR_MSG_DATA_NOT_EXISTS = "Data not exists.";
	
}

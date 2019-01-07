package cn.com.fqy.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * SESSION 操作
 * 
 * @ClassName: SessionUtil
 * @Description: TODO
 * @author: fqy
 * @date 2012-12-30 下午08:33:30
 * 
 */
public class ECSessionUtil {

	/**
	 * 保存信息到SESSION
	 * 
	 * @Title: setBaseInfo
	 * @Description: 保存信息到SESSION
	 * @param @param request
	 * @param @param key
	 * @param @param value
	 * @return void
	 * @throws
	 * @author: fqy
	 * @date: 2018-6-19 下午08:31:57
	 */
	public static void setDataToSession(HttpServletRequest request, String key,Object value) {
		request.getSession().setAttribute(key, value);
	}

	/**
	 * 获取session信息
	 * 
	 * @Title: getBaseInfo
	 * @Description: TODO
	 * @param request
	 * @param key
	 * @return
	 * @author: fqy
	 * @date: 2018-6-19 下午08:31:57
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getDataFromSession(HttpServletRequest request,String key, Class<T> clazz) {
		return (T) request.getSession().getAttribute(key);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getDataFromSession(String key, Class<T> clazz) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder  
	            .getRequestAttributes()).getRequest(); 
		return (T) request.getSession().getAttribute(key);
	}
	
	public static HttpSession getSession() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder  
	            .getRequestAttributes()).getRequest(); 
		return request.getSession();
	}
	
	/**
	 * 移除session 属性
	 * 
	 * @param request
	 * @param key
	 */
	public static void removeSessionAttribut(HttpServletRequest request,String key) {
		request.getSession().removeAttribute(key);
	}

	/**
	 * 得到重定向路径
	 * 
	 * @Title: getRedicectURL
	 * @param request
	 * @param path
	 *            跳转相对路径
	 * @author: fqy
	 * @date: 2018-6-19 下午08:31:57
	 */
	public static String getRedicectURL(HttpServletRequest request, String path) {

		String returnUrl = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + path;
		return returnUrl;
	}
}

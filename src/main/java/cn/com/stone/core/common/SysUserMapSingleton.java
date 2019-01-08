package cn.com.stone.core.common;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 设备序列号及其签名数据的持有类
 *
 */
public class SysUserMapSingleton {

	private ConcurrentHashMap<String, Object> sysUserMap = new ConcurrentHashMap<String, Object>(); 
	
	private static SysUserMapSingleton instance = new SysUserMapSingleton(); //单例
	
	private SysUserMapSingleton() { //单例，私有构造函数
		
	}
	
	/**
	 * 返回SysUserMapSingleton的实例（单例）
	 * @return
	 */
	public static SysUserMapSingleton getInstance() {
		return instance;
	}
	
	/**
	 * 存入user对象，键是userId
	 * @param userId
	 * @param obj
	 */
	public void saveUser(String userId,Object obj) {
		if(userId == null || userId.length() == 0 ) {
			return;
		}
		sysUserMap.put(userId, obj);
	}
	
	/**
	 * 根据userId，取回user对象
	 * @param sign
	 * @return
	 */
	public Object getSysUserByUserId(String userId) {
		if(userId == null || userId.length() == 0 ) {
			return null;
		}
		return sysUserMap.get(userId);
	}
}

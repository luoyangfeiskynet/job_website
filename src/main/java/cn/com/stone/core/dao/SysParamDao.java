package cn.com.stone.core.dao;

import cn.com.stone.core.common.BaseDao;
import cn.com.stone.core.model.SysParam;

/**
 * SysParam 数据库处理类
 */
public interface SysParamDao extends BaseDao<SysParam,String> {

	/**
	 * 根据key得到参数
	 */
	public SysParam getByParamKey(String key);

	/**
	 * 根据参数名查找一条信息
	 */
	public SysParam getByParamName(String paramNames);
}

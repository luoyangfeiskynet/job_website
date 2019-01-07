package cn.com.fqy.core.dao;

import java.util.List;

import cn.com.fqy.core.common.BaseDao;
import cn.com.fqy.core.model.JoinUs;

/**
 * 加入我们 数据库处理类
 */
public interface JoinUsDao extends BaseDao<JoinUs,String> {
	
	public List<JoinUs> getJoinUs();
}

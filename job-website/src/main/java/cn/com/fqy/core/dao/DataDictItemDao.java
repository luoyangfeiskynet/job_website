package cn.com.fqy.core.dao;

import java.util.List;

import cn.com.fqy.core.common.BaseDao;
import cn.com.fqy.core.model.DataDictItem;

/**
 * 数据字典的明细项表 数据库处理类
 */
public interface DataDictItemDao extends BaseDao<DataDictItem,String> {
	
	public List<DataDictItem> getDataDictCatCode();
}

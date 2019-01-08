package cn.com.stone.core.dao;

import java.util.List;

import cn.com.stone.core.common.BaseDao;
import cn.com.stone.core.model.DataDictItem;

/**
 * 数据字典的明细项表 数据库处理类
 */
public interface DataDictItemDao extends BaseDao<DataDictItem,String> {
	
	public List<DataDictItem> getDataDictCatCode();
}

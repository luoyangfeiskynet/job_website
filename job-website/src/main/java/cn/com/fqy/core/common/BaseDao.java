package cn.com.fqy.core.common;

import java.io.Serializable;
import java.util.List;

import cn.com.fqy.core.model.Query;

/**
 * 数据对象基础操作类
 * @author fqy
 * 
 */
public interface BaseDao<T,PK extends Serializable> {
	
	/**
	 * 增加对象
	 * @param obj
	 */
	public int add(T obj);

	/**
	 * 修改对象
	 * @param obj
	 */
	public int update(T obj);

	/**
	 * 根据主键删除对象
	 * @param pk
	 */
	public int delete(PK pk);
	
	/**
	 * 根据主键得到某个对象
	 * @param pk
	 */
	public T get(PK pk);
	
	/**
	 * 根据一组主键（数组），得到多个对象，以列表形式返回
	 * @param pks
	 * @return
	 */
	public List<T> getByIds(PK[] pks);
	
	/**
	 * 根据条件查询数据条件
	 * @param q
	 * @return
	 */
	public Long count(Query q);
	
	
	/**
	 * 根据条件查询数据
	 * @param q
	 * @return
	 */
	public List<T> queryAll(Query q);
	
	
	/**
	 * 根据条件查询数据
	 * @param q
	 * @return
	 */
	public List<T> queryOrderInfo(Query q);
	
	/**
	 * 根据条件查询数据
	 * @param q
	 * @return
	 */
	public List<T> pageList(Query q);
}

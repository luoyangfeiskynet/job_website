package cn.com.fqy.core.service;

import java.util.List;

import cn.com.fqy.common.Operator;
import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseService;
import cn.com.fqy.core.common.PageFinder;
import cn.com.fqy.core.model.JoinUs;
import cn.com.fqy.core.model.Query;

/**
 * 加入我们 服务接口类
 */
public interface JoinUsService extends BaseService {

	/**
	 * 根据查询条件，查询并返回JoinUs的列表
	 * @param q 查询条件
	 * @return
	 */
	public List<JoinUs> getJoinUsList(Query q);
	
	/**
	 * 根据查询条件，分页查询并返回JoinUs的分页结果
	 * @param q 查询条件
	 * @return
	 */
	public PageFinder<JoinUs> getJoinUsPagedList(Query q);
	
	/**
	 * 根据主键，查询并返回一个JoinUs对象
	 * @param id 主键id
	 * @return
	 */
	public JoinUs getJoinUs(String id);

	/**
	 * 根据主键数组，查询并返回一组JoinUs对象
	 * @param ids 主键数组，数组中的主键值应当无重复值，如有重复值时，则返回的列表长度可能小于传入的数组长度
	 * @return
	 */
	public List<JoinUs> getJoinUsByIds(String[] ids);
	
	/**
	 * 根据主键，删除特定的JoinUs记录
	 * @param id 主键id
	 * @param operator 操作人对象
	 * @return
	 */
	public ResultInfo<JoinUs> delJoinUs(String id, Operator operator);
	
	/**
	 * 新增一条JoinUs记录，执行成功后传入对象及返回对象的主键属性值不为null
	 * @param joinUs 新增的JoinUs数据（如果无特殊需求，新增对象的主键值请保留为null）
	 * @param operator 操作人对象
	 * @return
	 */
	public ResultInfo<JoinUs> addJoinUs(JoinUs joinUs, Operator operator);
	
	/**
	 * 根据主键，更新一条JoinUs记录
	 * @param joinUs 更新的JoinUs数据，且其主键不能为空
	 * @param operator 操作人对象
	 * @return
	 */
	public ResultInfo<JoinUs> updateJoinUs(JoinUs joinUs, Operator operator);

	/**
	 * 生成主键
	 * @return
	 */
	public String generatePK();
	
		/**
	 * 为JoinUs对象设置默认值
	 * @param obj
	 */
	public void fillDefaultValues(JoinUs obj);
		
}

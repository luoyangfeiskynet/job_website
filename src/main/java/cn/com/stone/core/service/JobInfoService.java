package cn.com.stone.core.service;

import java.util.List;

import cn.com.stone.common.Operator;
import cn.com.stone.common.ResultInfo;
import cn.com.stone.core.common.BaseService;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.JobInfo;
import cn.com.stone.core.model.JobInfo;
import cn.com.stone.core.model.Query;

/**
 * JobInfoService 服务接口类
 */
public interface JobInfoService extends BaseService {

	/**
	 * 根据查询条件，查询并返回JobInfo的列表
	 * @param q 查询条件
	 * @return
	 */
	public List<JobInfo> getJobInfoList(Query q);
	
	/**
	 * 根据查询条件，分页查询并返回JobInfo的分页结果
	 * @param q 查询条件
	 * @return
	 */
	public PageFinder<JobInfo> getJobInfoPagedList(Query q);
	
	/**
	 * 根据主键，查询并返回一个JobInfo对象
	 * @param id 主键id
	 * @return
	 */
	public JobInfo getJobInfo(String id);

	/**
	 * 根据主键数组，查询并返回一组JobInfo对象
	 * @param ids 主键数组，数组中的主键值应当无重复值，如有重复值时，则返回的列表长度可能小于传入的数组长度
	 * @return
	 */
	public List<JobInfo> getJobInfoByIds(String[] ids);
	
	/**
	 * 根据主键，删除特定的JobInfo记录
	 * @param id 主键id
	 * @param operator 操作人对象
	 * @return
	 */
	public ResultInfo<JobInfo> delJobInfo(String id, Operator operator);
	
	/**
	 * 新增一条JobInfo记录，执行成功后传入对象及返回对象的主键属性值不为null
	 * @param JobInfo 新增的JobInfo数据（如果无特殊需求，新增对象的主键值请保留为null）
	 * @param operator 操作人对象
	 * @return
	 */
	public ResultInfo<JobInfo> addJobInfo(JobInfo JobInfo, Operator operator);
	
	/**
	 * 根据主键，更新一条JobInfo记录
	 * @param JobInfo 更新的JobInfo数据，且其主键不能为空
	 * @param operator 操作人对象
	 * @return
	 */
	public ResultInfo<JobInfo> updateJobInfo(JobInfo JobInfo, Operator operator);

	/**
	 * 生成主键
	 * @return
	 */
	public String generatePK();
	
		/**
	 * 为JobInfo对象设置默认值
	 * @param obj
	 */
	public void fillDefaultValues(JobInfo obj);
		
}

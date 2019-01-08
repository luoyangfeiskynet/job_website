package cn.com.stone.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import cn.com.stone.common.Operator;
import cn.com.stone.common.ResultInfo;
import cn.com.stone.common.constants.Constant;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.dao.JobInfoDao;
import cn.com.stone.core.model.Advert;
import cn.com.stone.core.model.JobInfo;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.JobInfoService;

/**
 * JobInfo 服务实现类
 */
@Service
public class JobInfoServiceImpl implements JobInfoService {

	private static final Log log = LogFactory.getLog(JobInfoServiceImpl.class);
	
	@Resource
	private JobInfoDao jobInfoDao;
	

	/**
	 * 根据查询条件，查询并返回Advert的列表
	 * @param q 查询条件
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<JobInfo> getJobInfoList(Query q) {
		List<JobInfo> list = null;
		try {
			//已删除的不查出
			JobInfo advert = (JobInfo)q.getQ();
			if (advert != null) {
				advert.setIsDeleted(Constant.DEL_STATE_NO);
			}
					
			//直接调用Dao方法进行查询
			list = jobInfoDao.queryAll(q);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		//如list为null时，则改为返回一个空列表
		list = list == null ? new ArrayList<JobInfo>(0) : list;
		return list; 
	}
	
	/**
	 * 根据查询条件，分页查询并返回Advert的分页结果
	 * @param q 查询条件
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public PageFinder<JobInfo> getJobInfoPagedList(Query q) {
		PageFinder<JobInfo> page = new PageFinder<JobInfo>();
		
		List<JobInfo> list = null;
		long rowCount = 0L;
		
		try {
			//已删除的不查出
			JobInfo advert = (JobInfo)q.getQ();
			if (advert != null) {
				advert.setIsDeleted(Constant.DEL_STATE_NO);
			}
					
			//调用dao查询满足条件的分页数据
			list = jobInfoDao.pageList(q);
			//调用dao统计满足条件的记录总数
			rowCount = jobInfoDao.count(q);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		//如list为null时，则改为返回一个空列表
		list = list == null ? new ArrayList<JobInfo>(0) : list;
	
		//将分页数据和记录总数设置到分页结果对象中
		page.setData(list);
		page.setRowCount(rowCount);
		page.setPageSize(q.getPageSize());
		return page;
	}	
	
	/**
	 * 根据主键，查询并返回一个Advert对象
	 * @param id 主键id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public JobInfo getJobInfo(String id) {
		JobInfo obj = null;
		if (id == null || id.length() == 0) { //传入的主键无效时直接返回null
			log.info(Constant.ERR_MSG_INVALID_ARG + " id = " + id);
			return obj;
		}
		try {
			//调用dao，根据主键查询
			obj = jobInfoDao.get(id); 
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return obj;
	}

	/**
	 * 根据主键数组，查询并返回一组Advert对象
	 * @param ids 主键数组，数组中的主键值应当无重复值，如有重复值时，则返回的列表长度可能小于传入的数组长度
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<JobInfo> getJobInfoByIds(String[] ids) {
		List<JobInfo> list = null;
		if (ids == null || ids.length == 0) {
			log.info(Constant.ERR_MSG_INVALID_ARG + " ids is null or empty array.");
		} else {
			try {
				//调用dao，根据主键数组查询
				list = jobInfoDao.getByIds(ids);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		
		//如list为null时，则改为返回一个空列表
		list = list == null ? new ArrayList<JobInfo>(0) : list;

		return list;
	}	
	
	/**
	 * 根据主键，删除特定的Advert记录
	 * @param id 主键id
	 * @param operator 操作人对象
	 * @return
	 */
	@Transactional
	public ResultInfo<JobInfo> delJobInfo(String id, Operator operator) {
		ResultInfo<JobInfo> resultInfo = new ResultInfo<JobInfo>();
		if (id == null || id.length() == 0) { //传入的主键无效时直接返回失败结果
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(Constant.ERR_MSG_INVALID_ARG );
			log.info(Constant.ERR_MSG_INVALID_ARG + " id = " + id);
			return resultInfo;
		}
		try {
			//逻辑删除，实际上执行update语句，以下设置待更新记录的主键、删除标识、更新时间、操作人信息等
			JobInfo advert = new JobInfo();
			advert.setId(id);
			advert.setIsDeleted(Constant.DEL_STATE_YES);
			advert.setUpdateTime(new Date());
			
			//调用Dao执行更新操作，并判断更新语句执行结果
			int count = jobInfoDao.update(advert);			
			if (count > 0) {
				resultInfo.setCode(Constant.SUCCESS);
			} else {
				resultInfo.setCode(Constant.FAIL);
			}
			resultInfo.setData(advert);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(Constant.ERR_MSG_EXCEPTION_CATCHED);
		}
		return resultInfo;
	}
		
	/**
	 * 新增一条Advert记录，执行成功后传入对象及返回对象的主键属性值不为null
	 * @param advert 新增的Advert数据（如果无特殊需求，新增对象的主键值请保留为null）
	 * @param operator 操作人对象
	 * @return
	 */
	@Transactional
	public ResultInfo<JobInfo> addJobInfo(JobInfo advert, Operator operator) {
		ResultInfo<JobInfo> resultInfo = new ResultInfo<JobInfo>();
		
		if (advert == null) { //传入参数无效时直接返回失败结果
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(Constant.ERR_MSG_INVALID_ARG );
			log.info(Constant.ERR_MSG_INVALID_ARG + " advert = " + advert);
		} else {
			try {
				//如果传入参数的主键为null，则调用生成主键的方法获取新的主键
				if (advert.getId() == null || "".equals(advert.getId())) {
					advert.setId(this.generatePK());
				}
				
				//设置创建时间和更新时间为当前时间
				Date now = new Date();
				advert.setCreateTime(now);
				advert.setUpdateTime(now);
				
				//填充默认值
				this.fillDefaultValues(advert);
				
				//调用Dao执行插入操作
				jobInfoDao.add(advert);
				resultInfo.setCode(Constant.SUCCESS);
				resultInfo.setData(advert);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				resultInfo.setCode(Constant.FAIL);
				resultInfo.setMsg(Constant.ERR_MSG_EXCEPTION_CATCHED);
			}	
		}
		
		return resultInfo;
	}			
	
	/**
	 * 根据主键，更新一条Advert记录
	 * @param advert 更新的Advert数据，且其主键不能为空
	 * @param operator 操作人对象
	 * @return
	 */
	@Transactional
	public ResultInfo<JobInfo> updateJobInfo(JobInfo advert, Operator operator) {
		ResultInfo<JobInfo> resultInfo = new ResultInfo<JobInfo>();
		
		if (advert == null || advert.getId() == null) { //传入参数无效时直接返回失败结果
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(Constant.ERR_MSG_INVALID_ARG );
			log.info(Constant.ERR_MSG_INVALID_ARG + " advert = " + advert);
		} else {
			try {
				
				//设置更新时间为当前时间
				advert.setUpdateTime(new Date());
				
				//调用Dao执行更新操作，并判断更新语句执行结果
				int count = jobInfoDao.update(advert);			
				if (count > 0) {
					resultInfo.setCode(Constant.SUCCESS);
				} else {
					resultInfo.setCode(Constant.FAIL);
				}
				resultInfo.setData(advert);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				resultInfo.setCode(Constant.FAIL);
				resultInfo.setMsg(Constant.ERR_MSG_EXCEPTION_CATCHED);
			}
		}
		
		return resultInfo;
	}	
	
	/**
	 * 生成主键
	 * @return
	 */
	public String generatePK() {
		return String.valueOf(new Date().getTime() * 1000000 + new Random().nextInt(1000000));
	}
	
	/**
	 * 为Advert对象设置默认值
	 * @param obj
	 */
	public void fillDefaultValues(Advert obj) {
		if (obj != null) {
		    if (obj.getRanking() == null) {
		    	obj.setRanking(0);
		    }
		    if (obj.getIsAvailable() == null) {
		    	obj.setIsAvailable(0);
		    }
		    if (obj.getIsDeleted() == null) {
		    	obj.setIsDeleted(0);
		    }
		}
	}



	@Override
	public void fillDefaultValues(JobInfo obj) {
		// TODO Auto-generated method stub
		
	}

}

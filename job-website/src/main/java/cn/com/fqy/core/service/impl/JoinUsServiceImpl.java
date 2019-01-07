package cn.com.fqy.core.service.impl;

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

import cn.com.fqy.common.Operator;
import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.common.constants.Constant;
import cn.com.fqy.core.common.PageFinder;
import cn.com.fqy.core.dao.JoinUsDao;
import cn.com.fqy.core.model.JoinUs;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.service.JoinUsService;

/**
 * 加入我们 服务实现类
 */
@Service
public class JoinUsServiceImpl implements JoinUsService {

	private static final Log log = LogFactory.getLog(JoinUsServiceImpl.class);
	
	@Resource
	private JoinUsDao joinUsDao;
	

	/**
	 * 根据查询条件，查询并返回JoinUs的列表
	 * @param q 查询条件
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<JoinUs> getJoinUsList(Query q) {
		List<JoinUs> list = null;
		try {
			//已删除的不查出
			JoinUs joinUs = (JoinUs)q.getQ();
			if (joinUs != null) {
				joinUs.setIsDeleted(Constant.DEL_STATE_NO);
			}
					
			//直接调用Dao方法进行查询
			list = joinUsDao.queryAll(q);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		//如list为null时，则改为返回一个空列表
		list = list == null ? new ArrayList<JoinUs>(0) : list;
		return list; 
	}
	
	/**
	 * 根据查询条件，分页查询并返回JoinUs的分页结果
	 * @param q 查询条件
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public PageFinder<JoinUs> getJoinUsPagedList(Query q) {
		PageFinder<JoinUs> page = new PageFinder<JoinUs>();
		
		List<JoinUs> list = null;
		long rowCount = 0L;
		
		try {
			//已删除的不查出
			JoinUs joinUs = (JoinUs)q.getQ();
			if (joinUs != null) {
				joinUs.setIsDeleted(Constant.DEL_STATE_NO);
			}
					
			//调用dao查询满足条件的分页数据
			list = joinUsDao.pageList(q);
			//调用dao统计满足条件的记录总数
			rowCount = joinUsDao.count(q);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		//如list为null时，则改为返回一个空列表
		list = list == null ? new ArrayList<JoinUs>(0) : list;
	
		//将分页数据和记录总数设置到分页结果对象中
		page.setData(list);
		page.setRowCount(rowCount);
		page.setPageSize(q.getPageSize());
		return page;
	}	
	
	/**
	 * 根据主键，查询并返回一个JoinUs对象
	 * @param id 主键id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public JoinUs getJoinUs(String id) {
		JoinUs obj = null;
		if (id == null || id.length() == 0) { //传入的主键无效时直接返回null
			log.info(Constant.ERR_MSG_INVALID_ARG + " id = " + id);
			return obj;
		}
		try {
			//调用dao，根据主键查询
			obj = joinUsDao.get(id); 
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return obj;
	}

	/**
	 * 根据主键数组，查询并返回一组JoinUs对象
	 * @param ids 主键数组，数组中的主键值应当无重复值，如有重复值时，则返回的列表长度可能小于传入的数组长度
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<JoinUs> getJoinUsByIds(String[] ids) {
		List<JoinUs> list = null;
		if (ids == null || ids.length == 0) {
			log.info(Constant.ERR_MSG_INVALID_ARG + " ids is null or empty array.");
		} else {
			try {
				//调用dao，根据主键数组查询
				list = joinUsDao.getByIds(ids);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		
		//如list为null时，则改为返回一个空列表
		list = list == null ? new ArrayList<JoinUs>(0) : list;

		return list;
	}	
	
	/**
	 * 根据主键，删除特定的JoinUs记录
	 * @param id 主键id
	 * @param operator 操作人对象
	 * @return
	 */
	@Transactional
	public ResultInfo<JoinUs> delJoinUs(String id, Operator operator) {
		ResultInfo<JoinUs> resultInfo = new ResultInfo<JoinUs>();
		if (id == null || id.length() == 0) { //传入的主键无效时直接返回失败结果
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(Constant.ERR_MSG_INVALID_ARG );
			log.info(Constant.ERR_MSG_INVALID_ARG + " id = " + id);
			return resultInfo;
		}
		try {
			//逻辑删除，实际上执行update语句，以下设置待更新记录的主键、删除标识、更新时间、操作人信息等
			JoinUs joinUs = new JoinUs();
			joinUs.setJoinUsId(id);
			joinUs.setIsDeleted(Constant.DEL_STATE_YES);
			joinUs.setUpdateTime(new Date());
			if (operator != null) { //最近操作人
				joinUs.setOperatorType(operator.getOperatorType());
				joinUs.setOperatorId(operator.getOperatorId());
			}
			
			//调用Dao执行更新操作，并判断更新语句执行结果
			int count = joinUsDao.update(joinUs);			
			if (count > 0) {
				resultInfo.setCode(Constant.SUCCESS);
			} else {
				resultInfo.setCode(Constant.FAIL);
			}
			resultInfo.setData(joinUs);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(Constant.ERR_MSG_EXCEPTION_CATCHED);
		}
		return resultInfo;
	}
		
	/**
	 * 新增一条JoinUs记录，执行成功后传入对象及返回对象的主键属性值不为null
	 * @param joinUs 新增的JoinUs数据（如果无特殊需求，新增对象的主键值请保留为null）
	 * @param operator 操作人对象
	 * @return
	 */
	@Transactional
	public ResultInfo<JoinUs> addJoinUs(JoinUs joinUs, Operator operator) {
		ResultInfo<JoinUs> resultInfo = new ResultInfo<JoinUs>();
		
		if (joinUs == null) { //传入参数无效时直接返回失败结果
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(Constant.ERR_MSG_INVALID_ARG );
			log.info(Constant.ERR_MSG_INVALID_ARG + " joinUs = " + joinUs);
		} else {
			try {
				//如果传入参数的主键为null，则调用生成主键的方法获取新的主键
				if (joinUs.getJoinUsId() == null || "".equals(joinUs.getJoinUsId())) {
					joinUs.setJoinUsId(this.generatePK());
				}
				//如果传入的操作人不为null，则设置新增记录的操作人类型和操作人id
				if (operator != null) {
					joinUs.setOperatorType(operator.getOperatorType());
					joinUs.setOperatorId(operator.getOperatorId());
				}
				
				//设置创建时间和更新时间为当前时间
				Date now = new Date();
				joinUs.setCreateTime(now);
				joinUs.setUpdateTime(now);
				
				//填充默认值
				this.fillDefaultValues(joinUs);
				
				//调用Dao执行插入操作
				joinUsDao.add(joinUs);
				resultInfo.setCode(Constant.SUCCESS);
				resultInfo.setData(joinUs);
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
	 * 根据主键，更新一条JoinUs记录
	 * @param joinUs 更新的JoinUs数据，且其主键不能为空
	 * @param operator 操作人对象
	 * @return
	 */
	@Transactional
	public ResultInfo<JoinUs> updateJoinUs(JoinUs joinUs, Operator operator) {
		ResultInfo<JoinUs> resultInfo = new ResultInfo<JoinUs>();
		
		if (joinUs == null || joinUs.getJoinUsId() == null) { //传入参数无效时直接返回失败结果
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(Constant.ERR_MSG_INVALID_ARG );
			log.info(Constant.ERR_MSG_INVALID_ARG + " joinUs = " + joinUs);
		} else {
			try {
				//如果传入的操作人不为null，则设置更新记录的操作人类型和操作人id
				if (operator != null) {
					joinUs.setOperatorType(operator.getOperatorType());
					joinUs.setOperatorId(operator.getOperatorId());
				}
				
				//设置更新时间为当前时间
				joinUs.setUpdateTime(new Date());
				
				//调用Dao执行更新操作，并判断更新语句执行结果
				int count = joinUsDao.update(joinUs);			
				if (count > 0) {
					resultInfo.setCode(Constant.SUCCESS);
				} else {
					resultInfo.setCode(Constant.FAIL);
				}
				resultInfo.setData(joinUs);
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
	 * 为JoinUs对象设置默认值
	 * @param obj
	 */
	public void fillDefaultValues(JoinUs obj) {
		if (obj != null) {
			if (obj.getIsAvailable() == null) {
		    	obj.setIsAvailable(0);
		    }
		    if (obj.getIsDeleted() == null) {
		    	obj.setIsDeleted(0);
		    }
		}
	}

}

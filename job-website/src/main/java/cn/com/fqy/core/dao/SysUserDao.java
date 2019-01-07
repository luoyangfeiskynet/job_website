package cn.com.fqy.core.dao;


import java.util.List;

import cn.com.fqy.core.common.BaseDao;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.model.SysUser;



/**
 * SysUser 数据库处理类
 */
public interface SysUserDao extends BaseDao<SysUser,String>{
	public SysUser getSysUser(String loginName, String loginPassword);
	
	public Long count2(Query q);
	
	public List<SysUser> pageList2(Query q);

    Long getCheckExistsByName(String name);

    /**
	 * 根据一组主键（数组），得到多个对象，以列表形式返回
	 * @param pks
	 * @return
	 */
	public List<SysUser> getByIds(String[] ids);
}

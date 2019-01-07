package cn.com.fqy.controller.mgt;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fqy.common.Operator;
import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseController;
import cn.com.fqy.core.common.PageFinder;
import cn.com.fqy.core.model.JoinUs;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.service.JoinUsService;

/**
 * 加入我们
 * @author fqy
 *
 */
@Controller
@RequestMapping("joinUs")
public class JoinUsController extends BaseController{

	@Resource
	private JoinUsService joinUsService;
	
	/**
	 * 分页展示加入我们信息
	 * @param joinUs
	 * @param query
	 * @return
	 */
	@RequestMapping("getJionUsList")
	@ResponseBody
	public PageFinder<JoinUs> getJionUsList(JoinUs joinUs, Query query) {
		joinUs.setIsDeleted(0);
		Query q = new Query(query.getPageNo(), query.getPageSize(), joinUs);
		return joinUsService.getJoinUsPagedList(q);
	}

	/**
	 * 添加或修改加入我们信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping("addOrEditJoinUs")
	@ResponseBody
	public ResultInfo<JoinUs> addOrEditJoinUs(JoinUs joinUs) {
		ResultInfo<JoinUs> resultInfo = new ResultInfo<>();
		// 操作人
		Operator op = getOperator();
		if (joinUs != null && joinUs.getJoinUsId() != null && !"".equals(joinUs.getJoinUsId())) {

			resultInfo = joinUsService.updateJoinUs(joinUs, op);
		} else {

			resultInfo = joinUsService.addJoinUs(joinUs, op);
		}
		return resultInfo;
	}

	/**
	 * 加入我们删除
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping("delJoinUs")
	@ResponseBody
	public ResultInfo<JoinUs> delJoinUs(String joinUsId) {
		ResultInfo<JoinUs> resultInfo = new ResultInfo<>();
		if (joinUsId == null || "".equals(joinUsId)) {
			resultInfo.setCode("0");
			resultInfo.setMsg("参数ID为空");
			return resultInfo;
		}
		JoinUs joinUs = new JoinUs();
		joinUs.setIsDeleted(1);
		joinUs.setJoinUsId(joinUsId);
		return joinUsService.updateJoinUs(joinUs, getOperator());
	}

}

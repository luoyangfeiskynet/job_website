package cn.com.stone.controller.mgt;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.stone.common.Operator;
import cn.com.stone.common.ResultInfo;
import cn.com.stone.core.common.BaseController;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.model.SysParam;
import cn.com.stone.core.service.SysParamService;

@Controller
@RequestMapping("sysParam")
public class SysParamController extends BaseController {

	@Resource
	private SysParamService sysParamService;

	/*
	 * 根据参数名查找一条信息
	 */
	@RequestMapping("getByParamName")
	@ResponseBody
	public ResultInfo<SysParam> getByParamName(String paramName) {
		ResultInfo<SysParam> resultInfo = new ResultInfo<SysParam>();
		SysParam sysParam = sysParamService.getByParamName(paramName);
		if (sysParam == null) {
			resultInfo.setCode("2");
		} else {
			resultInfo.setCode("1");
		}
		return resultInfo;
	}

	/*
	 * 添加或修改系统参数
	 */
	@RequestMapping("addOrEditSysParam")
	@ResponseBody
	public ResultInfo<SysParam> addOrEditSysParam(SysParam sysParam) {
		// 操作人
		Operator op = getOperator();
		if (op != null) {
			sysParam.setOperatorId(op.getOperatorId());
			sysParam.setOperatorType(op.getOperatorType());
		}
		ResultInfo<SysParam> resultInfo = sysParamService.addOrEditSysParam(sysParam);
		return resultInfo;
	}

	/*
	 * 删除系统参数
	 */
	@RequestMapping("deleteSysParam")
	@ResponseBody
	public ResultInfo<SysParam> deleteSysParam(@RequestParam("sysParamId") String sysParamId) {
		return sysParamService.delete(sysParamId, getOperator());
	}

	/*
	 * 分页展示系统参数
	 */
	@RequestMapping("getSysParamList")
	@ResponseBody
	public PageFinder<SysParam> getSysParamList(@ModelAttribute("sysParam") SysParam sysParam, Query query) {
		Query q = new Query(query.getPageNo(), query.getPageSize(), sysParam);
		return sysParamService.pageList(q);
	}

	/*
	 * 批量删除系统参数组
	 */
	@RequestMapping("batchDelete")
	@ResponseBody
	public ResultInfo<SysParam> batchDelete(@RequestParam("sysParamIds") String[] sysParamIds) {
		return sysParamService.batchDelete(sysParamIds, getOperator());
	}

}

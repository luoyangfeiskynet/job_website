package cn.com.stone.controller.mgt;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.stone.common.Operator;
import cn.com.stone.common.ResultInfo;
import cn.com.stone.core.common.BaseController;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.Commerce;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.CommerceService;

/**
 * 商务合作
 * @author fqy
 *
 */
@Controller
@RequestMapping("commerce")
public class CommerceController extends BaseController {

	@Resource
	private CommerceService commerceService;

	/**
	 * 分页展示商务合作
	 * @param commerce
	 * @param query
	 * @return
	 */
	@RequestMapping("getCommerceList")
	@ResponseBody
	public PageFinder<Commerce> getCommerceList(Commerce commerce, Query query) {
		commerce.setIsDeleted(0);
		Query q = new Query(query.getPageNo(), query.getPageSize(), commerce);
		return commerceService.getCommercePagedList(q);
	}

	
	/**
	 * 添加和编辑商务合作信息
	 * @param commerce
	 * @return
	 */
	@RequestMapping("addOrEditCommerce")
	@ResponseBody
	public ResultInfo<Commerce> addOrEditCommerce(Commerce commerce) {
		ResultInfo<Commerce> resultInfo = new ResultInfo<>();
		// 操作人
		Operator op = getOperator();
		if (commerce != null && commerce.getCommerceId() != null && !"".equals(commerce.getCommerceId())) {

			resultInfo = commerceService.updateCommerce(commerce, op);
		} else {
			resultInfo = commerceService.addCommerce(commerce, op);
		}
		return resultInfo;
	}

	
	/**
	 * 删除商务合作
	 * @param commerceId
	 * @return
	 */
	@RequestMapping("delCompany")
	@ResponseBody
	public ResultInfo<Commerce> delCommerce(String commerceId) {
		ResultInfo<Commerce> resultInfo = new ResultInfo<>();
		if (commerceId == null || "".equals(commerceId)) {
			resultInfo.setCode("0");
			resultInfo.setMsg("参数ID为空");
			return resultInfo;
		}
		Commerce commerce = new Commerce();
		commerce.setIsDeleted(1);
		commerce.setCommerceId(commerceId);
		return commerceService.updateCommerce(commerce, getOperator());
	}
}

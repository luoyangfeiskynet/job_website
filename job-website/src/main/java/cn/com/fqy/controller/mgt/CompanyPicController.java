package cn.com.fqy.controller.mgt;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fqy.common.Operator;
import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseController;
import cn.com.fqy.core.common.PageFinder;
import cn.com.fqy.core.model.CompanyPic;
import cn.com.fqy.core.model.JoinUs;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.service.CompanyPicService;


@Controller
@RequestMapping("companyPic")
public class CompanyPicController extends BaseController {

	@Resource
	private CompanyPicService companyPicService;
	
	/**
	 * 分页展示图库信息
	 * @param joinUs
	 * @param query
	 * @return
	 */
	@RequestMapping("getCompanyPicList")
	@ResponseBody
	public PageFinder<CompanyPic> getCompanyPicList(CompanyPic companyPic, Query query) {
		companyPic.setIsDeleted(0);
		Query q = new Query(query.getPageNo(), query.getPageSize(), companyPic);
		return companyPicService.getCompanyPicPagedList(q);
	}

	/**
	 * 添加或修改图库信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping("addOrEditCompanyPic")
	@ResponseBody
	public ResultInfo<CompanyPic> addOrEditCompanyPic(CompanyPic companyPic) {
		ResultInfo<CompanyPic> resultInfo = new ResultInfo<>();
		// 操作人
		Operator op = getOperator();
		if (companyPic != null && companyPic.getCompanyPicId() != null && !"".equals(companyPic.getCompanyPicId())) {

			resultInfo = companyPicService.updateCompanyPic(companyPic, op);
		} else {

			resultInfo = companyPicService.addCompanyPic(companyPic, op);
		}
		return resultInfo;
	}

}

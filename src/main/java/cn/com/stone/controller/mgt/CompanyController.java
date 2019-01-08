package cn.com.stone.controller.mgt;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.stone.common.Operator;
import cn.com.stone.common.ResultInfo;
import cn.com.stone.core.common.BaseController;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.Company;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.CompanyService;

/**
 * 企业服务
 * @author fqy
 *
 */
@Controller
@RequestMapping("company")
public class CompanyController extends BaseController {

	@Resource
	private CompanyService companyService;

	/**
	 * 分页展示企业信息
	 * 
	 * @param company
	 * @param query
	 * @return
	 */
	@RequestMapping("getCompanyList")
	@ResponseBody
	public PageFinder<Company> getCompanyList(Company company, Query query) {
		company.setIsDeleted(0);
		Query q = new Query(query.getPageNo(), query.getPageSize(), company);
		return companyService.getCompanyPagedList(q);
	}

	/**
	 * 添加或修企业信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping("addOrEditCompany")
	@ResponseBody
	public ResultInfo<Company> addOrEditCompany(Company company) {
		ResultInfo<Company> resultInfo = new ResultInfo<>();
		// 操作人
		Operator op = getOperator();
		if (company != null && company.getCompanyId() != null && !"".equals(company.getCompanyId())) {

			resultInfo = companyService.updateCompany(company, op);
		} else {

			resultInfo = companyService.addCompany(company, op);
		}
		return resultInfo;
	}

	/**
	 * 企业删除
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping("delCompany")
	@ResponseBody
	public ResultInfo<Company> delCompany(String companyId) {
		ResultInfo<Company> resultInfo = new ResultInfo<>();
		if (companyId == null || "".equals(companyId)) {
			resultInfo.setCode("0");
			resultInfo.setMsg("参数ID为空");
			return resultInfo;
		}
		Company company = new Company();
		company.setIsDeleted(1);
		company.setCompanyId(companyId);
		return companyService.updateCompany(company, getOperator());
	}

}

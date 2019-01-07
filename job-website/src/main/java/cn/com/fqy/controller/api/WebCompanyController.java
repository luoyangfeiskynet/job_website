package cn.com.fqy.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseController;
import cn.com.fqy.core.model.Company;
import cn.com.fqy.core.model.CompanyPic;
import cn.com.fqy.core.model.JoinUs;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.service.CompanyPicService;
import cn.com.fqy.core.service.CompanyService;

/**
 * 企业服务
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/company")
public class WebCompanyController extends BaseController{

	@Resource
	private CompanyService companyService;
	@Resource
	private CompanyPicService companyPicService;
	
	
	/**
	 * 企业服务
	 * @return
	 */
	@RequestMapping("getCompanys")
	@ResponseBody
	public ResultInfo<Map<String,List<Map<String,Object>>>> getCompanys(){
		ResultInfo<Map<String,List<Map<String,Object>>>> resultInfo = new ResultInfo<>();
		
		Map<String,List<Map<String,Object>>> resultMap= new HashMap<>();
		List<Map<String,Object>> serverList = new ArrayList<>();	//存放企业服务内容
		List<Map<String,Object>> bgPic = new ArrayList<>();	//存放企业服务背景图
		Company company =new Company();
		company.setIsAvailable(1);
		company.setIsDeleted(0);
		
		
		CompanyPic companyPic = new CompanyPic();
		companyPic.setIsAvailable(1);
		companyPic.setIsDeleted(0);
		companyPic.setCompanyType(4);	//企业服务背景图
		List<CompanyPic> comPicList = companyPicService.getCompanyPicList(new Query(companyPic));
		if (comPicList.size() > 0 && comPicList != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("companyServerPic", comPicList.get(0).getCompanyPic());
			bgPic.add(map);
		}
		List<Company> comList=companyService.getCompanyList(new Query(company));
		if(comList.size()>0 && comList != null) {
			for(Company list:comList) {
				Map<String, Object> map = new HashMap<>();
				map.put("companyId", list.getCompanyId());
				map.put("companyBrief", list.getCompanyBrief());
				map.put("companyContent", list.getCompanyContent());
				map.put("companyName", list.getCompanyName());
				map.put("companyPic", list.getCompanyPic());
				serverList.add(map);
			}
			resultMap.put("bgPic", bgPic);
			resultMap.put("serverList", serverList);
			resultInfo.setCode("1");
			resultInfo.setData(resultMap);
		}else {
			resultInfo.setCode("0");
			resultInfo.setMsg("暂无数据");
		}
		return resultInfo;
	}
}

package cn.com.stone.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.stone.common.ResultInfo;
import cn.com.stone.core.common.BaseController;
import cn.com.stone.core.model.CompanyPic;
import cn.com.stone.core.model.JoinUs;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.CompanyPicService;
import cn.com.stone.core.service.JoinUsService;

/**
 * 加入我们
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/joinUs")
public class WebJoinUsController extends BaseController {

	@Resource
	private CompanyPicService companyPicService;
	@Resource
	private JoinUsService joinUsService;
	
	/**
	 * 加入我们图片
	 * 
	 * @return
	 */
	@RequestMapping("getJoinUs")
	@ResponseBody
	public ResultInfo<Map<String, Object>> getJoinUs() {
		ResultInfo<Map<String, Object>> resultInfo = new ResultInfo<>();
		Map<String, Object> map = new HashMap<>();
		CompanyPic companyPic = new CompanyPic();
		companyPic.setIsAvailable(1);
		companyPic.setIsDeleted(0);
		companyPic.setCompanyType(3);
		List<CompanyPic> comPicList = companyPicService.getCompanyPicList(new Query(companyPic));
		if (comPicList.size() > 0 && comPicList != null) {
					map.put("joinUsPic", comPicList.get(0).getCompanyPic());
					List<Map<String,String>> mapList= new ArrayList<>();
					for(JoinUs juList:comPicList.get(0).getJoinUs() ) {
						Map<String,String> model= new HashMap<>();
						model.put("cpyId", juList.getJoinUsId());
						model.put("cpyTitle", juList.getStationName());
						model.put("cpyDetaile", juList.getStationDetaile());
						mapList.add(model);
					}
					map.put("juList", mapList);
			resultInfo.setCode("1");
			resultInfo.setData(map);
		} else {
			resultInfo.setCode("0");
			resultInfo.setMsg("暂无数据");
		}
		return resultInfo;
	}

	/**
	 * 加入我们岗位列表
	 * @return
	 */
//	@RequestMapping("getStationList")
//	@ResponseBody
//	public ResultInfo<List<Map<String,Object>>> getStationList(){
//		ResultInfo<List<Map<String,Object>>> resultInfo = new ResultInfo<>();
//		List<Map<String,Object>> listQuery = new ArrayList<>();
//		JoinUs joinUs =new JoinUs();
//		joinUs.setIsAvailable(1);
//		joinUs.setIsDeleted(0);
//		List<JoinUs> juList=joinUsService.getJoinUsList(new Query(joinUs));
//		if(juList.size()>0 && juList != null) {
//			for(JoinUs list:juList) {
//				Map<String,Object> map = new HashMap<>();
//				map.put("joinUsId",list.getJoinUsId());
//				map.put("stationName",list.getStationName());
//				map.put("stationDetaile",list.getStationDetaile());
//				listQuery.add(map);
//			}
//			resultInfo.setCode("1");
//			resultInfo.setData(listQuery);
//		}else {
//			resultInfo.setCode("0");
//			resultInfo.setMsg("暂无数据");
//		}
//		return resultInfo;
//	}
}

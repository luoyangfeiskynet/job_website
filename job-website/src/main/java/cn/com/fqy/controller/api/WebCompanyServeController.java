package cn.com.fqy.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.accessibility.internal.resources.accessibility;

import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.core.common.BaseController;
import cn.com.fqy.core.model.Advert;
import cn.com.fqy.core.model.CompanyPic;
import cn.com.fqy.core.model.JoinUs;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.service.AdvertService;
import cn.com.fqy.core.service.CompanyPicService;

/**
 * 企业文化
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/companyServe")
public class WebCompanyServeController extends BaseController {

	@Resource
	private CompanyPicService companyPicService;
	@Resource
	private AdvertService advertService;
	
	
	/**
	 * 获取企业文化页面信息
	 * @return
	 */
	@RequestMapping("getInfo")
	@ResponseBody
	public ResultInfo<Map<String,List<Map<String,Object>>>> getAdverts(){
		ResultInfo<Map<String,List<Map<String,Object>>>> resultInfo = new ResultInfo<>();
		Advert advert = new Advert();
		Map<String,List<Map<String,Object>>> resultMap= new HashMap<>();
		List<Map<String,Object>> historyList = new ArrayList<>();	//存放发展历史
		List<Map<String,Object>> curlList = new ArrayList<>();	//存放企业文化
		List<Map<String,Object>> teamList = new ArrayList<>();	//存放团队风采
		
		//过滤条件
		advert.setIsAvailable(1);
		advert.setIsDeleted(0);
		
		List<Advert> adList = advertService.getAdvertList(new Query());
		for(Advert list: adList) {
			
			//企业理念
			if(list.getAdvertType()==9) {
				Map<String,Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("curlName", list.getAdvertTitle());	//理念名称
				map.put("curlContent", list.getAdvertContent());	//理念内容
				curlList.add(map);
			}
			
			//企业发展历史
			if(list.getAdvertType()==10) {
				Map<String,Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("year", list.getAdvertTitle());	//发展年份
				map.put("yearContent", list.getAdvertContent());	//发展内容
				historyList.add(map);
			}
			
			//团队风采
			if(list.getAdvertType()==6) {
				Map<String,Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("advertPicUrl", list.getAdvertPicUrl());	//风采主图
				map.put("advertName", list.getAdvertName());	//风采名称
				map.put("advertTitle", list.getAdvertTitle());	//风采标题
				map.put("advertSubtitle", list.getAdvertSubtitle());	//风采副标题
				map.put("content", list.getAdvertContent());	//风采内容体
				teamList.add(map);
			}
		}
		resultMap.put("curl", curlList);
		resultMap.put("history", historyList);
		resultMap.put("team", teamList);
		resultInfo.setCode("1");
		resultInfo.setData(resultMap);
		return resultInfo;
	}
	

	/**
	 * 企业文化图片
	 * 
	 * @return
	 */
	@RequestMapping("getCompanyCulture")
	@ResponseBody
	public ResultInfo<Map<String, Object>> getCompanyCulture() {
		ResultInfo<Map<String, Object>> resultInfo = new ResultInfo<>();
		Map<String, Object> map = new HashMap<>();
		CompanyPic companyPic = new CompanyPic();
		companyPic.setIsAvailable(1);
		companyPic.setIsDeleted(0);
		List<CompanyPic> comPicList = companyPicService.getCompanyPicList(new Query(companyPic));
		if (comPicList.size() > 0 && comPicList != null) {
			for (CompanyPic list : comPicList) {
				//企业家精神
				if (list.getCompanyType() == 1) {
					map.put("culturePic", list.getCompanyPic());
					
					int count=0;
					List<Map<String,String>> mapList= new ArrayList<>();
					for(JoinUs juList:list.getJoinUs() ) {
						if(count==6) {
							break;
						}
						Map<String,String> model= new HashMap<>();
						model.put("cpyId", juList.getJoinUsId());
						model.put("cpyTitle", juList.getStationName());
						model.put("cpyDetaile", juList.getStationDetaile());
						mapList.add(model);
						count++;
					}
					map.put("cultureList", mapList);
				}
				if (list.getCompanyType() == 2) {
					map.put("backPic", list.getCompanyPic());
					List<Map<String,String>> mapList= new ArrayList<>();
					for(JoinUs juList:list.getJoinUs() ) {
						Map<String,String> model= new HashMap<>();
						model.put("cpyId", juList.getJoinUsId());
						model.put("cpyTitle", juList.getStationName());
						model.put("cpyDetaile", juList.getStationDetaile());
						mapList.add(model);
					}
					map.put("backList", mapList);
				}
			}
			resultInfo.setCode("1");
			resultInfo.setData(map);
		} else {
			resultInfo.setCode("0");
			resultInfo.setMsg("暂无数据");
		}
		return resultInfo;
	}

	/**
	 * 团队风采
	 * 
	 * @return
	 */
	@RequestMapping("getTeamList")
	@ResponseBody
	public ResultInfo<List<Map<String, Object>>> getTeamList() {
		ResultInfo<List<Map<String, Object>>> resultInfo = new ResultInfo<>();
		List<Map<String, Object>> listQuery = new ArrayList<>();
		Advert advert = new Advert();
		advert.setIsAvailable(1);
		advert.setIsDeleted(0);
		advert.setAdvertType(6);// 类型6是团队风采数据
		List<Advert> teamList = advertService.getAdvertList(new Query(advert));
		if (teamList.size() > 0 && teamList != null) {
			for (Advert list : teamList) {
				Map<String, Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("advertPicUrl", list.getAdvertPicUrl());	//风采主图
				map.put("advertName", list.getAdvertName());	//风采名称
				map.put("advertTitle", list.getAdvertTitle());	//风采标题
				map.put("advertSubtitle", list.getAdvertSubtitle());	//风采副标题
				map.put("content", list.getAdvertContent());	//风采内容体
				listQuery.add(map);
			}
			resultInfo.setCode("1");
			resultInfo.setData(listQuery);
		} else {
			resultInfo.setCode("0");
			resultInfo.setMsg("暂无数据");
		}
		return resultInfo;
	}

	/**
	 * 团队风采详情
	 * @return
	 */
	@RequestMapping("getTeamDetial")
	@ResponseBody
	public ResultInfo<Map<String, Object>> getTeamDetial(String advertId) {
		ResultInfo<Map<String, Object>> resultInfo = new ResultInfo<>();
		if (advertId == null || "".equals(advertId)) {
			resultInfo.setCode("0");
			resultInfo.setMsg("参数ID为空");
			return resultInfo;
		}
		Advert advert = advertService.getAdvert(advertId);
		if (advert != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("advertId", advert.getAdvertId());
			map.put("advertPicUrl", advert.getAdvertPicUrl());	//风采主图
			map.put("advertName", advert.getAdvertName());	//风采名称
			map.put("advertTitle", advert.getAdvertTitle());	//风采标题
			map.put("advertSubtitle", advert.getAdvertSubtitle());	//风采副标题
			map.put("content", advert.getAdvertContent());	//风采内容体
			resultInfo.setCode("1");
			resultInfo.setData(map);
		} else {
			resultInfo.setCode("0");
			resultInfo.setMsg("暂无数据");
		}
		return resultInfo;
	}
}

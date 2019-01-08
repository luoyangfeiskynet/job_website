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
import cn.com.stone.core.model.Advert;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.AdvertService;

/**
 * 首页
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/index")
public class IndexController extends BaseController {

	@Resource
	private AdvertService advertService;
	
	/**
	 * 获取首页信息
	 * @return
	 */
	@RequestMapping("getAdverts")
	@ResponseBody
	public ResultInfo<Map<String,List<Map<String,Object>>>> getAdverts(){
		ResultInfo<Map<String,List<Map<String,Object>>>> resultInfo = new ResultInfo<>();
		Advert advert = new Advert();
		Map<String,List<Map<String,Object>>> resultMap= new HashMap<>();
		List<Map<String,Object>> mapList = new ArrayList<>();	//存放banner列表
		List<Map<String,Object>> mapList1 = new ArrayList<>();	//存放企业服务
		List<Map<String,Object>> mapList2 = new ArrayList<>();	//存放企业简介
		List<Map<String,Object>> mapList3 = new ArrayList<>();	//存放服务优势
		List<Map<String,Object>> mapList4 = new ArrayList<>();	//存放服务案例
		
		//过滤条件
		advert.setIsAvailable(1);
		advert.setIsDeleted(0);
		
		List<Advert> adList = advertService.getAdvertList(new Query());
		for(Advert list: adList) {
			//banner列表
			if(list.getAdvertType()==1) {	
				Map<String,Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("advertPicUrl", list.getAdvertPicUrl());
				map.put("advertTitle", list.getAdvertTitle());
				mapList.add(map);
				continue;
			}
			//企业服务
			if(list.getAdvertType()==2) {
				Map<String,Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("advertPicUrl", list.getAdvertPicUrl());	//企业服务图
				map.put("advertTitle", list.getAdvertTitle());	//企业服务名称
				map.put("content", list.getAdvertSubtitle());	//企业服务内容
				mapList1.add(map);
				continue;
			}
			//企业简介
			if(list.getAdvertType()==3) {
				Map<String,Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("mainPhoto", list.getAdvertPicUrl());	//主图
				map.put("bgPhoto", list.getLinkUrl());	//背景图
				map.put("companyName", list.getAdvertTitle());	//公司名称
				map.put("companyEnglishName", list.getAdvertSubtitle());	//公司英文名称
				map.put("content", list.getAdvertContent());	//企业简介内容
				mapList2.add(map);
				continue;
			}
			//服务优势
			if(list.getAdvertType()==4) {
				Map<String,Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("advertPicUrl", list.getAdvertPicUrl());
				map.put("advertTitle", list.getAdvertTitle());
//				map.put("advertContent", list.getAdvertContent());
				mapList3.add(map);
				continue;
			}
			//服务案例
			if(list.getAdvertType()==5) {
				Map<String,Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("mainPhoto", list.getAdvertPicUrl());	//案例主图
				map.put("projectName", list.getAdvertName());	//案例名称
				map.put("content", list.getAdvertSubtitle());	//案例简介
				mapList4.add(map);
			}
		}
		resultMap.put("banner", mapList);
		resultMap.put("service", mapList1);
		resultMap.put("companyBrief", mapList2);
		resultMap.put("advange", mapList3);
		resultMap.put("case", mapList4);
		resultInfo.setCode("1");
		resultInfo.setData(resultMap);
		return resultInfo;
	}
	
	/**
	 * 底部子公司配置
	 * @return
	 */
	@RequestMapping("getSubcompanyList")
	@ResponseBody
	public ResultInfo<List<Map<String, Object>>> getSubcompanyList() {
		ResultInfo<List<Map<String, Object>>> resultInfo = new ResultInfo<>();
		List<Map<String, Object>> listQuery = new ArrayList<>();
		Advert advert = new Advert();
		advert.setIsAvailable(1);
		advert.setIsDeleted(0);
		advert.setAdvertType(7);// 类型7是子公司数据
		List<Advert> teamList = advertService.getAdvertList(new Query(advert));
		if (teamList.size() > 0 && teamList != null) {
			for (Advert list : teamList) {
				Map<String, Object> map = new HashMap<>();
				map.put("advertId", list.getAdvertId());
				map.put("advertName", list.getAdvertName());
				map.put("linkUrl", list.getLinkUrl());
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
}

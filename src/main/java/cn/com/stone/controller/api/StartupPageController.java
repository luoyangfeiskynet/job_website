package cn.com.stone.controller.api;

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
 * 启动页
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/startPage")
public class StartupPageController extends BaseController{

	@Resource
	private AdvertService advertService;
	
	/**
	 * 获取启动页视屏
	 * @return
	 */
	@RequestMapping("getPageVideo")
	@ResponseBody
	public ResultInfo<Map<String,String>> getPageVideo(){
		ResultInfo<Map<String,String>> resultInfo = new ResultInfo<>();
		Map<String,String> map  = new HashMap<>();
		Advert advert = new Advert();
		advert.setAdvertType(8);
		List<Advert> list =advertService.getAdvertList(new Query(advert));
		if(list.size()>0 && list != null) {
			map.put("advertId", list.get(0).getAdvertId());
			map.put("advertPicUrl", list.get(0).getAdvertPicUrl());
			resultInfo.setCode("1");
			resultInfo.setData(map);
		}else {
			resultInfo.setCode("0");
			resultInfo.setMsg("暂无数据");
		}
		return resultInfo;
		
	}
}

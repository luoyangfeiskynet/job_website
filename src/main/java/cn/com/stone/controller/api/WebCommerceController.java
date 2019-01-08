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
import cn.com.stone.core.model.Commerce;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.CommerceService;

/**
 * 商务合作
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/commerce")
public class WebCommerceController extends BaseController {

	@Resource
	private CommerceService commerceService;
	
	/**
	 * 获取商务合作信息
	 * @return
	 */
	@RequestMapping("getCommerces")
	@ResponseBody
	public ResultInfo<List<Map<String,Object>>> getCommerces(){
		ResultInfo<List<Map<String,Object>>> resultInfo = new ResultInfo<>();
		List<Map<String,Object>> listQuery = new ArrayList<>();
		Commerce commerce = new Commerce();
		commerce.setIsAvailable(1);
		commerce.setIsDeleted(0);
		List<Commerce> commList =commerceService.getCommerceList(new Query(commerce));
		if(commList.size()>0 && commList != null) {
			Map<String,Object> map = new HashMap<>();
			map.put("commerceId",commList.get(0).getCommerceId());
			map.put("commercePic",commList.get(0).getCommercePic());
			map.put("commerceEmail",commList.get(0).getCommerceEmail());
			map.put("commerceMobile",commList.get(0).getCommerceMobile());
			map.put("commerceQrCodePic",commList.get(0).getCommerceQrCodePic());
			
			listQuery.add(map);
			resultInfo.setCode("1");
			resultInfo.setData(listQuery);
		}else {
			resultInfo.setCode("0");
			resultInfo.setMsg("暂无数据");
		}
		return resultInfo;
	}
}

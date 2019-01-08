package cn.com.stone.controller.mgt;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.stone.common.ResultInfo;
import cn.com.stone.common.util.ECFileUtil;
import cn.com.stone.core.common.BaseController;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.Advert;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.AdvertService;

/**
 * 内容
 * @author fqy
 *
 */
@Controller
@RequestMapping("advert")
public class AdvertController extends BaseController{

	@Resource
	private AdvertService advertService;
	@Value("${image_path}")
	private String imagePath;
	@Value("${res_file_path}")
	private String storeFilePath;
	@Value("${file_path}")
	private String fileServer;
	
	/**
	 * 分页展示广告
	 */
	@RequestMapping("getAdvertList")
	@ResponseBody
	public PageFinder<Advert> advertList(@ModelAttribute("advert") Advert advert,Query query) {	
		Query q = new Query(query.getPageNo(),query.getPageSize(),advert);
		return advertService.getAdvertPagedList(q);
	}
	
	/**
	 *  添加编辑广告
	 * @param Advert
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("addOrEditAdvert")
	@ResponseBody
	public ResultInfo<Advert> addOrEditreAdvert(Advert advert) throws Exception{
		ResultInfo<Advert> result = new ResultInfo<>();
		
		if (advert.getAdvertContent()!=null&&!"".equals(advert.getAdvertContent())) {
			String advertContent = advert.getAdvertContent();
			advertContent = advertContent.replaceAll("src=\"image-server/", "src=\""+imagePath);
			advert.setAdvertContent(advertContent);
		}
		if (advert!=null&&advert.getAdvertId()!=null&&!"".equals(advert.getAdvertId())) {
			
				String html = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\"><title>"+advert.getAdvertTitle()+"</title></head><body>" + advert.getAdvertContent() + "</body></html>";
				ECFileUtil.uploadFile(html.getBytes("UTF-8"), storeFilePath, advert.getAdvertId()+".html");
//			if(advert.getAdvertType() !=7) {
//				advert.setLinkUrl(fileServer+advert.getAdvertId()+".html");
//			}
			
			result = advertService.updateAdvert(advert, getOperator());
		}else {
			advert.setAdvertId(advertService.generatePK());
			if (advert!=null&&advert.getAdvertContent()!=null&&!"".equals(advert.getAdvertContent())) {
				String html = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\"><title>"+advert.getAdvertTitle()+"</title></head><body>" + advert.getAdvertContent() + "</body></html>";
				ECFileUtil.uploadFile(html.getBytes("UTF-8"), storeFilePath, advert.getAdvertId()+".html");
			}
//			if(advert.getAdvertType() !=7) {
//				advert.setLinkUrl(fileServer+advert.getAdvertId()+".html");
//			}
			result = advertService.addAdvert(advert, getOperator());
		}
		return result;
	}
}

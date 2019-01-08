package cn.com.stone.controller.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.stone.common.ResultInfo;
import cn.com.stone.common.constants.Constant;
import cn.com.stone.common.util.ECFileUtil;
import cn.com.stone.core.common.BaseController;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.Advert;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.AdvertService;
import cn.com.stone.core.service.SysUserService;

/**
 * 查询新闻
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/news")
public class NewsController extends BaseController {

	@Resource
	private AdvertService advertService;
	@Value("${image_path}")
	private String imagePath;
	@Value("${res_file_path}")
	private String storeFilePath;
	@Value("${file_path}")
	private String fileServer;
	@Resource
	private SysUserService sysUserService;

	
	
	/**
	 * 新闻列表
	 */
	@RequestMapping("getNews")
	@ResponseBody
	public ResultInfo<List<Advert>> getJobInfo(Advert advert){
		ResultInfo<List<Advert>> resultInfo = new ResultInfo<List<Advert>>();
		advert.setIsDeleted(0);	//未删除
		advert.setAdvertType(88);
		Query q = new Query(advert);
		PageFinder<Advert> pageResult = advertService.getAdvertPagedList(q);
		if(null != pageResult && pageResult.getData().size() > 0) {
			List<Advert> result = pageResult.getData();
			resultInfo.setData(result);
			resultInfo.setCode(Constant.SUCCESS);
			resultInfo.setMsg("请求成功");
		}else {
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg("暂无数据");
		}
		return resultInfo;
	}
	
	
	/**
	 *  添加编辑广告
	 * @param Advert
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("addOrEditAdvert")
	@ResponseBody
	public ResultInfo<Advert> addOrEditreAdvert(Advert advert,String userId) throws Exception{
		ResultInfo<Advert> result = new ResultInfo<>();
		if (advert.getAdvertContent()!=null&&!"".equals(advert.getAdvertContent())) {
			String advertContent = advert.getAdvertContent();
			advertContent = advertContent.replaceAll("src=\"image-server/", "src=\""+imagePath);
			advert.setAdvertContent(advertContent);
		}
		if (advert!=null&&advert.getAdvertId()!=null&&!"".equals(advert.getAdvertId())) {
			if (advert!=null&&advert.getAdvertContent()!=null&&!"".equals(advert.getAdvertContent())) {
				String html = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\"><title>"+advert.getAdvertTitle()+"</title></head><body>" + advert.getAdvertContent() + "</body></html>";
				ECFileUtil.uploadFile(html.getBytes("UTF-8"), storeFilePath, advert.getAdvertId()+".html");
			}
			advert.setLinkUrl(fileServer+advert.getAdvertId()+".html");
			result = advertService.updateAdvert(advert, getOperator());
		}else {
			if (advert.getAdvertType()==4||advert.getAdvertType()==5||advert.getAdvertType()==6||advert.getAdvertType()==7||advert.getAdvertType()==8||advert.getAdvertType()==9) {
				Advert advertQuery = new Advert();
				advertQuery.setAdvertType(advert.getAdvertType());
				List<Advert> advertList = advertService.getAdvertList(new Query(advertQuery));
				if (advertList.size()>=1) {
					result.setCode("0");
					return result;
				}
			}
			advert.setAdvertId(advertService.generatePK());
			if (advert!=null&&advert.getAdvertContent()!=null&&!"".equals(advert.getAdvertContent())) {
				String html = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\" name=\"viewport\"><title>"+advert.getAdvertTitle()+"</title></head><body>" + advert.getAdvertContent() + "</body></html>";
				ECFileUtil.uploadFile(html.getBytes("UTF-8"), storeFilePath, advert.getAdvertId()+".html");
			}
			advert.setLinkUrl(fileServer+advert.getAdvertId()+".html");
			result = advertService.addAdvert(advert, getOperator());
		}
		return result;
	}
	
	
	
}

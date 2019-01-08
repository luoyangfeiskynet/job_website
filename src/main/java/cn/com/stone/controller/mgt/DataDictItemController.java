package cn.com.stone.controller.mgt;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.stone.common.ResultInfo;
import cn.com.stone.common.constants.Constant;
import cn.com.stone.core.common.BaseController;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.DataDictItem;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.DataDictCatService;
import cn.com.stone.core.service.DataDictItemService;

@Controller
@RequestMapping("dataDictItem")
public class DataDictItemController extends BaseController {
	@Resource
	private DataDictCatService dataDictCatService;
	@Resource
	private DataDictItemService dataDictItemService;

	/**
	 * 数据字典项查询
	 * 
	 * @param dataDictCatItem
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("getDataDictItemList")
	@ResponseBody
	public PageFinder<DataDictItem> dataDictItemPageList(@ModelAttribute("DataDictItem") DataDictItem dataDictCatItem, Query query) {
		Query q = new Query(query.getPageNo(), query.getPageSize(), dataDictCatItem);
		return dataDictItemService.getDataDictItemPagedList(q);
	}

	/**
	 *数据字典项增加编辑
	 * 
	 * @param dataDictCatItem
	 * @return
	 */
	@RequestMapping("addOrEditDataDictItem")
	@ResponseBody
	public ResultInfo<DataDictItem> addDataDictItem(@ModelAttribute("DataDictItem") DataDictItem dataDictItem) {
		ResultInfo<DataDictItem> resultInfo = new ResultInfo<DataDictItem>();
		if (dataDictItem.getDataDictItemId()!=null&&!"".equals(dataDictItem.getDataDictItemId())) {
			if (dataDictItem.getItemValue()!=null&&!"".equals(dataDictItem.getItemValue())) {
				DataDictItem  dataDictItemQuery = new DataDictItem();
				dataDictItemQuery.setDataDictCatCode(dataDictItem.getDataDictCatCode());
				dataDictItemQuery.setItemValue(dataDictItem.getItemValue());
				Query q = new Query(dataDictItemQuery);
				List<DataDictItem> dataDictItems=dataDictItemService.getDataDictItemList(q);
				if(dataDictItems.size()>0 && !dataDictItems.get(0).getDataDictItemId().equals(dataDictItem.getDataDictItemId())){
					resultInfo.setCode(Constant.FAIL);
					resultInfo.setMsg("数据字典项值有重复");
					return resultInfo;
				}
			}
			if (dataDictItem.getIsAvailable()!=null) {
				dataDictItem.setAvailableUpdateTime(new Date());
			}
			resultInfo= dataDictItemService.updateDataDictItem(dataDictItem, getOperator());
		}else {
			DataDictItem  dataDictItemQuery = new DataDictItem();
			dataDictItemQuery.setDataDictCatCode(dataDictItem.getDataDictCatCode());
			dataDictItemQuery.setItemValue(dataDictItem.getItemValue());
			Query q = new Query(dataDictItemQuery);
			List<DataDictItem> dataDictItems=dataDictItemService.getDataDictItemList(q);
			if(dataDictItems.size()>0 ){
				 resultInfo.setCode(Constant.FAIL);
				 resultInfo.setMsg("数据字典项值有重复");
				 return resultInfo;
			}
			resultInfo= dataDictItemService.addDataDictItem(dataDictItem, getOperator());
		}
		return resultInfo;
	}
	/**
	 * 数据字典分类查询
	 * 
	 * @param dataDictCat
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("getDataDictItems")
	@ResponseBody
	public ResultInfo<List<DataDictItem>> getDataDicts(){
		ResultInfo<List<DataDictItem>> result = new ResultInfo<>();
		DataDictItem dataDictItem = new DataDictItem();
		dataDictItem.setIsAvailable(1);
		dataDictItem.setIsDeleted(0);
		dataDictItem.setDataDictCatCode("UES_INSTACTION");
		List<DataDictItem> list = dataDictItemService.getDataDictItemList(new Query(dataDictItem));
		if (list.size()>0) {
			result.setCode("1");
			result.setData(list);
		}else {
			result.setCode("0");
			result.setMsg("暂无数据");
		}
		return result;
	}
	
	/**
	 * 数据字典分类查询
	 * 
	 * @param dataDictCat
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("getDataDictsBox")
	@ResponseBody
	public ResultInfo<List<DataDictItem>> getDataDictsBox(){
		ResultInfo<List<DataDictItem>> result = new ResultInfo<>();
		DataDictItem dataDictItem = new DataDictItem();
		dataDictItem.setIsAvailable(1);
		dataDictItem.setIsDeleted(0);
		dataDictItem.setDataDictCatCode("BOX_TYPE");
		List<DataDictItem> list = dataDictItemService.getDataDictItemList(new Query(dataDictItem));
		if (list.size()>0) {
			result.setCode("1");
			result.setData(list);
		}else {
			result.setCode("0");
			result.setMsg("暂无数据");
		}
		return result;
	}
	
	/**
	 * 数据字典项删除
	 * 
	 * @param dataDictCatId
	 * @return
	 */
	@RequestMapping("delDataDictItem")
	@ResponseBody
	public ResultInfo<DataDictItem> delDataDictItem(@RequestParam("dataDictItemId") String dataDictItemId) {
		return dataDictItemService.delDataDictItem(dataDictItemId, getOperator());
	}
}

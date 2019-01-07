package cn.com.fqy.controller.mgt;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.fqy.common.ResultInfo;
import cn.com.fqy.common.constants.Constant;
import cn.com.fqy.core.common.BaseController;
import cn.com.fqy.core.common.PageFinder;
import cn.com.fqy.core.model.DataDictCat;
import cn.com.fqy.core.model.Query;
import cn.com.fqy.core.service.DataDictCatService;
import cn.com.fqy.core.service.DataDictItemService;


@Controller
@RequestMapping("dataDictCat")
public class DataDictCatController extends BaseController {
	@Resource
	private DataDictCatService dataDictCatService;
	@Resource
	private DataDictItemService dataDictItemService;

	/**
	 * 数据字典分类查询
	 * 
	 * @param dataDictCat
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("getDataDictList")
	@ResponseBody
	public PageFinder<DataDictCat> dataDictPageList(@ModelAttribute("DataDictCat") DataDictCat dataDictCat, @RequestParam("pageNo") int pageNo,
			@RequestParam("pageSize") int pageSize) {
		Query q = new Query(pageNo, pageSize, dataDictCat);
		return dataDictCatService.getDataDictCatPagedList(q);
	}

	/**
	 * 数据字典分类增加
	 * 
	 * @param dataDictCat
	 * @return
	 */
	@RequestMapping("addOrEditDataDictCat")
	@ResponseBody
	public ResultInfo<DataDictCat> addOrEditDataDictCat(@ModelAttribute("DataDictCat") DataDictCat dataDictCat,String type) {
		ResultInfo<DataDictCat> resultInfo = new ResultInfo<DataDictCat>();
		if (dataDictCat.getDataDictCatCode()!=null&&!"".equals(dataDictCat.getDataDictCatCode())) {
			DataDictCat dtc =dataDictCatService.getDataDictCat(dataDictCat.getDataDictCatCode());
			if (type.equals("add")) {
				if(dtc != null){
					resultInfo.setCode(Constant.FAIL);
					resultInfo.setMsg("分类编码重复");
					return resultInfo;
				}else {
					resultInfo = dataDictCatService.addDataDictCat(dataDictCat, getOperator());
				}
			}else if(type.equals("edit")){
				resultInfo = dataDictCatService.updateDataDictCat(dataDictCat, getOperator());
			}else {
				resultInfo.setCode(Constant.FAIL);
				resultInfo.setMsg("参数错误");
				return resultInfo;
			}
		}else {
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg("分类编码为空");
		}
		return resultInfo;
	}

	/**
	 * 数据字典分类删除
	 * 
	 * @param dataDictCatCode
	 * @return
	 */
	@RequestMapping("delDataDict")
	@ResponseBody
	public ResultInfo<DataDictCat> delDataDict(@RequestParam("dataDictCatCode") String dataDictCatCode) {
		return dataDictCatService.delDataDictCat(dataDictCatCode, getOperator());
	}
	
	/**
	 * 数据字典分类查询
	 * 
	 * @param dataDictCat
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("getDataDicts")
	@ResponseBody
	public ResultInfo<List<DataDictCat>> getDataDicts(){
		ResultInfo<List<DataDictCat>> result = new ResultInfo<>();
		DataDictCat dataDictCat = new DataDictCat();
		dataDictCat.setIsAvailable(1);
		List<DataDictCat> list = dataDictCatService.getDataDictCatList(new Query(dataDictCat));
		if (list.size()>0) {
			result.setCode("1");
			result.setData(list);
		}else {
			result.setCode("0");
			result.setMsg("暂无数据");
		}
		return result;
	}
}

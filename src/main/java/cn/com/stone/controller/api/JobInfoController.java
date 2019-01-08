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
import cn.com.stone.common.constants.Constant;
import cn.com.stone.core.common.BaseController;
import cn.com.stone.core.common.PageFinder;
import cn.com.stone.core.model.Advert;
import cn.com.stone.core.model.JobInfo;
import cn.com.stone.core.model.Query;
import cn.com.stone.core.service.JobInfoService;

/**
 * 查询职称
 * @author Administrator
 *
 */
@Controller
@RequestMapping("web/job")
public class JobInfoController extends BaseController {

	@Resource
	private JobInfoService jobInfoService;
	
	@RequestMapping("getJobInfo")
	@ResponseBody
	public ResultInfo<List<JobInfo>> getJobInfo(JobInfo jobInfo){
		ResultInfo<List<JobInfo>> resultInfo = new ResultInfo<List<JobInfo>>();
		jobInfo.setIsDeleted(0);	//未删除
		Query q = new Query(jobInfo);
		PageFinder<JobInfo> pageResult = jobInfoService.getJobInfoPagedList(q);
		if(null != pageResult && pageResult.getData().size() > 0) {
			List<JobInfo> result = pageResult.getData();
			resultInfo.setData(result);
			resultInfo.setCode(Constant.SUCCESS);
			resultInfo.setMsg("请求成功");
		}else {
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg("暂无数据");
		}
		return resultInfo;

		
	}
	
}

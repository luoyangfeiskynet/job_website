package cn.com.stone.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.stone.common.ResultInfo;
import cn.com.stone.common.constants.Constant;
import cn.com.stone.common.util.ECCalculateUtils;


@Controller
@Component
@RequestMapping("upload")
public class UploadController {

	private static final Log log = LogFactory.getLog(UploadController.class);
	@Value("${image_path}")
	private String serverPath;
	@Value("${res_img_path}")
	private String storePath;
	@Resource
	HttpServletRequest request;

	@RequestMapping("deleteFile")
	@ResponseBody
	public ResultInfo<Object> deleteFile(@RequestParam("filePaths") String[] filePaths) {
		ResultInfo<Object> resultInfo = new ResultInfo<Object>();
		try {
			if (filePaths != null && filePaths.length > 0) {
				String resPath = request.getParameter("resPath");
				if (resPath == null || resPath.equals("")) {
					resPath = request.getRealPath(".");
				}
				for (String path : filePaths) {
					File file = new File(resPath + "/" + path);
					file.delete();
				}
				resultInfo.setCode(Constant.SUCCESS);
			} else {
				resultInfo.setCode(Constant.FAIL);
				resultInfo.setMsg("文件路径为空！");
			}
		} catch (Exception e) {
			resultInfo.setCode(Constant.FAIL);
			resultInfo.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return resultInfo;
	}

	// 处理文件上传
	@RequestMapping("uploadFile")
	@ResponseBody
	public ResultInfo<String> uploadImg(@RequestParam("files") MultipartFile file,@RequestParam("resPath") String resPath,String imageType, HttpServletRequest request) throws IOException {
		ResultInfo<String> result = new ResultInfo<>();
		//判断车辆品牌log尺寸
		if ("logo".equals(imageType)) {
			InputStream is = file.getInputStream();
			BufferedImage image = ImageIO.read(is);
			//宽高比
			double proportion = ECCalculateUtils.div(Double.valueOf(image.getWidth()), Double.valueOf(image.getHeight()));
			if (proportion !=1) {
				result.setCode("0");
				result.setMsg("上传图片的宽高比必须是1");
				return result;
			}
		}
		// 原文件名
		String oldName = file.getOriginalFilename();
		// 新文件名
		String newFileName = ECUuidGenUtils.genUUID();
		int idxSuffix = oldName.lastIndexOf(".");
		String suffix = oldName.substring(idxSuffix, oldName.length()).toLowerCase();
		String fileName = newFileName + suffix;
		// 文件存放路径
		String filePath = storePath + resPath + "/";

		// 调用文件处理类FileUtil，处理文件，将文件写入指定位置
		try {
			ECFileUtil.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
			result.setCode("0");
			result.setMsg("上传失败");
			return result;
		}
		// 返回文件的存放路径
		result.setCode("1");
		result.setData(serverPath+resPath+"/"+fileName);
		return result;
	}

	// 处理多文件上传
	@RequestMapping("uploadFiles")
	@ResponseBody
	public ResultInfo<List<String>> uploadFiles(@RequestParam("files") MultipartFile[] files,@RequestParam("resPath") String resPath,String imageType, HttpServletRequest request) throws IOException {
		ResultInfo<List<String>> result = new ResultInfo<>();
		List<String> list = new ArrayList<>();
		for(MultipartFile file:files) {
			// 原文件名
			String oldName = file.getOriginalFilename();
			// 新文件名
			String newFileName = ECUuidGenUtils.genUUID();
			int idxSuffix = oldName.lastIndexOf(".");
			String suffix = oldName.substring(idxSuffix, oldName.length()).toLowerCase();
			String fileName = newFileName + suffix;
			// 文件存放路径
			String filePath = storePath + resPath + "/";
			// 调用文件处理类FileUtil，处理文件，将文件写入指定位置
			try {
				//处理文件上传
				ECFileUtil.uploadFile(file.getBytes(), filePath, fileName);
			} catch (Exception e) {
				result.setCode("0");
				result.setMsg("上传失败");
				return result;
			}
			// 返回文件的存放路径
			String str=serverPath+resPath+"/"+fileName;
			list.add(str);
		}
		result.setCode("1");
		result.setData(list);
		return result;
	}
}

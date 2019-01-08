package cn.com.stone.utils;

import java.io.File;
import java.io.FileOutputStream;
/**
 * 文件上传工具类服务方法
 * @author fqy
 *
 */
public class ECFileUtil{

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception{

        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
package cn.com.stone.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class GetImageSizeUtil {
	public static Map<String,Integer> getImageSize(String filePath) {
		Map<String,Integer> imageInfoMap = new HashMap<String, Integer>();
		InputStream is = null;
        try {
        	 File file = new File(filePath);
             is = new FileInputStream(file);
             BufferedImage image = ImageIO.read(is);
             imageInfoMap.put("width", image.getWidth());
             imageInfoMap.put("height", image.getHeight());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close(); // 关闭流
                } catch (IOException e) {
                   e.printStackTrace();
                }
            }
        }
        return imageInfoMap;
	}
}

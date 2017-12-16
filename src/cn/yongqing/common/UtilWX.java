package cn.yongqing.common;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * <p>Title: 微信通用工具类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: yiyaosou.cc</p>
 * @author 董有红
 * @version 1.0
 */
public class UtilWX {
	
	 /** 保存access_token的文件 */
	private static File acFile;
    
    public static String accessToken() {
        if (acFile == null) {
        	acFile = new File("/var/www/ac.txt");
        }
        long lastTime = acFile.lastModified();

        long currTime = System.currentTimeMillis();
        long offset = currTime - lastTime;
        try {
	        if (offset > 600000) {
	        	// 7200 秒，微信服务器失效
	        	//String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc0ce7793dcdda406&secret=4dd4486b93b0b4da9863e93df6cc7ec0";
        	    String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxb2297274fe64e291&secret=69865cb557bb42cce8b011f94a73dca7";
	        	String result = UtilHttpClient.create().getString(url);
	        	result = result.replaceFirst("[\\s\\S]*\"access_token\":\"", "").replaceFirst("\",[\\s\\S]*", "");
	        	UtilCommon.writeOutput(result, acFile);
	        	return result;
	        } else {
	        	return UtilCommon.readInput(acFile);
	        }
        } catch (IOException e) {
        	e.printStackTrace();
        	return null;
        }
        
    }	
    
    
}

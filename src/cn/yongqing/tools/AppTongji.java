package cn.yongqing.tools;

import java.io.File;
import java.io.IOException;

import cn.yongqing.common.UtilCommon;

public class AppTongji {
	
	public void tongji() throws IOException {

		String filename = "d:\\znw_access.log";
		File file = new File(filename);
		String[] lines = UtilCommon.readInput(file).split("[\r\n]+");
		
		for (String line : lines) {
			int index = line.indexOf("app.action?v=1");
			if (index == -1)
				continue;
			System.out.println(line);
		}
	}
	
	public static void main(String[] args) {
		try {
			AppTongji dataLoad = new AppTongji();
			dataLoad.tongji();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

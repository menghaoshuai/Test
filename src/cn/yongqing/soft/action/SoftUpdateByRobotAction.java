package cn.yongqing.soft.action;

import java.io.File;
import java.io.IOException;

import cn.yongqing.base.BaseAction;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.soft.entity.SoftUpdateByRobot;

public class SoftUpdateByRobotAction extends BaseAction {

	private static final long serialVersionUID = 1565925898965L;

	public SoftUpdateByRobotAction() {
		base = new SoftUpdateByRobot();
	}

	//永清项目
	public String yqnewVersion() {

		SoftUpdateByRobot softUpdate = (SoftUpdateByRobot) base;
		File srcFile = new File("/var/www/html/btda/yqrobot");
		String maxName = "";
		try {
			boolean bFile = srcFile.exists();
			if (!bFile || !srcFile.isDirectory() || !srcFile.canRead()) {
				try {
					srcFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				File[] file = srcFile.listFiles();
				System.out.println(file.length);
				for (int i = 0; i < file.length; i++) {
					// File f = new File(srcFile, file[i].getName());
					String name = file[i].getName().substring(0,
							file[i].getName().lastIndexOf("."));
					if (UtilCommon.isNull(maxName)) {
						maxName = name;
					} else {
						int max = Integer.parseInt(maxName);
						int now = Integer.parseInt(name);
						if (max < now) {
							maxName = name;
						}
					}
				}
				System.out.println(maxName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		softUpdate.setVersion(maxName);
		softUpdate.setLink("btda/yqrobot/"+maxName+".apk");
		base = softUpdate;
		boolean result = this.json(); // 判断是否为Json

		if (result) {
			return JSON;
		}
		return JSON;
	}

}

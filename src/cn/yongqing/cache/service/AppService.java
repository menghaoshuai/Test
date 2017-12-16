package cn.yongqing.cache.service;

import java.io.File;

import cn.yongqing.common.UtilCommon;

public class AppService {
	
	private File appFile;
	
	private double version;
	
	public File file() {
		if (appFile == null) {
			String filename = UtilCommon.getFullPathRelateClass("../../../../../../", this.getClass());
			File file = new File(filename);
			file = new File(file, "app");
			File[] files = file.listFiles();
			double version = 0;
			for (File _file : files) {
				String name = _file.getName();
				name = name.replaceFirst("\\.apk", "");
				name = name.replaceFirst(".*_V", "");
				double _version = Double.parseDouble(name);
				if (_version > version) {
					file = _file;
					version = _version;
				}
			}
			appFile = file;
			this.version = version;
		}
		return appFile;
	}
	
	public double version () {
		if (this.version == 0) {
			String filename = UtilCommon.getFullPathRelateClass("../../../../../../", this.getClass());
			File file = new File(filename);
			file = new File(file, "app");
			File[] files = file.listFiles();
			double version = 0;
			for (File _file : files) {
				String name = _file.getName();
				name = name.replaceFirst("\\.apk", "");
				name = name.replaceFirst(".*_V", "");
				double _version = Double.parseDouble(name);
				if (_version > version) {
					version = _version;
				}
			}
			this.version = version;
		}
		return this.version;
	}
}

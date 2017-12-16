package cn.yongqing.cache.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.yongqing.cache.service.AppService;

import com.opensymphony.xwork2.ActionSupport;

public class AppAction extends ActionSupport {

	private static final long serialVersionUID = -132390906191172L;

	private String fileName;
	
	private AppService appService;
	
	private double version;

	public String execute() {
		return SUCCESS;
	}
	
	public String version() {
		version = appService.version();
		return "version";
	}

	// 文件下载
	public InputStream getDownloadFile() throws IOException {
		try {
		File file = appService.file();
		fileName = file.getName();
		InputStream inputStream = new FileInputStream(file);
		return inputStream;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
}

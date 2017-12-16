package cn.yongqing.cache.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.yongqing.common.UtilCommon;
import cn.yongqing.common.UtilHttp;

import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport {

	private static final long serialVersionUID = -132370191172L;

	private String bigImg;
	
	private String smallImg;

	public ImageAction() {
		
	}
	
	public String load() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String source = request.getParameter("img");
			if (!UtilCommon.isNull(source)) {
				bigImg = UtilHttp.saveMubiteBase64ImageFile(source);
				smallImg = UtilHttp.saveMubiteBase64SmallImageFile(source);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "load";
	}

	public String getBigImg() {
		if (bigImg == null)
			bigImg = "";
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	public String getSmallImg() {
		if (smallImg == null)
			smallImg = "";
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
}

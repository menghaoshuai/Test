package cn.yongqing.soft.entity;

import cn.yongqing.base.Base;

public class SoftUpdateByRobot extends Base {

	private static final long serialVersionUID = 11565155656565L;
	
	/** 版本号*/
	private String version;
	/** 链接地址*/
	private String link;
	/** 内容*/
	private String content;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

}

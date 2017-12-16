package cn.yongqing.problem.entity;

import cn.yongqing.base.Base;

public class ReplyDetail extends Base {

	private static final long serialVersionUID = 622365334834769L;

	/** code */
	private int code;
	
	/** 问题标题 */
	private int macthCode;

	/** 问题标题 */
	private String title;
	
	/** 问题详细内容 */
	private String introduce;
	
	private String ewmImg;
	

	/** 选择热度数量 */
	private int hotCount;

	public ReplyDetail() {
		
	}

	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getMacthCode() {
		return macthCode;
	}

	public void setMacthCode(int macthCode) {
		this.macthCode = macthCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getEwmImg() {
		return ewmImg;
	}

	public void setEwmImg(String ewmImg) {
		this.ewmImg = ewmImg;
	}

	public String getIntroduceForPrint() {
		if (introduce == null)
			return introduce;
		return introduce.replaceAll("<[^>]+>", "");
	}


	public int getHotCount() {
		return hotCount;
	}


	public void setHotCount(int hotCount) {
		this.hotCount = hotCount;
	}
}

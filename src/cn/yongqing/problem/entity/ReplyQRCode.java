package cn.yongqing.problem.entity;

import cn.yongqing.base.Base;

public class ReplyQRCode extends Base {

	private static final long serialVersionUID = 156546587484598L;
	
	/** 答案code*/
	private int ansCode;
	
	/** 二维码图片*/
	private byte[] ewmTu;
	
	/** 创建时间*/
	private long createTime;

	public int getAnsCode() {
		return ansCode;
	}

	public void setAnsCode(int ansCode) {
		this.ansCode = ansCode;
	}

	public byte[] getEwmTu() {
		return ewmTu;
	}

	public void setEwmTu(byte[] ewmTu) {
		this.ewmTu = ewmTu;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

}

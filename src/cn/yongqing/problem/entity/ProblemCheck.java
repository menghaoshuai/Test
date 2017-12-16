package cn.yongqing.problem.entity;

import cn.yongqing.base.Base;

public class ProblemCheck extends Base {

	private static final long serialVersionUID = 1223253348322769L;

	/** code */
	private int code;

	/** 匹配code */
	private int macthCode;
	
	/** 回答code */
	private int replyCode;

	public ProblemCheck() {
		
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

	public int getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}
}

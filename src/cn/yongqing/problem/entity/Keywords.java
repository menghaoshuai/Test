package cn.yongqing.problem.entity;

import cn.yongqing.base.Base;

public class Keywords extends Base {

	private static final long serialVersionUID = 125336587484598L;
	
	/** code*/
	private int code;
	
	/** keyword*/
	private String kw;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getKw() {
		return kw;
	}

	public void setKw(String kw) {
		this.kw = kw;
	}

}

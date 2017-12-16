package cn.yongqing.problem.entity;

import cn.yongqing.base.Base;

public class AIPrinter extends Base {

	private static final long serialVersionUID = 1223622334534769L;

	/** code */
	private int code;

	/** 机器人mac地址 */
	private String mac;
	
	/** 打印机邮箱 */
	private String email;

	/** 公安局名称 */
	private String name;

	public AIPrinter() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

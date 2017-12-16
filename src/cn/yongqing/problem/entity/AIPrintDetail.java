package cn.yongqing.problem.entity;

import java.util.List;

import cn.yongqing.base.Base;

public class AIPrintDetail extends Base {

	private static final long serialVersionUID = 1223622332534769L;

	/** code */
	private int code;

	/** 打印内容 */
	private String printHtml;
	
	/** 打印名称 */
	private String printName;
	
	/** 打印预览图  */
	private String printPreviews;

	private List<AIPrintDetail> printList;

	public AIPrintDetail() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPrintHtml() {
		return printHtml;
	}

	public void setPrintHtml(String printHtml) {
		this.printHtml = printHtml;
	}

	public String getPrintName() {
		return printName;
	}

	public void setPrintName(String printName) {
		this.printName = printName;
	}

	public String getPrintPreviews() {
		return printPreviews;
	}

	public void setPrintPreviews(String printPreviews) {
		this.printPreviews = printPreviews;
	}

	public List<AIPrintDetail> getPrintList() {
		return printList;
	}

	public void setPrintList(List<AIPrintDetail> printList) {
		this.printList = printList;
	}

}

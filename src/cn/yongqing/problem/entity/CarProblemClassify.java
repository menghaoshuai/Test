package cn.yongqing.problem.entity;

import java.util.List;

import cn.yongqing.base.Base;

public class CarProblemClassify extends Base {

	private static final long serialVersionUID = 1222365334834769L;

	/** code */
	private int code;

	/** 分类code*/
	private int classifyCode;
	
	/** 分类名称 */
	private String classifyName;

	/** 问题code */
	private int replyCode;
	
	/** 排序 */
	private int sort;
	
	private List<CarProblemClassify> classifyList;
	
	private List<CarReplyDetail> detailList;

	public CarProblemClassify() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getClassifyCode() {
		return classifyCode;
	}

	public void setClassifyCode(int classifyCode) {
		this.classifyCode = classifyCode;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public int getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public List<CarReplyDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<CarReplyDetail> detailList) {
		this.detailList = detailList;
	}

	public List<CarProblemClassify> getClassifyList() {
		return classifyList;
	}

	public void setClassifyList(List<CarProblemClassify> classifyList) {
		this.classifyList = classifyList;
	}

}

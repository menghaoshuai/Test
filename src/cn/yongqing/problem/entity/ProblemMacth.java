package cn.yongqing.problem.entity;

import java.util.ArrayList;
import java.util.List;

import cn.yongqing.base.Base;

public class ProblemMacth extends Base {

	private static final long serialVersionUID = 622465334874769L;

	/** code */
	private int code;
	
	/** 问题标题 */
	private String problemTitle;

	/** 精确匹配字符串（.*办|换|.*身份证.*） */
	private String exactMatch;
	
	/** 模糊匹配字符串（.*身份证.*） */
	private String fuzzyMatch;
	
	/** 匹配排序  */
	private int problemSort;

	private List<ReplyDetail> replyList;
	
	private int replyCode;
	
	private String ewmUrl;
	
	public String getEwmUrl() {
		return ewmUrl;
	}

	public void setEwmUrl(String ewmUrl) {
		this.ewmUrl = ewmUrl;
	}

	public ProblemMacth() {
		replyList = new ArrayList<ReplyDetail>();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	public String getExactMatch() {
		return exactMatch;
	}

	public void setExactMatch(String exactMatch) {
		this.exactMatch = exactMatch;
	}

	public String getFuzzyMatch() {
		return fuzzyMatch;
	}

	public void setFuzzyMatch(String fuzzyMatch) {
		this.fuzzyMatch = fuzzyMatch;
	}

	public List<ReplyDetail> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyDetail> replyList) {
		this.replyList = replyList;
	}

	public int getReplyCode() {
		return replyCode;
	}

	public void setReplyCode(int replyCode) {
		this.replyCode = replyCode;
	}

	public int getProblemSort() {
		return problemSort;
	}

	public void setProblemSort(int problemSort) {
		this.problemSort = problemSort;
	}

	public int compareTo(Base other) {
		ProblemMacth pm = (ProblemMacth) other;
		int thisSort = getProblemSort();
		int otherSort = pm.getProblemSort();
		int differ = thisSort - otherSort;
		int result = (int)Math.signum(differ);
		return result;
	}
}

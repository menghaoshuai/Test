package cn.yongqing.problem.entity;

import java.sql.Timestamp;

import cn.yongqing.base.Base;

public class ProblemRecord extends Base {

	private static final long serialVersionUID = 1223253348322769L;

	/** code */
	private int code;

	/** 问题标题 */
	private String problemContent;
	
	/** 问题详细内容 */
	private Timestamp createDate;

	public ProblemRecord() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getProblemContent() {
		return problemContent;
	}

	public void setProblemContent(String problemContent) {
		this.problemContent = problemContent;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}

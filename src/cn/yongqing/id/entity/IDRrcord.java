package cn.yongqing.id.entity;

import java.sql.Timestamp;
import java.util.List;

import cn.yongqing.base.Base;

public class IDRrcord extends Base {

	private static final long serialVersionUID = 1369879966325L;
	
	/** 身份证号*/
	private String shenFenZheng;
	
	/** 姓名*/
	private String name;
	
	/** 状态*/
	private byte status;
	
	/** 更新时间*/
	private Timestamp updateDate;
	
	private List<IDRrcord> list;
	
	private int totalPage;
	
	private int addNum;

	public int getAddNum() {
		return addNum;
	}

	public void setAddNum(int addNum) {
		this.addNum = addNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<IDRrcord> getList() {
		return list;
	}

	public void setList(List<IDRrcord> list) {
		this.list = list;
	}

	public String getShenFenZheng() {
		return shenFenZheng;
	}

	public void setShenFenZheng(String shenFenZheng) {
		this.shenFenZheng = shenFenZheng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}

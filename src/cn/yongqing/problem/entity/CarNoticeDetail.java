package cn.yongqing.problem.entity;

import java.sql.Timestamp;
import java.util.List;

import cn.yongqing.base.Base;

public class CarNoticeDetail extends Base {

	private static final long serialVersionUID = 622365334834769L;

	/** code */
	private int code;

	/** 公告标题 */
	private String title;
	
	/** 公告详细内容 */
	private String introduce;

	/** 选择热度数量 */
	private int hotCount;
	
	/** 公告发布时间 */
	private Timestamp createDate;
	
	private List<CarNoticeDetail> noticeList;

	public CarNoticeDetail() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public int getHotCount() {
		return hotCount;
	}

	public void setHotCount(int hotCount) {
		this.hotCount = hotCount;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public List<CarNoticeDetail> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<CarNoticeDetail> noticeList) {
		this.noticeList = noticeList;
	}

	
}

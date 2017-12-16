package cn.yongqing.office.entity;

import cn.yongqing.base.Base;

public class PoliceLikes extends Base {

	private static final long serialVersionUID = 1633697855556L;
	
	/**民警code*/
	private int policeCode;
	
	/**标签code*/
	private int tagCode;
	
	/**点赞数量*/
	private int likedCount;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoliceCode() {
		return policeCode;
	}

	public void setPoliceCode(int policeCode) {
		this.policeCode = policeCode;
	}

	public int getTagCode() {
		return tagCode;
	}

	public void setTagCode(int tagCode) {
		this.tagCode = tagCode;
	}

	public int getLikedCount() {
		return likedCount;
	}

	public void setLikedCount(int likedCount) {
		this.likedCount = likedCount;
	}

}

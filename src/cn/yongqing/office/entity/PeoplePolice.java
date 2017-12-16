package cn.yongqing.office.entity;

import java.util.List;

import cn.yongqing.base.Base;

public class PeoplePolice extends Base {

	private static final long serialVersionUID = 3658965455656561L;

	/**民警姓名*/
	private String name;
	
	/**民警照片*/
	private String photo;
	
	/**民警职务*/
	private String post;
	
	/**所属机关*/
	private int officeCode;
	
	private List<PoliceLikes> policeLikes;
	
	private int tagCode;

	public int getTagCode() {
		return tagCode;
	}

	public void setTagCode(int tagCode) {
		this.tagCode = tagCode;
	}

	public List<PoliceLikes> getPoliceLikes() {
		return policeLikes;
	}

	public void setPoliceLikes(List<PoliceLikes> policeLikes) {
		this.policeLikes = policeLikes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(int officeCode) {
		this.officeCode = officeCode;
	}
	
}

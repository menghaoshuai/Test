package cn.yongqing.problem.entity;

import cn.yongqing.base.Base;

public class FaceRecognitionInformation extends Base {

	private static final long serialVersionUID = 322425334874762L;

	/** code */
	private int code;
	
	/** 人脸识别ID */
	private String personID;

	/** 用户姓名 */
	private String name;
	
	/** 欢迎语 */
	private String positionName;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	
}

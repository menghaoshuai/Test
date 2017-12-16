package cn.yongqing.id.entity;

import java.sql.Timestamp;
import java.util.Date;

import cn.yongqing.base.Base;


public class UserInfo extends Base {

	private static final long serialVersionUID = -3415617082211384370L;

	public UserInfo () {
		address = "";
		signature = "";
		sex = "男";
		email = "";
		headImg = "";
		dateBirth = new Timestamp(System.currentTimeMillis());
	}
	
	/** 用户编号 */
	private int code;

	/** 用户昵称 */
	private String name;

	/** 用户性别 */
	private String sex;

	/** 手机号码 */
	private Long telphone;

	/** 用户密码 */
	private String password;

	/** 家庭地址 */
	private String address;

	/** 电子邮件 */
	private String email;

	/** 用户签名 */
	private String signature;

	/** 用户头像 */
	private String headImg;

	/** 注册日期 */
	private Timestamp createDate;

	/** 帐号状态 */
	private Byte status;

	/** 用户积分 */
	private int score;

	/** 连续签到天数 */
	private int arriveCount;

	/** 后台推送 */
	private Byte isActive;

	/** 用户来源 */
	private Byte source;

	/** 积分状态 */
	private Byte scoreStatus;

	/** 百度推送UserID */
	private String pushUserId;

	/** 百度推送ChannelID */
	private String pushChannelId;

	/** 设备类型 */
	private Byte pushType;

	/** 推送通道 */
	private String channel;

	/** 设备身份码 */
	private String imei;

	/** 用户生日 */
	private Date dateBirth;

	/** 用户旧密码 */
	private String oldPassword;

	/** 用户新密码 */
	private String newPassword;

	/** 用户新手机 */
	private Long newTelphone;
	
	/** 年龄*/
	private int age;
	
	/** userId*/
	private int userId;
	
	/** 互动专区讨论组id*/
	private int groupId;
	
	/** 互动专区讨论组名称*/
	private String groupName;
	
	/** 好友数量 */
	private int friendNum;
	
	/** 小组数量 */
	private int groupNum;
	
	/** 发布数量 */
	private int publishNum;
	
	/** 请求人的用户编号 */
	private int requestUserCode;
	
	/** 朋友状态 */
	private int friendStatus;
	
	public int getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(int friendStatus) {
		this.friendStatus = friendStatus;
	}

	public int getRequestUserCode() {
		return requestUserCode;
	}

	public void setRequestUserCode(int requestUserCode) {
		this.requestUserCode = requestUserCode;
	}

	public int getFriendNum() {
		return friendNum;
	}

	public void setFriendNum(int friendNum) {
		this.friendNum = friendNum;
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public int getPublishNum() {
		return publishNum;
	}

	public void setPublishNum(int publishNum) {
		this.publishNum = publishNum;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getTelphone() {
		return telphone;
	}

	public void setTelphone(Long telphone) {
		this.telphone = telphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getArriveCount() {
		return arriveCount;
	}

	public void setArriveCount(int arriveCount) {
		this.arriveCount = arriveCount;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	public Byte getSource() {
		return source;
	}

	public void setSource(Byte source) {
		this.source = source;
	}

	public Byte getScoreStatus() {
		return scoreStatus;
	}

	public void setScoreStatus(Byte scoreStatus) {
		this.scoreStatus = scoreStatus;
	}

	public String getPushUserId() {
		return pushUserId;
	}

	public void setPushUserId(String pushUserId) {
		this.pushUserId = pushUserId;
	}

	public String getPushChannelId() {
		return pushChannelId;
	}

	public void setPushChannelId(String pushChannelId) {
		this.pushChannelId = pushChannelId;
	}

	public Byte getPushType() {
		return pushType;
	}

	public void setPushType(Byte pushType) {
		this.pushType = pushType;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Long getNewTelphone() {
		return newTelphone;
	}

	public void setNewTelphone(Long newTelphone) {
		this.newTelphone = newTelphone;
	}

}

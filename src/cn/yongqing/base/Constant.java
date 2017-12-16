package cn.yongqing.base;

public class Constant {

	// userIndex.mobi?,result：{"repCode":"999999","repMsg":"加载失败!"}

	// http://112.64.173.178/YLYG/

	public static final String SUCCESS_CODE = "000000";
	public static final String EMPTY_CODE = "111111";
	public static final String FAIL_CODE = "999999";

	public static final String SHARAPATH = "phoneDrug_share";
	// cookies
	public static final String USERNAME = "userName";
	public static final String USERPASSWORD = "userPassword";
	public static final String USERPASSWORDREMEMBER = "userpasswordRemember";
	public static final String ISFIRST = "isfirst";
	/**
	 * 透传消息广播
	 */
	public static final String THROUGH_MESSAGE="com.bm.ylyg.through.message";
	/**
	 * 医院等级广播
	 */
	public static final String GRADE_MESSAGE="com.bm.ylyg.grade.message";
	/**
	 * 药品信息广播
	 */
	public static final String MEDICINE_MESSAGE="com.bm.ylyg.medicine.message";
	// 连接超时
	public static final int timeOut = 12000;
	// 建立连接
	public static final int connectOut = 12000;
	// 获取数据
	public static final int getOut = 60000;

	 public static final String path = "182.92.68.230:8888";
	// public static final String path = "10.58.178.90:8080";//
	/**
	 * 公司本地测试地址
	 */
//	public static final String path = "192.168.1.139:8080";
	// public static final String path = "192.168.1.138:8888";
//	 public static final String path = "192.168.1.57:8081";
	// http:// :8080/YLYG/mobi/UserService/resetPassword.mobi?telphone=13999991921&newPassword=111111

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/UserService/login.mobi? P3
	 */
	public static final String login = "http://" + path + "/YLYG/mobi/UserService/login.mobi?";
	/**
	 * http://10.58.178.50:8080/YLYG/mobi/SMService/sendMessage.mobi?telphone=15339202227 P3-1
	 */
	public static final String sendMessage = "http://" + path + "/YLYG/mobi/SMService/sendMessage.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/UserService/regeditUser.mobi? P3-1
	 */
	public static final String regeditUser = "http://" + path + "/YLYG/mobi/UserService/regeditUser.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/UserService/saveUser.mobi? P3-1 -1
	 */
	public static final String saveUser = "http://" + path + "/YLYG/mobi/UserService/saveUser.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/UserService/resetPassword.mobi? P3-2 -1
	 */
	public static final String resetPassword = "http://" + path + "/YLYG/mobi/UserService/resetPassword.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/MessageMobiService/getMessage.mobi?messageId=4
	 */
	public static final String getMessage = "http://" + path + "/YLYG/mobi/MessageMobiService/getMessage.mobi?";

	/**
	 * P4阳光社区列表
	 */
	public static final String ComplexTalkGroupList = "http://" + path + "/YLYG/mobi/TalkGroupService/complexTalkGroupList.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/UserService/userArrive.mobi?userId=12 P4阳光社区列表
	 */
	public static final String userArrive = "http://" + path + "/YLYG/mobi/UserService/userArrive.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/TopicService/saveTopice.mobi?
	 * 
	 * P4- 5 发帖
	 */
	public static final String saveTopice = "http://" + path + "/YLYG/mobi/TopicService/saveTopice.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/TopicService/getTopic.mobi?topicId=10&userId=12
	 * 
	 * P4- 6 帖子详情 富文本
	 */
	public static final String TopicServiceGetTopic = "http://" + path + "/YLYG/mobi/TopicService/getTopic.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/TopicService/getReplys.mobi?topicId=15737&page=1&rows=15
	 * 
	 * P4- 6 帖子详情 富文本
	 */
	public static final String getReplys = "http://" + path + "/YLYG/mobi/TopicService/getReplys.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/ReplyService/replyTopic.mobi?
	 * 
	 * P4- 6 - 2 帖子详情 帖子回复
	 */
	public static final String replyTopic = "http://" + path + "/YLYG/mobi/ReplyService/replyTopic.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/CollectService/collectTopic.mobi?topicId=12&userId=15 P4- 6 - 3
	 */
	public static final String collectTopic = "http://" + path + "/YLYG/mobi/CollectService/collectTopic.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/TopicService/shareTopic.mobi?topicId=15732 P4- 6 - 4
	 */
	public static final String shareTopic = "http://" + path + "/YLYG/mobi/TopicService/shareTopic.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/ReplyService/prefectReply.mobi?replyId=13&userId=12 P4- 6 - 4
	 */
	public static final String prefectReply = "http://" + path + "/YLYG/mobi/ReplyService/prefectReply.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/UserInfoService/friendInfo.mobi?userId=16&friendId=12 P4- 7
	 */
	public static final String friendInfo = "http://" + path + "/YLYG/mobi/UserInfoService/friendInfo.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/UserFriendService/findFriend.mobi? telphone=15895484865&userId=14
	 * 
	 * P6- 2 - 1
	 */
	public static final String findFriend = "http://" + path + "/YLYG/mobi/UserFriendService/findFriend.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/UserFriendService/addFriend.mobi?userId=15&friendId=12
	 */
	public static final String addFriend = "http://" + path + "/YLYG/mobi/UserFriendService/addFriend.mobi?";

	/**
	 * P4- 8
	 */
	public static final String TopicList = "http://" + path + "/YLYG/mobi/TopicService/topicList.mobi?";

	/**
	 * 
	 * http://10.58.178.50:8080/YLYG/mobi/TopicService/searchTopicList.mobi? P4- 9
	 */
	public static final String searchTopicList = "http://" + path + "/YLYG/mobi/TopicService/searchTopicList.mobi?";

	/**
	 * P10
	 */
	public static final String UserServiceUserIndex = "http://" + path + "/YLYG/mobi/UserService/userIndex.mobi?";

	// http://10.58.178.50:8080/YLYG/mobi/UserService/userIndex.mobi?userId=12

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/UserService/userInfo.mobi?userId=48 P10 - 1
	 */
	public static final String userInfo = "http://" + path + "/YLYG/mobi/UserService/userInfo.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/FamilyService/myFamily.mobi?page=1&rows=15&userId=12 P10 - 2
	 */
	public static final String myFamily = "http://" + path + "/YLYG/mobi/FamilyService/myFamily.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/FamilyService/familyInfo.mobi?familyId=1 P10 - 2 -1
	 */
	public static final String familyInfo = "http://" + path + "/YLYG/mobi/FamilyService/familyInfo.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/FamilyService/illList.mobi?page=1&rows=15&familyId=16 P10 - 2 -1
	 */
	public static final String illList = "http://" + path + "/YLYG/mobi/FamilyService/illList.mobi?";

	/**
	 * http://10.58.178.75:8080/YLYG/mobi/ReplyService/replyMe.mobi? P10 - 7 - 1
	 */
	public static final String replyMe = "http://" + path + "/YLYG/mobi/ReplyService/replyMe.mobi?";

	/**
	 * P10 - 9 top
	 */
	public static final String ScoreServiceMyScoreTop = "http://" + path + "/YLYG/mobi/ScoreService/myScoreTop.mobi?";

	/**
	 * P10 - 9 botton
	 */
	public static final String ScoreServiceMyScoreBottom = "http://" + path + "/YLYG/mobi/ScoreService/myScoreBottom.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/FamilyService/saveIll.mobi?
	 * 
	 * P10 - 2 - 1
	 */
	public static final String saveIll = "http://" + path + "/YLYG/mobi/FamilyService/saveIll.mobi?";
	public static final String updateIll = "http://" + path + "/YLYG/mobi/FamilyService/updateIll.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/TopicService/topicList.mobi?page=1&rows=15&userId=12
	 * 
	 * P10 - 3
	 */
	public static final String TopicServiceTopicList = "http://" + path + "/YLYG/mobi/TopicService/topicList.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/TopicService/replyTopicList.mobi?page=1&rows=15&userId=12
	 * 
	 * P10 - 3
	 */
	public static final String replyTopicList = "http://" + path + "/YLYG/mobi/TopicService/replyTopicList.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/CollectService/collectList.mobi?userId=15
	 * 
	 * P10 - 5
	 */
	public static final String collectList = "http://" + path + "/YLYG/mobi/CollectService/collectList.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/TalkGroupService/myTalkGroups.mobi?page=1&rows=15&userId=12
	 * 
	 * P10 - 6
	 */
	public static final String myTalkGroups = "http://" + path + "/YLYG/mobi/TalkGroupService/myTalkGroups.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/ScoreService/scoreConvert.mobi?userId=12&goodsId=8
	 * 
	 * P10 -9 - 3
	 */
	public static final String scoreConvert = "http://" + path + "/YLYG/mobi/ScoreService/scoreConvert.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/ScoreService/scoreConvert.mobi?userId=12&goodsId=8
	 * 
	 * P10 -9 - 3
	 */
	public static final String scoreConvertSave = "http://" + path + "/YLYG/mobi/ScoreService/scoreConvertSave.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/ScoreService/scoreOrder.mobi
	 * 
	 * P10 -9 - 5
	 */
	public static final String scoreOrder = "http://" + path + "/YLYG/mobi/ScoreService/scoreOrder.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/ScoreService/goodsInfo.mobi?goodsId=8
	 * 
	 * P10 -9 - 5
	 */
	public static final String goodsInfo = "http://" + path + "/YLYG/mobi/ScoreService/goodsInfo.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/AddressService/addressList.mobi?userId=12&page=1&rows=15
	 * 
	 * P10 -9 - 2 收货地址
	 */
	public static final String addressList = "http://" + path + "/YLYG/mobi/AddressService/addressList.mobi?";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/AddressService/saveAddress.mobi?
	 * 
	 * P10 -9 - 2 收货地址
	 */
	public static final String saveAddress = "http://" + path + "/YLYG/mobi/AddressService/saveAddress.mobi?";

	/**
	 * http://112.64.173.178/YLYG/mobi/ScoreService/scoreRule.mobi
	 * 
	 * P10 -9 - 4 积分规则
	 */
	public static final String scoreRule = "http://" + path + "/YLYG/mobi/ScoreService/scoreRule.mobi";

	/**
	 * http://10.58.178.75:8080/YLYG/mobi/PictureService/hotPictures.mobi
	 * 
	 * P11 收货地址
	 */
	public static final String hotPictures = "http://" + path + "/YLYG/mobi/PictureService/hotPictures.mobi";

	/**
	 * 删帖 http://10.58.178.50:8080/YLYG/mobi/ReplyService/deleteMyReply.mobi? topicId=1&userId=60
	 * 
	 * ( 之前 /YLYG/mobi/TopicService/deleteTopic.mobi?) P10 - 3
	 */
	public static final String deleteTopic = "http://" + path + "/YLYG/mobi/TopicService/deleteTopic.mobi";

	/**
	 * http://10.58.178.50:8080/YLYG/mobi/CollectService/deleteCollect.mobi?userId=231&topicId=15
	 */
	public static final String deleteCollect = "http://" + path + "/YLYG/mobi/CollectService/deleteCollect.mobi?";

	/**
	 * http://10.58.178.75:8080/YLYG/mobi/PictureService/talkGroupPictures.mobi
	 */
	public static final String talkGroupPictures = "http://" + path + "/YLYG/mobi/PictureService/talkGroupPictures.mobi";

	public static final String HOST = "http://" + path + "/YLYG/mobi/";
	public static final String SUGGEST_SERVICE = "SuggestService/save.mobi";
	public static final String UPDATE_PASSWORD = "UserService/updatePassword.mobi";
	/**
	 * 检查手机号是否注册
	 */
	public static final String SEND_MESSAGE = "SMService/sendMessage.mobi";
	public static final String UPDATE_TELPHONE = "UserService/updateTelphone.mobi";
	public static final String GET_TALK_GROUP = "TalkGroupService/getTalkGroup.mobi";
	public static final String LOGIN = "UserService/login.mobi";
	public static final String GROUP_LIST = "TalkGroupService/complexTalkGroupList.mobi";
	public static final String MY_GROUP = "TalkGroupService/myTalkGroupList.mobi";
	public static final String GROUP_MEMBER = "TalkGroupService/talkGroupMemberList.mobi";
	public static final String FRIEND_LIST = "UserInfoService/friendList.mobi";
	public static final String JOIN_GROUP = "TalkGroupService/joinTalkGroup.mobi";
	public static final String GET_NOTICE = "NoticeService/getNotice.mobi";
	public static final String EDIT_NOTICE = "NoticeService/editNotice.mobi";
	public static final String UPDATE_NAME = "TalkGroupService/updateName.mobi";
	public static final String UPDATE_TAG = "TalkGroupService/updateTag.mobi";
	public static final String EDIT_TALK_GROUP = "TalkGroupService/editTalkGroup.mobi";
	public static final String SILENCE_MEMBER = "TalkGroupService/silencedMember.mobi";
	public static final String DELETE_MEMBER = "TalkGroupService/deleteMember.mobi";
	public static final String SILENCE_ALL = "TalkGroupService/silencedAll.mobi";
	public static final String UPDATE_KEYWORD = "TalkGroupService/updateKeyword.mobi";
	public static final String MSG_SET_MEMBER = "TalkGroupService/msgSetMember.mobi";
	public static final String REPORT_TALK_GROUP = "ReportService/reportTalkGroup.mobi";
	public static final String FIND_FRIEND = "UserFriendService/findFriend.mobi";
	public static final String NEW_FRIEND_LIST = "UserFriendService/getWaitFriend.mobi";
	public static final String USER_INFO = "UserService/userInfo.mobi";
	public static final String UPDATE_USER = "UserService/updateUser.mobi";
	public static final String USER_MORE = "UserService/userMore.mobi";
	public static final String PUSH_SET = "UserService/updateActiveStatus.mobi";
	public static final String NEW_VERSION = "SoftService/newVersion.mobi";
	public static final String ADD_FRIEND = "UserFriendService/addFriend.mobi";
	public static final String ACCEPT_REQUEST = "UserFriendService/acceptRequest.mobi";
	public static final String REFUSE_REQUEST = "UserFriendService/refuseRequest.mobi";
	public static final String TOPIC_LIST = "TopicService/topicList.mobi";
	public static final String NEW_FRIEND_COUNT = "UserFriendService/newFriendCount.mobi";

	public static final String DESCRIPTOR = "com.umeng.share";

	public static final String SAVE_FAMILY = "http://" + path + "/YLYG/mobi/FamilyService/saveFamily.mobi?";

	/**
	 * 删除成员 http://10.58.178.50:8080/YLYG/mobi/FamilyService/deleteFamily.mobi?familyId=16
	 */
	public static final String DeleteFamily = "http://" + path + "/YLYG/mobi/FamilyService/deleteFamily.mobi?";

	/**
	 * 删除病历史 http://10.58.178.50:8080/YLYG/mobi/FamilyService/delete.mobi?
	 */
	public static final String FamilyServiceDelete = "http://" + path + "/YLYG/mobi/FamilyService/delete.mobi?";

	/**
	 * 删除病历史 http://10.58.178.50:8080/YLYG/mobi/FamilyService/illDetail.mobi?
	 */
	public static final String illDetail = "http://" + path + "/YLYG/mobi/FamilyService/illDetail.mobi?";

	// V1.2版新增接口
	/**
	 * 获取所有病友小组
	 */
	public static final String DISEASE_GROUP_LIST = "http://" + path + "/YLYG/mobi/DiseaseGroupService/queryDiseaseGroupList.mobi";
	/**
	 * 图片请求基础地址
	 */
	public static final String GET_IMAGE_BASE = "http://" + path + "/YLYG";
	/**
	 * 医生列表
	 */
	public static final String GET_DOCTORS_LIST = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryDoctorList.mobi";
	/**
	 * 疗法列表
	 */
	public static final String GET_THERAPY_LIST = "http://" + path + "/YLYG/mobi/TopicService/searchTopicList.mobi";
	/**
	 * 帖子内容
	 */
	public static final String GET_TOPIC_CONTENT = "http://" + path + "/YLYG/mobi/TopicService/getTopic.mobi?";
	/**
	 * 帖子回复
	 */
	public static final String GET_TOPIC_REPLY = "http://" + path + "/YLYG/mobi/TopicService/getReplys.mobi?";
	/**
	 * 提交医生点评
	 */
	public static final String SEND_DOCTOR_COMMENT = "http://" + path + "/YLYG/mobi/DoctorMobiService/saveDoctorInfo.mobi";
	/**
	 * 提交疗法分享
	 */
	public static final String SEND_THERAPY_COMMENT = "http://" + path + "/YLYG/mobi/TopicService/saveTopice.mobi?";
	/**
	 * 地区接口一级——省份
	 */
	public static final String GET_PROVINCE_LIST = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryProvinceList.mobi";
	/**
	 * 地区接口二级——城市
	 */
	// public static final String GET_CITY_LIST = "http://" + path +
	// "/YLYG/mobi/DoctorMobiService/queryCityList.mobi";
	/**
	 * 获得热门搜索列表
	 */
	public static final String GET_HOT_LABELS = "http://" + path + "/YLYG/mobi/DiseaseGroupService/queryHotInfoList.mobi";
	/**
	 * 搜索关键字
	 */
	public static final String HOT_SEARCH = "http://" + path + "/YLYG/mobi/DoctorMobiService/popularSearch.mobi";
	/**
	 * 帖子点赞
	 */
	public static final String TOPIC_ADD_PRAISE = "http://" + path + "/YLYG/mobi/TopicService/prefectTopic.mobi";
	/**
	 * 帖子取消点赞
	 */
	public static final String TOPIC_SUB_PRAISE = "http://" + path + "/YLYG/mobi/TopicService/prefectTopicSubNum.mobi";
	/**
	 * 完善用户信息
	 */
	public static final String SEND_USER_DATE = "http://" + path + "/YLYG/mobi/UserService/saveUser.mobi";
	/**
	 * 获取个性标签列表
	 */
	public static final String GET_TAG_LIST = "http://" + path + "/YLYG/mobi/UserService/getUserConcernsTable.mobi";
	/**
	 * 提交用户标签
	 */
	public static final String SEND_USER_TAG = "http://" + path + "/YLYG/mobi/UserService/personalitySave.mobi";
	/**
	 * 就医分享页轮播图
	 */
	public static final String GET_SHARE_BANNER = "http://" + path + "/YLYG/mobi/PictureService/talkGroupPictures.mobi";
	/**
	 * 查询最大版本号
	 */
	public static final String GET_NEW_VERDION = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryMaxVersion.mobi";
	/**
	 * 医院等级列表
	 */
	public static final String GET_GRADE_LIST = "http://" + path + "/YLYG/mobi/DiseaseGroupService/queryHospitalLevelList.mobi";
	/**
	 * 医院列表（省份，等级）
	 */
	public static final String GET_HOSPITAL_LIST = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryHospitalName.mobi";
	/**
	 * 科室列表
	 */
	public static final String GET_DEPARTMENT_LIST = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryDepartment.mobi";
	/**
	 * 医生列表
	 */
	public static final String GET_DOCTOR_LIST = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryDoctorName.mobi";
	/**
	 * 查询城市列表
	 */
	public static final String GET_CITY_LIST = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryProvinceList.mobi";
	/**
	 * 查询医生详情
	 */
	public static final String GET_DOCTOR_DETAILS = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryDoctorDetail.mobi";
	/**
	 * 查询医生评论
	 */
	public static final String GET_DOCTOR_REPLY = "http://" + path + "/YLYG/mobi/DoctorMobiService/getSDoctorComment.mobi";
	/**
	 * 查询医生评论数
	 */
	public static final String GET_DOCTOR_REPLY_COUNT = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryDoctorCommontCount.mobi";
	/**
	 * 增加医生点评点赞
	 */
	public static final String DOCTOR_REPLY_PRAISE_UP = "http://" + path + "/YLYG/mobi/DoctorMobiService/doctorReplyPrefect.mobi";
	/**
	 * 取消医生评论点赞
	 */
	public static final String DOCTOR_REPLY_PRAISE_DOWN = "http://" + path + "/YLYG/mobi/DoctorMobiService/doctorReplyPrefectSubNum.mobi";
	/**
	 * 发送医生点评
	 */
	public static final String SEND_DOCTOR_REPLY = "http://" + path + "/YLYG/mobi/DoctorMobiService/doctorCommentsave.mobi";
	/**
	 * 医生热门关键字
	 */
	public static final String DOCTOR_SEARCH_LABELS = "http://" + path + "/YLYG/mobi/DiseaseGroupService/queryHotWordList.mobi";
	/**
	 * 医生本地搜索
	 */
	public static final String DOCTOR_LOCAL_SEARCH = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryLocalDoctorInfo.mobi";
	/**
	 * 医生全国搜索
	 */
	public static final String DOCTOR_COUNTRY_SEARCH = "http://" + path + "/YLYG/mobi/DoctorMobiService/queryAllDcotorInfo.mobi";
	/**
	 * 轮播图详情
	 */
	public static final String GET_BANNER_DETAILS = "http://" + path + "/YLYG/mobi/PictureService/findDetailPictureById.mobi";
	/**
	 * 轮播图评论
	 */
	public static final String GET_BANNER_REPLY = "http://" + path + "/YLYG/mobi/PictureService/findReplyCarousel.mobi";
	/**
	 * 添加轮播图评论
	 */
	public static final String ADD_BANNER_REPLY = "http://" + path + "/YLYG/mobi/PictureService/saveReplyCarousel.mobi";
	/**
	 * 增加轮播图评论点赞
	 */
	public static final String BANNER_REPLY_PRAISE_UP = "http://" + path + "/YLYG/mobi/CommonMobiService/commonReplyPrefect.mobi";
	/**
	 * 取消轮播图点赞
	 */
	public static final String BANNER_REPLY_PRAISE_DOWN = "http://" + path + "/YLYG/mobi/CommonMobiService/commonReplyPrefectSubNum.mobi";
	/**
	 * 查询我的回应
	 */
	public static final String QUERY_MY_REPLY = "http://" + path + "/YLYG/mobi/TopicService/respondList.mobi";
	/**
	 * 查询我的发表
	 */
	public static final String QUERY_MY_SEND = "http://" + path + "/YLYG/mobi/TopicService/sendList.mobi";
	/**
	 * 删除我的回应
	 */
	public static final String DELETE_MY_REPLY = "http://" + path + "/YLYG/mobi/ReplyService/deleteMyReply.mobi";
	/**
	 * 查询我的积分
	 */
	public static final String QUERY_MY_SCORE = "http://" + path + "/YLYG/mobi/ScoreService/findmyscore.mobi";
	/**
	 * 查询兑换规则
	 */
	public static final String QUERY_EXCHANGE_RULE = "http://" + path + "/YLYG/mobi/ScoreService/findBScoreDetail.mobi";
	/**
	 * 查询兑换列表
	 */
	public static final String QUERY_EXCHANGE_LIST = "http://" + path + "/YLYG/mobi/ScoreService/findExchangeScore.mobi";
	/**
	 * 添加兑换账户
	 */
	public static final String ADD_PAY_ACCOUNT = "http://" + path + "/YLYG/mobi/ScoreService/saveExchangeScore.mobi";
	/**
	 * 分享轮播图
	 */
	public static final String SHARE_BANNER="http://"+path+"/YLYG/mobi/PictureService/userSharePicture.do?";
	/**
	 * 分享医生
	 */
	public static final String SHARE_DOCTOR="http://"+path+"/YLYG/mobi/DoctorMobiService/userShareDoctor.do?";
	/**
	 * 帖子分享积分
	 */
	public static final String TOPIC_SHARE_SCORE="http://"+path+"/YLYG/mobi/TopicService/shareTopic.mobi";
	/**
	 * 轮播图分享积分
	 */
	public static final String BANNER_SHARE_SCORE="http://"+path+"/YLYG/mobi/PictureService/userSharePicture.do";
	/**
	 * 医生分享积分
	 */
	public static final String DOCTOR_SHARE_SCORE="http://"+path+"/YLYG/mobi/DoctorMobiService/userShareDoctor.do";
	/**
	 * 查询本期话题
	 */
	public static final String QUERY_TOP_TOPIC="http://"+path+"/YLYG/mobi/PictureService/hotPicturesTopic.mobi";
	/**
	 * 查询精选疗法
	 */
	public static final String QUERY_HOT_TOPICS="http://"+path+"/YLYG/mobi/TopicService/newHotSearchTopic.mobi";
	/**
	 * 查询往期话题
	 */
	public static final String QUERY_OLD_TOPICS="http://"+path+"/YLYG/mobi/PictureService/hotPicturesTopicList.mobi";
	/**
	 * 查询热门讨论组
	 */
	public static final String QUERY_HOT_GROUPS="http://"+path+"/YLYG/mobi/DiseaseGroupService/hotTalkGroup.mobi";
	/**
	 * 查询药品详情
	 */
	public static final String QUERY_MEDICINE_DETAILS="http://"+path+"/YLYG/mobi/DrugMobiService/querDrugDetailInfo.mobi";
	/**
	 * 根据条件查询药品
	 */
	public static final String QUERY_MEDICINE_BY_CONDITION="http://"+path+"/YLYG/mobi/DrugMobiService/queryDrug.mobi";
	/**
	 * 药品查询的疾病条件
	 */
	public static final String QUERY_MEDICINE_BY_DISEASE="http://"+path+"/YLYG/mobi/DrugMobiService/queryIllname.mobi";
	/**
	 * 药品模糊查询
	 */
	public static final String QUERY_MEDICINE_FUZZY="http://"+path+"/YLYG/mobi/DrugMobiService/likeQueryDrug.mobi";
	/**
	 * 药品联想
	 */
	public static final String MEDICINE_ASSOCIATE="http://"+path+"/YLYG/mobi/DrugMobiService/thinkDrug.mobi";
	/**
	 * 查询药品评论
	 */
	public static final String QUERY_MEDICINE_REPLY="http://"+path+"/YLYG/mobi/DrugMobiService/queryDrugReplyList.mobi";
	/**
	 * 发送药品点评
	 */
	public static final String SEND_MEDICINE_EVLUATE="http://"+path+"/YLYG/mobi/DrugMobiService/saveDrugReply.mobi";
	/**
	 * 查询群组内部banner
	 */
	public static final String QUERY_GROUP_BANNER="http://"+path+"/YLYG/mobi/DrugMobiService/drugPictures.mobi";
	/**
	 * 发送药品分享成功信息
	 */
	public static final String SEND_MEDICINE_SHARE="http://"+path+"/YLYG/mobi/DrugMobiService/shareDrug.mobi";
	/**
	 * 药品分享路径
	 */
	public static final String SHARE_MEDICINE="http://"+path+"/YLYG/mobi/DrugMobiService/queryShareDrug.do";
	/**
	 * 用药好评榜
	 */
	public static final String QUERY_MEDICINE_GOOD="http://"+path+"/YLYG/mobi/DrugMobiService/hotGoodDrug.mobi";
}	

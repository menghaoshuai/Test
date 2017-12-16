package cn.yongqing.problem.service;

import java.util.ArrayList;
import java.util.List;

import cn.yongqing.base.Base;
import cn.yongqing.base.BaseCache;
import cn.yongqing.base.BaseService;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.problem.dao.ProblemDao;
import cn.yongqing.problem.entity.AIPrintDetail;
import cn.yongqing.problem.entity.AIPrinter;
import cn.yongqing.problem.entity.CarNoticeDetail;
import cn.yongqing.problem.entity.CarProblemClassify;
import cn.yongqing.problem.entity.CarProblemMacth;
import cn.yongqing.problem.entity.FaceRecognitionInformation;
import cn.yongqing.problem.entity.NoticeDetail;
import cn.yongqing.problem.entity.ProblemClassify;
import cn.yongqing.problem.entity.ProblemMacth;
import cn.yongqing.problem.entity.ReplyDetail;
import cn.yongqing.problem.entity.ReplyQRCode;

public class ProblemService extends BaseService {

	/** 匹配问题答案 */
	public ProblemMacth updateHotCountByqueryProblemReply(ProblemMacth model) {
		ProblemDao dao = (ProblemDao) baseDao;
		List<ReplyDetail> resultList = new ArrayList<ReplyDetail>();
		String problem = model.getProblemTitle();
		List<Base> macthList = BaseCache.create().getCache(
				ProblemMacth.class);
		for(Base base : macthList){ //精确匹配
			ProblemMacth models = (ProblemMacth)base;
			if(problem.matches(models.getExactMatch())){
				models = dao.queryPrblemReply(models);
				return models;
			}
		}

		for(Base base : macthList){ //模糊匹配
				ProblemMacth models = (ProblemMacth)base;
			if(problem.matches(models.getFuzzyMatch())){
				resultList.add(dao.queryFuzzyPrblemReply(models));
			}
		}
		model.setReplyList(resultList);
		return model;
	}

	/** 增加新问题 */
	public ProblemMacth insertProblemRecord(ProblemMacth model) {
		ProblemDao dao = (ProblemDao) baseDao;
		System.out.println("current mac address:" + model.getEwmUrl());
		String problemContent = model.getProblemTitle(); 
		if (UtilCommon.isNull(problemContent))
			problemContent = "暂无记录";
		model = dao.insertProblemRecord(problemContent);
		return model;
	}
	
	/** 增加选择问题记录 */
	public ProblemMacth insertProblemCheck(ProblemMacth model) {
		ProblemDao dao = (ProblemDao) baseDao;
		int macthCode = model.getCode();
		int replyCode = model.getReplyCode();
		model = dao.insertProblemCheck(macthCode,replyCode);
		return model;
	}

	public ReplyQRCode selectQRCode(int ansCode) {
		ProblemDao dao = (ProblemDao) baseDao;
		return dao.selectQRCode(ansCode);
	}

	public void insertQRCode(ReplyQRCode qrCode) {
		ProblemDao dao = (ProblemDao) baseDao;
		dao.insertQRCode(qrCode);
	}

	public void updateQRCode(ReplyQRCode qrCode) {
		ProblemDao dao = (ProblemDao) baseDao;
		dao.updateQRCode(qrCode);
	}

//	/** 查询某条消息 */
//	public ProblemMacth selectProblemMacthByCode(ProblemMacth model) {
//		ProblemMacthDao dao = (ProblemMacthDao) baseDao;
//		UserInfo userInfo = UtilHttp.getUserInfo();
//		model.setUserCode(userInfo.getCode());
//		model = dao.selectProblemMacthByCode(model);
//		return model;
//	}
//
//	/** 删除消息 */
//	public ProblemMacth deleteProblemMacth(ProblemMacth model) {
//		ProblemMacthDao dao = (ProblemMacthDao) baseDao;
//		UserInfo userInfo = UtilHttp.getUserInfo();
//		if (userInfo == null) {
//			throw new DaoException("未登陆账户");
//		}
//		model.setUserCode(userInfo.getCode());
//		model = dao.deleteProblemMacth(model);
//		return model;
//	}

	/** 人脸识别 */
	public FaceRecognitionInformation queryFaceRecognitionInformation(FaceRecognitionInformation model) {
		List<Base> faceList = BaseCache.create().getCache(
				FaceRecognitionInformation.class);
		for(Base base : faceList){ //匹配
			FaceRecognitionInformation models = (FaceRecognitionInformation)base;
			if(models.getPersonID().equals(model.getPersonID())){
				return models;
			}
		}
		return null;
	}
	
	/** 返回办事公告列表页 */
	public NoticeDetail queryNoticeDetailList(NoticeDetail model) {
		ProblemDao dao = (ProblemDao) baseDao;
		return dao.queryNoticeDetailList(model);
	}
	
	/** 返回问题分类列表页 */
	public ProblemClassify queryProblemClassifyList(ProblemClassify model) {
		ProblemDao dao = (ProblemDao) baseDao;
		return dao.queryProblemClassifyList(model);
	}
	
	/** 根据mac查询对象 */
	public AIPrinter queryAIPrinterMac(AIPrinter model) {
		ProblemDao dao = (ProblemDao) baseDao;
		return dao.queryAIPrinterMac(model);
	}
	
	/** 查询打印列表 */
	public AIPrintDetail queryAIPrintList(AIPrintDetail model) {
		ProblemDao dao = (ProblemDao) baseDao;
		return dao.queryAIPrintList(model);
	}
	
	/** 根据code查询打印详情 */
	public AIPrintDetail queryAIPrintDetail(AIPrintDetail model) {
		ProblemDao dao = (ProblemDao) baseDao;
		return dao.queryAIPrintDetail(model);
	}
	
	/** 匹配问题答案 */
	public ProblemMacth updateHotCountByqueryCarProblemReply(ProblemMacth model) {
		ProblemDao dao = (ProblemDao) baseDao;
		List<ReplyDetail> resultList = new ArrayList<ReplyDetail>();
		String problem = model.getProblemTitle();
		List<Base> macthList = BaseCache.create().getCache(
				CarProblemMacth.class);
		for(Base base : macthList){ //精确匹配
			CarProblemMacth models = (CarProblemMacth)base;
			ProblemMacth macthModel = new ProblemMacth();
			macthModel.setCode(models.getCode());
			macthModel.setProblemTitle(models.getProblemTitle());
			macthModel.setExactMatch(models.getExactMatch());
			macthModel.setFuzzyMatch(models.getFuzzyMatch());
			macthModel.setProblemSort(models.getProblemSort());
			if(problem.matches(models.getExactMatch())){
				macthModel = dao.queryCarPrblemReply(macthModel);
				return macthModel;
			}
		}

		for(Base base : macthList){ //模糊匹配
			CarProblemMacth models = (CarProblemMacth) base;
			ProblemMacth macthModel = new ProblemMacth();
			macthModel.setCode(models.getCode());
			macthModel.setProblemTitle(models.getProblemTitle());
			macthModel.setExactMatch(models.getExactMatch());
			macthModel.setFuzzyMatch(models.getFuzzyMatch());
			macthModel.setProblemSort(models.getProblemSort());
			if(problem.matches(models.getFuzzyMatch())){
				resultList.add(dao.queryCarFuzzyPrblemReply(macthModel));
			}
		}
		model.setReplyList(resultList);
		return model;
	}
	
	/** 返回问题分类列表页 */
	public CarProblemClassify queryCarProblemClassifyList(CarProblemClassify model) {
		ProblemDao dao = (ProblemDao) baseDao;
		return dao.queryCarProblemClassifyList(model);
	}
	
	/** 返回办事公告列表页 */
	public CarNoticeDetail queryCarNoticeDetailList(CarNoticeDetail model) {
		ProblemDao dao = (ProblemDao) baseDao;
		return dao.queryCarNoticeDetailList(model);
	}
}

package cn.yongqing.problem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.yongqing.base.BaseDao;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.common.UtilDao;
import cn.yongqing.problem.entity.AIPrintDetail;
import cn.yongqing.problem.entity.AIPrinter;
import cn.yongqing.problem.entity.CarNoticeDetail;
import cn.yongqing.problem.entity.CarProblemClassify;
import cn.yongqing.problem.entity.CarReplyDetail;
import cn.yongqing.problem.entity.NoticeDetail;
import cn.yongqing.problem.entity.ProblemCheck;
import cn.yongqing.problem.entity.ProblemClassify;
import cn.yongqing.problem.entity.ProblemMacth;
import cn.yongqing.problem.entity.ProblemRecord;
import cn.yongqing.problem.entity.ReplyDetail;
import cn.yongqing.problem.entity.ReplyQRCode;

public class ProblemDao extends BaseDao {

	/** 精确匹配问题答案 */
	public ProblemMacth queryPrblemReply(ProblemMacth model) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = getSession().connection();
			st = conn.createStatement();
			String sql = "select code, title, introduce from ReplyDetail where macthCode=" +  model.getCode();
			rs = st.executeQuery(sql);
			ReplyDetail detail = null;
			if (rs.next()) {
				detail = new ReplyDetail();
				detail.setCode(rs.getInt("code"));
				detail.setIntroduce(rs.getString("introduce"));
				detail.setTitle(rs.getString("title"));
			}
			rs.close();
			if (detail == null) {
				return model;
			}
			
			List<ReplyDetail> list = new ArrayList<ReplyDetail>();
			list.add(detail);
			model.setReplyList(list);
			
			sql = "update ReplyDetail set hotCount=hotCount+1 where code = " + detail.getCode();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(rs);
			UtilDao.close(st);
		}
		return model;
		
		
	}
	
	/** 模糊匹配问题答案 */
	public ReplyDetail queryFuzzyPrblemReply(ProblemMacth model) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ReplyDetail detail = null;
		try {
			conn = getSession().connection();
			st = conn.createStatement();
			String sql = "select code, title, introduce from ReplyDetail where macthCode=" +  model.getCode();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				detail = new ReplyDetail();
				detail.setCode(rs.getInt("code"));
				detail.setIntroduce(rs.getString("introduce"));
				detail.setTitle(rs.getString("title"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(rs);
			UtilDao.close(st);
		}
		return detail;
	}
	
	/** 新增问题 */
	public ProblemMacth insertProblemRecord(String problemContent) {
		ProblemRecord pr = new ProblemRecord();
		pr.setProblemContent(problemContent);
		pr.setCreateDate(new Timestamp(System.currentTimeMillis()));
		insert(pr);
		return null;
	}
	
	/** 新增选择记录 */
	public ProblemMacth insertProblemCheck(int macthCode,int replyCode) {
		ProblemCheck pc = new ProblemCheck();
		pc.setMacthCode(macthCode);
		pc.setReplyCode(replyCode);
		insert(pc);
		return null;
	}
	
//	/** 查询消息根据Code */
//	public UserMessage selectUserMessageByCode(UserMessage model) {
//		String hql = "from " + UserMessage.class.getName() + " where code = "
//				+ model.getCode();
//		HibernateTemplate template = getHibernateTemplate();
//		@SuppressWarnings("unchecked")
//		List<UserMessage> list = template.find(hql);
//		if (list.size() == 0) {
//			return null;
//		} else {
//			List<Company> companyList = new ArrayList<Company>();
//			ScrapEnergyDao scrapEnergyDao = (ScrapEnergyDao) SpringLocator
//					.create().getBean("scrapEnergyDao");
//			Company company = scrapEnergyDao.selectCompany(list.get(0).getCompanyCode());
//			companyList.add(company);
//			list.get(0).setCompalyList(companyList);
//			model.setUserMessageList(list);
//			return model;
//		}
//	}
//	
//	/** 删除消息 */
//	public UserMessage deleteUserMessage(UserMessage model) {
//		try {
//			UserMessage models = selectUserMessageByCode(model);
//			delete(models);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		if (model != null) {
//			throw new DaoException("删除订单失败!");
//		} else {
//			return null;
//		}
//	}

	public ReplyQRCode selectQRCode(int ansCode) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ReplyQRCode qrCode = null;
		try {
			conn = this.getSession().connection();
			st = conn.createStatement();
			String sql = "select * from ReplyQRCode where ansCode="+ansCode;
			rs = st.executeQuery(sql);
			if(rs.next()){
				qrCode = new ReplyQRCode();
				qrCode.setCode(rs.getInt("code"));
				qrCode.setAnsCode(rs.getInt("ansCode"));
				qrCode.setEwmTu(rs.getBytes("ewmTu"));
			    qrCode.setCreateTime(rs.getLong("createTime"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(rs);
			UtilDao.close(st);
		}
		return qrCode;
	}

	public void insertQRCode(ReplyQRCode qrCode) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = this.getSession().connection();
			String sql = "insert into ReplyQRCode (ansCode,ewmTu,createTime) values (?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, qrCode.getAnsCode());
			pst.setBytes(2, qrCode.getEwmTu());
			pst.setLong(3, qrCode.getCreateTime());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(pst);
		}
	}

	public void updateQRCode(ReplyQRCode qrCode) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = this.getSession().connection();
			String sql = "update ReplyQRCode set ewmTu=?,createTime=? where code=?";
			pst = conn.prepareStatement(sql);
			pst.setBytes(1, qrCode.getEwmTu());
			pst.setLong(2, qrCode.getCreateTime());
			pst.setInt(3, qrCode.getCode());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(pst);
		}
	}
	
	/** 问题热度加一*/
	public void updateReplyDetailByCode1(int code) {
		Connection conn = null;
		Statement st = null;
		try {
			conn = getSession().connection();
			st = conn.createStatement();
			String sql = "update ReplyDetail set hotCount=hotCount+1 where code = " + code;
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(st);
		}
	}
	
	/** 查看办事公告列表页 */
	public NoticeDetail queryNoticeDetailList(NoticeDetail model) {
		String hql = "from " + NoticeDetail.class.getName() ;
		HibernateTemplate template = getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<NoticeDetail> list = template.find(hql);
		if (list.size() == 0) {
			return null;
		} else {
			model.setNoticeList(list);
		}
		return model;
	}
	
	/** 查看问题分类列表页 */
	public ProblemClassify queryProblemClassifyList(ProblemClassify model) {
		List<ProblemClassify> classifyList = new ArrayList<ProblemClassify>();
		String hql = "from " + ProblemClassify.class.getName() + " where code in (1,7,15,23,30)";
		HibernateTemplate template = getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<ProblemClassify> list = template.find(hql);
		if (list.size() == 0) {
			return null;
		} else {
			for (ProblemClassify classify : list){
				hql = "from " + ReplyDetail.class.getName() + " where code in (select replyCode from " + ProblemClassify.class.getName() + " where classifyCode = " + classify.getClassifyCode() + ")";
				@SuppressWarnings("unchecked")
				List<ReplyDetail> detailList = template.find(hql);
				classify.setDetailList(detailList);
				classifyList.add(classify);
			}
			model.setClassifyList(classifyList);
		}
		return model;
	}
	
	/** 根据mac查询对象 */
	public AIPrinter queryAIPrinterMac(AIPrinter model) {
		String hql = "from " + AIPrinter.class.getName() + " where mac = '" + model.getMac() +"'";
		HibernateTemplate template = getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<AIPrinter> list = template.find(hql);
		if (list.size() == 0) {
			return null;
		}
		model = list.get(0);
		return model;
	}
	
	/** 查询打印列表 */
	public AIPrintDetail queryAIPrintList(AIPrintDetail model) {
		String hql = "from " + AIPrintDetail.class.getName();
		HibernateTemplate template = getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<AIPrintDetail> list = template.find(hql);
		if (list.size() == 0) {
			return null;
		}
//		for(AIPrintDetail detail : list){
//			detail.setPrintHtml("");
//			result.add(detail);
//		}
		model.setPrintList(list);
		return model;
	}
	
	/** 根据code查询打印详情 */
	public AIPrintDetail queryAIPrintDetail(AIPrintDetail model) {
		HibernateTemplate template = getHibernateTemplate();
		model = (AIPrintDetail)template.get(AIPrintDetail.class, model.getCode());
		if (UtilCommon.isNull(model)) {
			return null;
		}
		return model;
	}
	
	/** 精确匹配问题答案 */
	public ProblemMacth queryCarPrblemReply(ProblemMacth model) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = getSession().connection();
			st = conn.createStatement();
			String sql = "select code, title, introduce from CarReplyDetail where macthCode=" +  model.getCode();
			rs = st.executeQuery(sql);
			ReplyDetail detail = null;
			if (rs.next()) {
				detail = new ReplyDetail();
				detail.setCode(rs.getInt("code"));
				detail.setIntroduce(rs.getString("introduce"));
				detail.setTitle(rs.getString("title"));
			}
			rs.close();
			if (detail == null) {
				return model;
			}
			
			List<ReplyDetail> list = new ArrayList<ReplyDetail>();
			list.add(detail);
			model.setReplyList(list);
			
			sql = "update ReplyDetail set hotCount=hotCount+1 where code = " + detail.getCode();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(rs);
			UtilDao.close(st);
		}
		return model;
		
		
	}
	
	/** 模糊匹配问题答案 */
	public ReplyDetail queryCarFuzzyPrblemReply(ProblemMacth model) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ReplyDetail detail = null;
		try {
			conn = getSession().connection();
			st = conn.createStatement();
			String sql = "select code, title, introduce from CarReplyDetail where macthCode=" +  model.getCode();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				detail = new ReplyDetail();
				detail.setCode(rs.getInt("code"));
				detail.setIntroduce(rs.getString("introduce"));
				detail.setTitle(rs.getString("title"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			UtilDao.close(rs);
			UtilDao.close(st);
		}
		return detail;
	}
	
	/** 查看问题分类列表页 */
	public CarProblemClassify queryCarProblemClassifyList(CarProblemClassify model) {
		List<CarProblemClassify> classifyList = new ArrayList<CarProblemClassify>();
		String hql = "from " + CarProblemClassify.class.getName() + " where code in (1,7,12)";
		HibernateTemplate template = getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<CarProblemClassify> list = template.find(hql);
		if (list.size() == 0) {
			return null;
		} else {
			for (CarProblemClassify classify : list){
				hql = "from " + CarReplyDetail.class.getName() + " where code in (select replyCode from " + CarProblemClassify.class.getName() + " where classifyCode = " + classify.getClassifyCode() + ")";
				@SuppressWarnings("unchecked")
				List<CarReplyDetail> detailList = template.find(hql);
				classify.setDetailList(detailList);
				classifyList.add(classify);
			}
			model.setClassifyList(classifyList);
		}
		return model;
	}
	
	/** 查看办事公告列表页 */
	public CarNoticeDetail queryCarNoticeDetailList(CarNoticeDetail model) {
		String hql = "from " + CarNoticeDetail.class.getName() ;
		HibernateTemplate template = getHibernateTemplate();
		@SuppressWarnings("unchecked")
		List<CarNoticeDetail> list = template.find(hql);
		if (list.size() == 0) {
			return null;
		} else {
			model.setNoticeList(list);
		}
		return model;
	}
}

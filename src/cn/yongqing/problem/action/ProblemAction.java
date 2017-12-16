package cn.yongqing.problem.action;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.common.MulitStreamResult;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.common.UtilImage;
import cn.yongqing.common.UtilWX;
import cn.yongqing.problem.entity.ProblemMacth;
import cn.yongqing.problem.entity.ReplyQRCode;
import cn.yongqing.problem.service.ProblemService;
import cn.yongqing.wechat.entity.ActionInfo;
import cn.yongqing.wechat.entity.DaiCanErWeiMa;
import cn.yongqing.wechat.entity.Scene;
import cn.yongqing.wechat.entity.WeixinUtil;

public class ProblemAction extends BaseAction {

	private static final long serialVersionUID = 5112212332234866384L;

	public ProblemAction() {
		base = new ProblemMacth();
	}

	/**
	 * 增加新消息
	 * 
	 * @return model
	 */
	public String select() {
		return "error";

	}

	/**
	 * 匹配问题答案
	 * 
	 * @return model
	 */
	public String queryProblemReply() {
		try {
			ProblemService service = (ProblemService) baseService;
			ProblemMacth model = (ProblemMacth) base;
			model = service.updateHotCountByqueryProblemReply(model);
			base = model;
			if (model.getReplyList().size() == 0) {
				empty = true;
			} else {
				base = model;
			}
		} catch (DaoException e) {
			message = e.getMessage();
		}
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;

	}

	/**
	 * 未匹配问题答案，添加记录
	 * 
	 * @return model
	 */
	public String insertProblemRecord() {
		try {
			ProblemService service = (ProblemService) baseService;
			ProblemMacth model = (ProblemMacth) base;
			model = service.insertProblemRecord(model);
		} catch (DaoException e) {
			message = e.getMessage();
		}
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;
	}

	/**
	 * 匹配问题答案，添加选择记录
	 * 
	 * @return model
	 */
	public String insertProblemCheck() {
		try {
			ProblemService service = (ProblemService) baseService;
			ProblemMacth model = (ProblemMacth) base;
			model = service.insertProblemCheck(model);
		} catch (DaoException e) {
			message = e.getMessage();
		}
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;
	}

	// /**
	// * 查看消息根据userCode
	// *
	// * @return model
	// */
	// public String selectUserMessageByUserCode() {
	// try {
	// UserMessageService service = (UserMessageService) baseService;
	// UserMessage model = (UserMessage) base;
	// model = service.selectUserMessageByUserCode(model);
	// base = model;
	// if (model != null) {
	// message = "获取成功";
	// } else {
	// message = "获取失败";
	// }
	// } catch (DaoException e) {
	// message = e.getMessage();
	// }
	// return "usermessagelist";
	// }
	//
	// /**
	// * 查询消息详情
	// *
	// * @return model
	// */
	// public String selectUserMessageByCode() {
	// try {
	// UserMessageService service = (UserMessageService) baseService;
	// UserMessage model = (UserMessage) base;
	// model = service.selectUserMessageByCode(model);
	// base = model;
	// if (model != null) {
	// message = "获取成功";
	// } else {
	// message = "获取失败";
	// }
	// } catch (DaoException e) {
	// message = e.getMessage();
	// }
	// return "messagedetails";
	//
	// }
	//
	// /**
	// * 删除消息
	// *
	// * @return model
	// */
	// public String deleteUserMessage() {
	// try {
	// UserMessageService service = (UserMessageService) baseService;
	// UserMessage model = (UserMessage) base;
	// model = service.deleteUserMessage(model);
	// base = model;
	// if (model != null) {
	// message = "删除成功";
	// } else {
	// message = "删除失败";
	// }
	// } catch (DaoException e) {
	// message = e.getMessage();
	// }
	// return "checkorders";
	//
	// }

	public void erweima() {
		try {
		ProblemMacth model = (ProblemMacth) base;
		int ansCode = model.getReplyCode();
		ProblemService service = (ProblemService) baseService;
		ReplyQRCode qrCode = service.selectQRCode(ansCode);
		boolean charu = false;
		byte[] erWeiMaBytes = null;
		if(UtilCommon.isNull(qrCode)){
			charu = true;
		}else{
			long nowtime = System.currentTimeMillis();
			long qrtime = qrCode.getCreateTime();
			long timecha = nowtime - qrtime;
			int day = (int) (timecha/(24*3600*1000));
			if(day>25){
				charu = true;
			}else{
				 erWeiMaBytes = qrCode.getEwmTu();
			}
		}
		if(charu){
			String token = UtilWX.accessToken();
			DaiCanErWeiMa canErWeiMa = new DaiCanErWeiMa();
			ActionInfo actionInfo = new ActionInfo();
			Scene scene = new Scene();
			scene.setScene_id(ansCode);
			actionInfo.setScene(scene);
			canErWeiMa.setAction_info(actionInfo);
			//设置有效期！！！！！
			canErWeiMa.setExpire_seconds(2592000);
			JSONObject jsonObject = WeixinUtil.getDaicanerweima(token, canErWeiMa);
			System.out.println(jsonObject.getString("ticket"));
			String ticket = jsonObject.getString("ticket");
			 String url =
			 "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket;
			 URL _url = new URL(url);
			 BufferedImage image = ImageIO.read(_url);
			 erWeiMaBytes = UtilImage.imageToBytes(image);
			 if(UtilCommon.isNull(qrCode)){
				 qrCode = new ReplyQRCode();
				 qrCode.setAnsCode(ansCode);
				 qrCode.setEwmTu(erWeiMaBytes);
				 qrCode.setCreateTime(System.currentTimeMillis());
				 service.insertQRCode(qrCode);
			 }else{
				 qrCode.setEwmTu(erWeiMaBytes);
				 qrCode.setCreateTime(System.currentTimeMillis());
				 System.out.println(erWeiMaBytes);
				 service.updateQRCode(qrCode);
			 }
		}
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 String contentType = "image/jpeg";
		 MulitStreamResult.service(request, response, erWeiMaBytes,
		 contentType);
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
	}

	/**
	 * 匹配问题答案
	 * 
	 * @return model
	 */
	public String queryCarProblemReply() {
		try {
			ProblemService service = (ProblemService) baseService;
			ProblemMacth model = (ProblemMacth) base;
			model = service.updateHotCountByqueryCarProblemReply(model);
			base = model;
			if (model.getReplyList().size() == 0) {
				empty = true;
			} else {
				base = model;
			}
		} catch (DaoException e) {
			message = e.getMessage();
		}
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;

	}
	
}

package cn.yongqing.id.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.id.entity.IDRrcord;
import cn.yongqing.id.entity.UserInfo;
import cn.yongqing.id.service.IDRrcordService;
import cn.yongqing.id.service.UserInfoService;

public class UserInfoAction extends BaseAction {

	private static final long serialVersionUID = 1125669296223432L;
	
	public UserInfoAction() {
		base = new UserInfo();
	}
	
	/**
	 * 读稿子
	 * 
	 * @return model
	 */
	public String login() {
		try {
			UserInfoService service = (UserInfoService) baseService;
			UserInfo model = (UserInfo) base;
			model = service.login(model);
			base = model;
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
	 * 读稿子
	 * 
	 * @return model
	 */
	public String queryReplyDetail() {
		try {
			IDRrcordService service = (IDRrcordService) baseService;
			IDRrcord model = (IDRrcord) base;
			model = service.updatequeryReplyDetail(model);
			base = model;
			if (model.getCode() == 0) {
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
	 * 更新稿子状态
	 * 
	 * @return model
	 */
	public String updateReplyDetailStatus() {
		try {
			IDRrcordService service = (IDRrcordService) baseService;
			IDRrcord model = (IDRrcord) base;
			model = service.updateReplyDetailStatus(model);
			base = model;
			if (model.getCode() == 0) {
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

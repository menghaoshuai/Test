package cn.yongqing.id.action;

import java.util.List;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.base.Pager;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.id.entity.IDRrcord;
import cn.yongqing.id.service.IDRrcordService;

public class IDRrcordAction extends BaseAction {

	private static final long serialVersionUID = 114566999666L;
	
	public IDRrcordAction() {
		base = new IDRrcord();
	}
	
	public String input() {
		IDRrcordService service = (IDRrcordService)baseService;
		IDRrcord model = (IDRrcord) base;
		Pager pager = model.getPager();
		List<IDRrcord> list = service.selects(pager,model);
		model.setList(list);
		if(list.size()>0){
			model.setTotalPage(list.get(0).getTotalPage());
		}
		return INPUT;
	}
	
	public String deleteRepeatedData() {
		IDRrcord model = (IDRrcord) base;
		IDRrcordService service = (IDRrcordService)baseService;
		int addNum = model.getAddNum();
		service.deleteRepeatedData(addNum);
		return input();
	}
	
	public String lingQu() {
		IDRrcord model = (IDRrcord) base;
		IDRrcordService service = (IDRrcordService)baseService;
		service.updateStatus(model);
		return input();
	}
	
	public String select() {
		IDRrcord model = (IDRrcord) base;
		IDRrcordService service = (IDRrcordService)baseService;
		model = service.selectBySFZ(model);
		if(UtilCommon.isNull(model)){
			empty = true;
		}else{
			base = model;
		}
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;
	}
	
	public String updateStatus() {
		IDRrcord model = (IDRrcord) base;
		IDRrcordService service = (IDRrcordService)baseService;
		model = service.updateStatusByRobot(model);
		base = model;
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

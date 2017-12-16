package cn.yongqing.problem.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.problem.entity.CarNoticeDetail;
import cn.yongqing.problem.service.ProblemService;

public class CarNoticeDetailAction extends BaseAction {

	private static final long serialVersionUID = 11222122204866384L;

	public CarNoticeDetailAction() {
		base = new CarNoticeDetail();
	}


	/**
	 * 办事公告列表页
	 * 
	 * @return model
	 */
	public String queryCarNoticeDetailList() {
		try {
			ProblemService service = (ProblemService) baseService;
			CarNoticeDetail model = (CarNoticeDetail) base;
			model = service.queryCarNoticeDetailList(model);
			if (model == null) {
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

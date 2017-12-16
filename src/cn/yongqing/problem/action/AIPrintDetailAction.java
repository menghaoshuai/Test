package cn.yongqing.problem.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.problem.entity.AIPrintDetail;
import cn.yongqing.problem.service.ProblemService;

public class AIPrintDetailAction extends BaseAction {

	private static final long serialVersionUID = 122223724214966384L;

	public AIPrintDetailAction() {
		base = new AIPrintDetail();
	}


	/**
	 * 查询打印列表
	 * 
	 * @return model
	 */
	public String queryAIPrintList() {
		try {
			ProblemService service = (ProblemService) baseService;
			AIPrintDetail model = (AIPrintDetail) base;
			model = service.queryAIPrintList(model);
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
	
	/**
	 * 查询code查询打印详情
	 * 
	 * @return model
	 */
	public String queryAIPrintDetail() {
		try {
			ProblemService service = (ProblemService) baseService;
			AIPrintDetail model = (AIPrintDetail) base;
			model = service.queryAIPrintDetail(model);
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

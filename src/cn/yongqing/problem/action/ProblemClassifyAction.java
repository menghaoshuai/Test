package cn.yongqing.problem.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.problem.entity.ProblemClassify;
import cn.yongqing.problem.service.ProblemService;

public class ProblemClassifyAction extends BaseAction {

	private static final long serialVersionUID = 102221224204866384L;

	public ProblemClassifyAction() {
		base = new ProblemClassify();
	}


	/**
	 * 办事公告列表页
	 * 
	 * @return model
	 */
	public String queryProblemClassifyList() {
		try {
			ProblemService service = (ProblemService) baseService;
			ProblemClassify model = (ProblemClassify) base;
			model = service.queryProblemClassifyList(model);
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

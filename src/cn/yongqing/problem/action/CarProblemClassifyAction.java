package cn.yongqing.problem.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.problem.entity.CarProblemClassify;
import cn.yongqing.problem.service.ProblemService;

public class CarProblemClassifyAction extends BaseAction {

	private static final long serialVersionUID = 102121224204566384L;

	public CarProblemClassifyAction() {
		base = new CarProblemClassify();
	}


	/**
	 * 办事公告列表页
	 * 
	 * @return model
	 */
	public String queryCarProblemClassifyList() {
		try {
			ProblemService service = (ProblemService) baseService;
			CarProblemClassify model = (CarProblemClassify) base;
			model = service.queryCarProblemClassifyList(model);
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

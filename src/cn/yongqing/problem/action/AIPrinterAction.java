package cn.yongqing.problem.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.problem.entity.AIPrinter;
import cn.yongqing.problem.service.ProblemService;

public class AIPrinterAction extends BaseAction {

	private static final long serialVersionUID = 105223224204966384L;

	public AIPrinterAction() {
		base = new AIPrinter();
	}


	/**
	 * 根据mac查询对象
	 * 
	 * @return model
	 */
	public String queryAIPrinterMac() {
		try {
			ProblemService service = (ProblemService) baseService;
			AIPrinter model = (AIPrinter) base;
			model = service.queryAIPrinterMac(model);
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

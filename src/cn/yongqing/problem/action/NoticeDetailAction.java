package cn.yongqing.problem.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.problem.entity.NoticeDetail;
import cn.yongqing.problem.service.ProblemService;

public class NoticeDetailAction extends BaseAction {

	private static final long serialVersionUID = 111221224204866384L;

	public NoticeDetailAction() {
		base = new NoticeDetail();
	}


	/**
	 * 办事公告列表页
	 * 
	 * @return model
	 */
	public String queryNoticeDetailList() {
		try {
			ProblemService service = (ProblemService) baseService;
			NoticeDetail model = (NoticeDetail) base;
			model = service.queryNoticeDetailList(model);
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

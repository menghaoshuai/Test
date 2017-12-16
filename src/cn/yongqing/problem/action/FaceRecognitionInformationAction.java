package cn.yongqing.problem.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.base.DaoException;
import cn.yongqing.problem.entity.FaceRecognitionInformation;
import cn.yongqing.problem.service.ProblemService;

public class FaceRecognitionInformationAction extends BaseAction {

	private static final long serialVersionUID = 2112212332294866384L;

	public FaceRecognitionInformationAction() {
		base = new FaceRecognitionInformation();
	}


	/**
	 * 匹配用户人脸识别
	 * 
	 * @return model
	 */
	public String queryFaceRecognitionInformation() {
		try {
			ProblemService service = (ProblemService) baseService;
			FaceRecognitionInformation model = (FaceRecognitionInformation) base;
			model = service.queryFaceRecognitionInformation(model);
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

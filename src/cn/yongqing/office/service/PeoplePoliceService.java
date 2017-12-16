package cn.yongqing.office.service;

import cn.yongqing.base.BaseService;
import cn.yongqing.office.dao.PeoplePoliceDao;
import cn.yongqing.office.entity.PeoplePolice;

public class PeoplePoliceService extends BaseService {

	public PeoplePolice selectPoliceMessage(PeoplePolice model) {
		PeoplePoliceDao dao = (PeoplePoliceDao) baseDao;
		int code = model.getCode();
		return dao.selectPoliceMessage(code);
	}

	public void updateOrInsertLikedCount(PeoplePolice model) {
		PeoplePoliceDao dao = (PeoplePoliceDao) baseDao;
		int code = model.getCode();
		int tagCode = model.getTagCode();
		dao.updateOrInsertLikedCount(code,tagCode);
	}

}

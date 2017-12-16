package cn.yongqing.office.service;

import cn.yongqing.base.BaseService;
import cn.yongqing.office.dao.PoliceOfficeDao;
import cn.yongqing.office.entity.PoliceOffice;

public class PoliceOfficeService extends BaseService {

	public PoliceOffice selectOfficeMessage(PoliceOffice model) {
		PoliceOfficeDao dao = (PoliceOfficeDao) baseDao;
		int code = model.getCode();
		return dao.selectOfficeMessage(code);
	}
	
	public PoliceOffice selectOfficeCode(PoliceOffice model) {
		PoliceOfficeDao dao = (PoliceOfficeDao) baseDao;
		String mac = model.getMac();
		return dao.selectOfficeCode(mac);
	}

}

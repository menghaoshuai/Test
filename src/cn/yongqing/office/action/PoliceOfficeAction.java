package cn.yongqing.office.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.office.entity.PoliceOffice;
import cn.yongqing.office.service.PoliceOfficeService;

public class PoliceOfficeAction extends BaseAction {

	private static final long serialVersionUID = 1256986565651L;
	
	public PoliceOfficeAction() {
		base = new PoliceOffice();
	}
	
	public String input() {
		PoliceOfficeService service = (PoliceOfficeService)baseService;
		PoliceOffice model = (PoliceOffice) base;
		model = service.selectOfficeMessage(model);
		base = model;
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;
	}
	
	public String selectCode() {
		PoliceOfficeService service = (PoliceOfficeService)baseService;
		PoliceOffice model = (PoliceOffice) base;
		model = service.selectOfficeCode(model);
		base = model;
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;
	}

}

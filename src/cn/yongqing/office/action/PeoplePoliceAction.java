package cn.yongqing.office.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.office.entity.PeoplePolice;
import cn.yongqing.office.service.PeoplePoliceService;

public class PeoplePoliceAction extends BaseAction {

	private static final long serialVersionUID = 125478856666666664L;
	
	public PeoplePoliceAction() {
		base = new PeoplePolice();
	}
	
	public String input() {
		PeoplePoliceService service = (PeoplePoliceService)baseService;
		PeoplePolice model = (PeoplePolice) base;
		model = service.selectPoliceMessage(model);
		base = model;
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;
	}
	
	public String addLikedCount() {
		PeoplePoliceService service = (PeoplePoliceService)baseService;
		PeoplePolice model = (PeoplePolice) base;
		service.updateOrInsertLikedCount(model);
		return input();
	}

}

package cn.yongqing.locations.action;

import cn.yongqing.base.BaseAction;
import cn.yongqing.locations.service.LocationsService;
import cn.yongqing.office.entity.Locations;

public class LocationsAction extends BaseAction {

	private static final long serialVersionUID = 1254788536456213644L;
	
	public LocationsAction() {
		base = new Locations();
	}
	
	public String selectLocations() {
		LocationsService service = (LocationsService)baseService;
		Locations model = (Locations) base;
		model = service.selectLocations(model);
		if (model.getResultList().size() == 0) {
			empty = true;
		} else {
			base = model;
		}
		boolean result = json();
		if (result) {
			return JSON;
		}
		return JSON;
	}
	

}

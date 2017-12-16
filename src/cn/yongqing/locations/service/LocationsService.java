package cn.yongqing.locations.service;

import cn.yongqing.base.BaseService;
import cn.yongqing.locations.dao.LocationsDao;
import cn.yongqing.office.entity.Locations;

public class LocationsService extends BaseService {

	public Locations selectLocations(Locations model) {
		LocationsDao dao = (LocationsDao) baseDao;
		return dao.selectLocations(model);
	}

}

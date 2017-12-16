package cn.yongqing.locations.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.yongqing.base.BaseDao;
import cn.yongqing.office.entity.Locations;

public class LocationsDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public Locations selectLocations(Locations model) {
		HibernateTemplate template = getHibernateTemplate();
		String hql = "from " + Locations.class.getName() ;
		List<Locations> result = template.find(hql);
		model.setResultList(result);
		return model;
	}

}

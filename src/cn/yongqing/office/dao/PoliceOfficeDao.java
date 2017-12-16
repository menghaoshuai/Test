package cn.yongqing.office.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.yongqing.base.BaseDao;
import cn.yongqing.office.entity.Locations;
import cn.yongqing.office.entity.PeoplePolice;
import cn.yongqing.office.entity.PoliceOffice;

public class PoliceOfficeDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public PoliceOffice selectOfficeMessage(int code) {
		HibernateTemplate template = getHibernateTemplate();
		PoliceOffice office = (PoliceOffice) template.get(PoliceOffice.class, code);
		int aeraCode = office.getAeraCode();
		String hql = "from " + PeoplePolice.class.getName() + " where officeCode=" + code;
		List<PeoplePolice> polices = template.find(hql);
		office.setPolices(polices);
		hql = "from " + Locations.class.getName() + " where aeraCode=" + aeraCode;
		List<Locations> locations = template.find(hql);
		office.setLocations(locations);
		return office;
	}
	
	@SuppressWarnings("unchecked")
	public PoliceOffice selectOfficeCode(String mac) {
		HibernateTemplate template = getHibernateTemplate();
		PoliceOffice office = new PoliceOffice();
		String hql = "from " + PoliceOffice.class.getName() + " where mac=" + mac;
		List<PoliceOffice> offices = template.find(hql);
		if(offices.size()>0)
			office = offices.get(0);
		return office;
	}

}

package cn.yongqing.id.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.yongqing.base.BaseDao;
import cn.yongqing.common.UtilCommon;
import cn.yongqing.id.entity.UserInfo;

public class UserInfoDao extends BaseDao {

	public UserInfo login(UserInfo model) {
		HibernateTemplate template = getHibernateTemplate();
		if(!UtilCommon.isNull(model.getTelphone()) && !UtilCommon.isNull(model.getPassword())) {
			String hql = "from " + UserInfo.class.getName() + " where telphone ='" + model.getTelphone() + "'";
			template.setMaxResults(1);
			@SuppressWarnings("unchecked")
			List<UserInfo> list = template.find(hql);
			if(list.size()>0){
				UserInfo user = list.get(0);
				if(user.getPassword().equals(model.getPassword())){
					return user;
				}
			}
		}
		return model;
	}
}

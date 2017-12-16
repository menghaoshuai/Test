package cn.yongqing.id.service;

import cn.yongqing.base.BaseService;
import cn.yongqing.base.DaoException;
import cn.yongqing.id.dao.UserInfoDao;
import cn.yongqing.id.entity.UserInfo;

public class UserInfoService extends BaseService {

	public UserInfo login(UserInfo model) {
		UserInfoDao dao = (UserInfoDao) baseDao;
		model = dao.login(model);
		if(model.getCode() == 0) {
			throw new DaoException("请检查账号密码或先注册");
		}
		return model;
	}
	
}

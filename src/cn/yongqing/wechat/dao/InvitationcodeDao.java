package cn.yongqing.wechat.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.yongqing.base.BaseDao;
import cn.yongqing.problem.entity.ReplyDetail;

public class InvitationcodeDao extends BaseDao {

	public ReplyDetail selectAns(int ansCode) {
		HibernateTemplate template = getHibernateTemplate();
		return (ReplyDetail) template.get(ReplyDetail.class, ansCode);
	}

}

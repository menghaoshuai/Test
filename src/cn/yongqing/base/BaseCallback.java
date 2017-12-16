package cn.yongqing.base;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * <p>Title: Hibernate 查询回调函数</p>
 * <p>Description: Spring 整合 Hibernate 时候用的 HibernateTemplate 不支持分页，需要该类来实现分页</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: ohqly.com</p>
 * @author 董有红
 * @version 1.0
 */

public class BaseCallback implements HibernateCallback {
	
	private String hql;
	private int offset;
	private int length;
	
	public BaseCallback(String hql, int offset, int length) {
		this.hql = hql;
		this.offset = offset;
		this.length = length;
	}
	
	public Object doInHibernate(Session session) {
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
	    List<Base> list = query.list();
	    return list;
	}
}

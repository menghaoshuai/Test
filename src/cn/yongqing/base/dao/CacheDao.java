package cn.yongqing.base.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.yongqing.base.Base;
import cn.yongqing.base.BaseDao;



public class CacheDao extends BaseDao {
	
	/**
     * 查询基础表所有对象
     *
     * @param className 实体对象类名
     * @return 所有的基础表数据集合
     */
    public List<Base> select(String className) {
    	HibernateTemplate template = getHibernateTemplate();
    	String hql = "select b from " + className + " b";
    	@SuppressWarnings("unchecked")
		List<Base> list = (List<Base>)template.find(hql);
    	return list;
    }
    
}

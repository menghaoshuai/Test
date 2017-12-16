package cn.yongqing.base;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.yongqing.common.UtilPage;

/**
 * <p>Title: 基本数据库Dao</p>
 * <p>Description: 有基本的增、删、改、查方法</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: </p>
 * @author 董有红
 * @version 1.0
 */
public class BaseDao extends HibernateDaoSupport {
	
	/**
     * 插入实体对象
     *
     * @param base 最基本的实体，可以是继承Base的类
     * @return 查入后的Base
     */
    public Base insert(Base base) {
	    HibernateTemplate template = getHibernateTemplate();
	    template.save(base);
	    return base;
    }
    
    /**
     * 更新实体对象
     *
     * @param base Base 最基本的实体，可以是继承Base的类
     */
    public void update(Base base) {
    	HibernateTemplate template= getHibernateTemplate();
    	template.update(base);
    }
    
    /**
     * 删除实体对象
     *
     * @param base 最基本的实体，可以是继承Base的类
     */
    public void delete(Base base) {
    	HibernateTemplate template= getHibernateTemplate();
    	template.delete(base);
    }
    
    /**
     * 查询业务实体对象
     *
     * @param _class 实体对象类型
     * @param code 实体对象主键
     * @return 业务实体对象
     */
    public Base select(Class _class, int code) {
    	HibernateTemplate template= getHibernateTemplate();
    	Base base = (Base)template.get(_class, code);
    	return base;
    }
    
    /**
     * 查询业务实体对象集
     *
     * @param hql 查询语句
     * @param offset 偏移量
     * @param length 查询深度
     * @return 查询结果
     */
    @SuppressWarnings("rawtypes")
	protected List selects(String hql, int offset, int length) {
    	HibernateTemplate template = getHibernateTemplate();
    	BaseCallback callback = new BaseCallback(hql, offset, length);
    	List list = template.executeFind(callback);
    	return list;
    }
    
    /**
     * 查询业务实体对象集
     *
     * @param hql 查询语句
     * @param pager 封装好的pager
     * @return 查询结果
     */
    
	protected List selects(String hql, Pager pager) {
    	HibernateTemplate template = getHibernateTemplate();
    	int page = pager.getPage();
    	int rowsPerPage = pager.getRowsPerPage();
    	int offset = UtilPage.offset(page, rowsPerPage);
    	int length = UtilPage.length(rowsPerPage);
    	BaseCallback callback = new BaseCallback(hql, offset, length);
    	List list = template.executeFind(callback);
    	pager.reset(list.size());
    	return list;
    }
    
}

package cn.yongqing.base;

import org.apache.log4j.Logger;

/**
 * <p>Title: 基本的Service类</p>
 * <p>Description: 实现基本的增、删、改、查方法</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: ohqly.com</p>
 * @author 董有红
 * @version 1.0
 */

public class BaseService {
	
	/** 基本数据库操作类 */
	protected BaseDao baseDao;
	
	/** 日志对象，子类可以直接使用 */
	protected Logger logger;
	
	public BaseService() {
		logger = Logger.getLogger(this.getClass());
	}
	
	/**
     * 插入实体对象
     *
     * @param base 最基本的实体，可以是继承Base的类
     */
    public void insert(Base base) {
    	baseDao.insert(base);
    }
    
    /**
     * 更新实体对象
     *
     * @param base Base 最基本的实体，可以是继承Base的类
     */
    public void update(Base base) {
    	baseDao.update(base);
    }
    
    /**
     * 删除实体对象
     *
     * @param base Base 最基本的实体，可以是继承Base的类
     */
    public void delete(Base base) {
    	baseDao.delete(base);
    }
    
    
    /**
     * 查询业务实体对象
     *
     * @param base 实体对象
     * 
     * @return 查询后的实体对象
     */
    public Base select(Base base) {
    	return baseDao.select(base.getClass(), base.getCode());
    }


	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
}

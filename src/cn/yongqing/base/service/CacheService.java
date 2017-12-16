package cn.yongqing.base.service;

import java.util.Collections;
import java.util.List;

import cn.yongqing.base.Base;
import cn.yongqing.base.dao.CacheDao;

 

public class CacheService {
	
	private CacheDao cacheDao;
	
	/**
     * 查询基础表所有对象
     *
     * @param className 类名
     * @return 所有的基础表数据集合
     */
    public List<Base> select(String className) {
    	List<Base> list = cacheDao.select(className);
    	Collections.sort(list);
    	return list;
    }
    
	public void setCacheDao(CacheDao cacheDao) {
		this.cacheDao = cacheDao;
	}
}

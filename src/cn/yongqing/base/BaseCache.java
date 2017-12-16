package cn.yongqing.base;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.yongqing.base.service.CacheService;
import cn.yongqing.common.UtilCommon;


/**
 * <p>Title: 数据库换成，据缓基础数据</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: </p>
 * @author 董有红
 * @version 1.0
 */

public class BaseCache {
	
	private Map<String, List<Base>> cache;
	
	private static BaseCache baseCache;
	
	private static List<Base> indexCache;
	
    private BaseCache() {
		cache = new HashMap<String, List<Base>>();
		init();
    }
    
	public static BaseCache create() {
		if (baseCache == null)
			baseCache = new BaseCache();
		return baseCache;
	}
    
    private void init() {
    	try {
	    	String filename = UtilCommon.getFullPathRelateClass("../../../sql/chace.hbm.xml", this.getClass());
	    	File file = new File(filename);
	    	Document document = UtilCommon.readDocument(file);
			Element rootEmt = document.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> classes = rootEmt.elements("class");
			CacheService cacheService = (CacheService)SpringLocator.create().getBean("cacheService");
			for (Element element : classes) {
				String className = element.attributeValue("name");
				List<Base> list = cacheService.select(className);
				Collections.sort(list);
				cache.put(className, list);
			}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

	public List<Base> getCache(Class<?> _class) {
		String name = _class.getName();
		List<Base> list = cache.get(name);
		return list;
	}
	
	public static List<Base> getCache(String name) {
		BaseCache cache = BaseCache.create();
		@SuppressWarnings("static-access")
		List<Base> list = cache.getCache(name);
		return list;
	}
	
	public Base getBase(Class<?> _class, int code) {
		List<Base> list = getCache(_class);
		for (Base base : list) {
			if (base.getCode() == code)
				return base;
		}
		return null;
	}
}

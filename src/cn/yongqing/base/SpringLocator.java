package cn.yongqing.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <p>Title: Spring载入类</p>
 * <p>Description: 在Spring 配置文件里实例化，从Spring ApplicationContext根据对象id，取得对象</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: </p>
 * @author 董有红
 * @version 1.0
 */

public class SpringLocator implements ApplicationContextAware {
	
	private static SpringLocator instance = null;
	
	private ApplicationContext context;
	
	private SpringLocator() {
		
	}
	
	public static SpringLocator create() {
		if (instance == null) {
			instance = new SpringLocator();
		}
		return instance;
	}

	public void setApplicationContext(ApplicationContext context) {
		this.context = context;
	}

	public Object getBean(String beanId) {
		try {
			return context.getBean(beanId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
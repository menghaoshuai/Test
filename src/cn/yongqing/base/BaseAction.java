package cn.yongqing.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * <p>
 * Title: 基本的Action的超级父类
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: ohqly.com
 * </p>
 * 
 * @author 董有红
 * @version 1.0
 */

public class BaseAction extends ActionSupport implements ModelDriven<Base>,
		ServletRequestAware {

	private static final long serialVersionUID = -3387516993124009949L;

	/** 日志对象，子类可以直接使用 */
	protected Logger logger;

	/** 更新时返回字符串值 */
	public static final String INSERT = "insert";

	/** 查询时返回字符串值 */
	public static final String SELECT = "select";

	/** 更新时返回字符串值 */
	public static final String UPDATE = "update";

	/** 删除时返回字符串值 */
	public static final String DELETE = "delete";

	/** 查看时返回字符串值 */
	public static final String LOOKUP = "lookup";

	/** json数据格式返回字符串值 */
	public static final String JSON = "json";

	/** 实体对象，Model */
	protected Base base;

	/** 服务类 */
	protected BaseService baseService;

	/** 数据json */
	private String json;

	/** 信息提示 */
	protected String message;

	/** 是否空信息 */
	protected boolean empty;

	/** 总查询路径 */
	protected String url;

	public BaseAction() {
		logger = Logger.getLogger(this.getClass());
		message = "";
	}

	/**
	 * 插入实体对象
	 * 
	 * @return 要跳转的字符串指定页面
	 */
	public String insert() {
		baseService.insert(base);
		return INSERT;
	}

	/**
	 * 更新实体对象
	 * 
	 * @return 要跳转的字符串指定页面
	 */
	public String update() {
		baseService.update(base);
		return UPDATE;
	}

	/**
	 * 删除实体对象
	 * 
	 * @return 要跳转的字符串指定页面
	 */
	public String delete(Base base) {
		baseService.delete(base);
		return DELETE;
	}

	/**
	 * 查询业务实体对象
	 * 
	 * @return 要跳转的字符串指定页面
	 */
	public String select() {
		baseService.select(base);
		base = baseService.select(base);
		return SELECT;
	}

	public Base getModel() {
		return base;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	protected boolean json() {
		json = base.toString();
		return true;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}

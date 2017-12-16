package cn.yongqing.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.RequestUtils;
import org.apache.struts2.dispatcher.mapper.DefaultActionMapper;

import cn.yongqing.common.UtilCommon;

public class BaseActionMapper extends DefaultActionMapper {

	private Logger logger;

	public BaseActionMapper() {
		logger = Logger.getLogger(this.getClass());
	}

	protected String getUri(HttpServletRequest request) {
		String uri = (String) request.getAttribute("javax.servlet.include.servlet_path");
		if (uri != null) {
			return uri;
		}

		uri = RequestUtils.getServletPath(request);
		logger.info("RequestUtils " + uri);
		if (UtilCommon.isNull(uri)) {
			uri = request.getRequestURI();
			uri = uri.substring(request.getContextPath().length());
		}
		if (uri.equals("/") || uri.startsWith("/index.")) {
			uri = "/text_index.action";
		}
		logger.info("end " + uri);
		return uri;
	}
}

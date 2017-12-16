package cn.yongqing.base;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yongqing.common.UtilHttp;
import cn.yongqing.common.UtilImage;

public class TrimFilter implements Filter {

	private FilterConfig config;
	
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest)_request;
		
		HttpServletResponse response = (HttpServletResponse)_response;
		
		String contentType = request.getHeader("Content-Type");
		if (contentType == null) {
			contentType = "";
		}
		if (contentType.indexOf("ognl.OgnlContext") > -1 || contentType.indexOf("(@org.apache") > -1) {
			// 服务器由于维护或者负载过重未能应答
			response.setStatus(503);
			System.out.println("struts2攻击 contentType=" + contentType);
			return;
		}
		
		
		String uri = request.getRequestURI();
		if (uri.equals("/validateImg")) {
			String zifu = UtilImage.zifu();
			UtilHttp.saveZifu(request, zifu);
			ServletOutputStream out = null;
            _response.setContentType("image/png");
            try {
            	out = _response.getOutputStream();
            	BufferedImage image = UtilImage.randomImage(zifu);
            	ImageIO.write(image, "png", out);
            } catch (Exception e) {
            	e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }
            return;
		} 

		CharArrayWrapper responseWrapper = new CharArrayWrapper(response);
		chain.doFilter(_request, responseWrapper);

		PrintWriter out = null;
		try {
        	out = _response.getWriter();
    		String source = responseWrapper.toString();
    		source = source.replaceFirst("^[\t\r\\s]+", "").replaceFirst("[\t\r\\s]+$", "");
    		source = source.replaceAll(":[\r\n\t\\s]*</label>", "</label>");
        	out.write(source);
        } catch (Exception e) {
//        	e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	protected FilterConfig getFilterConfig() {
		return (config);
	}

	public void destroy() {
	}
}


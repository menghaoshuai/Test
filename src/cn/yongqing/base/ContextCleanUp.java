package cn.yongqing.base;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.Dispatcher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.profiling.UtilTimerStack;


public class ContextCleanUp implements Filter {

	private static Logger logger = Logger.getLogger(ContextCleanUp.class);
	
    private static final String COUNTER = "__cleanup_recursion_counter";

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        String timerKey = "ActionContextCleanUp_doFilter: ";
        try {
            UtilTimerStack.push(timerKey);

            try {
                Integer count = (Integer)request.getAttribute(COUNTER);
                if (count == null) {
                    count = Integer.valueOf(1);
                }
                else {
                    count = Integer.valueOf(count.intValue()+1);
                }
                
                request.setAttribute(COUNTER, count);

                //LOG.debug("filtering counter="+count);

                chain.doFilter(request, response);
            } catch (IllegalStateException e) {
            	logger.error("错误 IllegalStateException " + request.getRequestURL().toString());
            	e.printStackTrace();
            	throw e;
            } finally {
                int counterVal = ((Integer)request.getAttribute(COUNTER)).intValue();
                counterVal -= 1;
                request.setAttribute(COUNTER, Integer.valueOf(counterVal));
                cleanUp(request);
            }
        }
        finally {
            UtilTimerStack.pop(timerKey);
        }
    }

    /**
     * Clean up the request of threadlocals if this is the last execution
     *
     * @param req The servlet request
     */
    protected static void cleanUp(ServletRequest req) {
        // should we clean up yet?
        Integer count = (Integer) req.getAttribute(COUNTER);
        if (count != null && count > 0 ) {
            if (logger.isDebugEnabled()) {
            	logger.debug("skipping cleanup counter="+count);
            }
            return;
        }

        // always dontClean up the thread request, even if an action hasn't been executed
        ActionContext.setContext(null);
        Dispatcher.setInstance(null);
    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }
}


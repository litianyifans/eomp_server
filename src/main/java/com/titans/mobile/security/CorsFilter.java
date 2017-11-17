package com.titans.mobile.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;



/**
 * ajax 跨域访问设置响应头
 * @author liw1
 *
 */

@Component
public class CorsFilter implements Filter {
	
	/** Log4j日志处理 */
    private static final Logger log = Logger.getLogger(CorsFilter.class);
	
	private String allowOrigin;
    private String allowMethods;
    private String allowCredentials;
    private String allowHeaders;
    //private String exposeHeaders;//可选字段,默认允许拿到请求头的6个字段,想获取其它字段,在此设置
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		allowOrigin = "http://127.0.0.1:8020,http://127.0.0.1:8080";
        allowMethods = "GET,POST,PUT,DELETE,OPTIONS";
        allowCredentials = "true";
        allowHeaders = "Content-Type,authToken,Access-Control-Allow-Origin,X-Requested-With";
        //exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;
	        String currentOrigin = request.getHeader("Origin");
	        log.debug("currentOrigin : " + currentOrigin);
	        if (StringUtils.isNotEmpty(allowOrigin)) {
	            List<String> allowOriginList = Arrays
	                    .asList(allowOrigin.split(","));
	            log.debug("allowOriginList : " + allowOrigin);
	            if (CollectionUtils.isNotEmpty(allowOriginList)) {
	                if (allowOriginList.contains(currentOrigin)) {
	                    response.setHeader("Access-Control-Allow-Origin",
	                            currentOrigin);
	                }
	            }
	        }
	        if (StringUtils.isNotEmpty(allowMethods)) {
	            response.setHeader("Access-Control-Allow-Methods", allowMethods);
	        }
	        if (StringUtils.isNotEmpty(allowCredentials)) {
	            response.setHeader("Access-Control-Allow-Credentials",
	                    allowCredentials);
	        }
	        if (StringUtils.isNotEmpty(allowHeaders)) {
	            response.setHeader("Access-Control-Allow-Headers", allowHeaders);
	        }
	       /* if (StringUtils.isNotEmpty(exposeHeaders)) {
	            response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
	        }*/
	        chain.doFilter(req, res);
		
	}
	
	
	@Override
	public void destroy() {
		
	}

}

package com.titans.mobile.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

  
/**        
 * Title: Web上下文工具类
 * @author liw       
 * @created 2017年10月12日 下午5:16:42    
 */      
public class WebContextUtil {
	  
	/**     
	 * @description 获取HTTP请求    
	 * @author liw       
	 * @created 2017年10月12日 下午5:18:08     
	 * @return     
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**     
	 * @description 获取HTTP响应
	 * @author liw       
	 * @created 2017年10月12日 下午5:18:08     
	 * @return     
	 */
	public static HttpServletResponse getResponse () {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getResponse() ;
		return response;
	}
}

package com.titans.mobile.security;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;




/**
 * ajax 跨域访问设置响应头
 * @author liw1
 *
 */

public class CorsConfig extends  WebMvcConfigurerAdapter{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedOrigins("http://127.0.0.1:8020,http://127.0.0.1:8080").allowedHeaders("Content-Type,X-Token,Access-Control-Allow-Origin,X-Requested-With")
	                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
	                .allowCredentials(true).maxAge(3600);
	    }

}

package com.titans.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class EompApplication {
	public static void main(String[] args) {
		SpringApplication.run(EompApplication.class, args);
		System.out.println("*****************************");
		System.out.println("*****************************");
		System.out.println("*******eomp启动成功**********");
		System.out.println("*****************************");
		System.out.println("*****************************");
	}
	
	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		// 预检请求的有效期，单位为秒。
		//corsConfiguration.setMaxAge(3600L);
        // 是否支持安全证书
		//corsConfiguration.setAllowCredentials(true);
		return corsConfiguration;
	}

	/**
	 * 跨域过滤器
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		return new CorsFilter(source);
	}
}

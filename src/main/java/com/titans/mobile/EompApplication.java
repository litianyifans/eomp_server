package com.titans.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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

}

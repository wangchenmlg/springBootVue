package com.serv.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
		
		Logger logger =LoggerFactory.getLogger(WebApplication.class);
		logger.debug("This is a debug message");//注意 spring 默认日志输出级别为 info 所以默认情况下 这句不会打印到控制台
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
	}
}

package com.spring1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//컨트롤러나 서비스, 맵퍼, 레포시토리에서 사용할 Bean을 등록
@Configuration
@ComponentScan(basePackages = "com.spring1")
public class ApplicationConfig {
		
	/*
    @Bean
    public TestService testService(){ return new TestServiceImpl(); }
    
    @Bean
    public TestRepository testRepository(){ return new TestRepositoryImpl(); }
    */    
}

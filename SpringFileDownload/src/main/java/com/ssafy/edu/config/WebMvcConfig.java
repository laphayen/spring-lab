package com.ssafy.edu.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.edu.util.CommonInterceptor;

//@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub

		registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**")
		.excludePathPatterns("/img/**", "/js/**", "/css/**");
	}
		
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}

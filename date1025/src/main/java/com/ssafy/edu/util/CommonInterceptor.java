package com.ssafy.edu.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommonInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.getRequestURL(); // 전체경로 http://localhost:8080/contextpath/servlet
		request.getRequestURI(); // 프로젝트명부터 /contextpath/servlet/servlet
		request.getServletPath(); //현재 서블렛의 주소 /servlet/servlet 
		request.getContextPath(); // contextpath 만 /contextpath\
		//System.out.println("preHandler : "+ request.getServletPath());
		String id = (String) request.getSession().getAttribute("id");
		
//		if(id == null) {
//			if(request.getServletPath().equals("/member/loginform")) {
//				return true;
//			}
//			return false;
//		}else {
//			
//			return true;	
//		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		//System.out.println("postHandler");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		//System.out.println("afterCompletion");
	}
}

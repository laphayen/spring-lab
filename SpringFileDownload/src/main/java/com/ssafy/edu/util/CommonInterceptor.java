package com.ssafy.edu.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CommonInterceptor implements HandlerInterceptor{
	
	
	// 기본 1차 보안처리로 web-inf 파일 아래는 controller를 통해 접근이 가능하다.
	// interceptor를 통해서 controller에 접근할 수 없으면
	// 사용자는 view를 접근할 수 없다.
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		// TODO Auto-generated method stub
//		request.getRequestURI();
//		System.out.println("preHandler : " + request.getServletPath());
//		
//		String id = (String) request.getSession().getAttribute("id");
//		
//		if (id == null) {
//			if (request.getServletPath().equals("/member/loginform")) {
//				return true;
//			}
//			
//			return false;
//		} else {
//			return true;
//		}
//		
//	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		System.out.println("posthandler");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		System.out.println("aftercompletion");
	}

	
}

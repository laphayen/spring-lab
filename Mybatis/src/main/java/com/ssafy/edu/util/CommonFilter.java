package com.ssafy.edu.util;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class CommonFilter
 */
public class CommonFilter extends HttpFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
    	
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		
	}

	

}

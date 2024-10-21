package com.ssafy.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(ModelAndView mv) {
		
		try {
			mv.setViewName("index");
		} catch (Exception e) {
			System.out.println(e);
			
			mv.setViewName("error/error");
		}
		
		return "index";
	}
	
}

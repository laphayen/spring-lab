package com.ssafy.edu.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String handlerException(Model mv, Exception e) {
		
		mv.addAttribute("msg", e.getMessage());
		
		return "error/error";
	}
	
	
	@ExceptionHandler(SQLException.class)
	public String sqlException(Model m, Exception e) {
		m.addAttribute("msg", e.getMessage());
		return "error/error";
	}
	
}

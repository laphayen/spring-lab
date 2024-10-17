package com.laphayen.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.laphayen.board.controller.BoardController;

@Configuration
public class BoardConfig {
	
	@Bean
	public BoardController boardController() {
		return new BoardController();
	}
	
}

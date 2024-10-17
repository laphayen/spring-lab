package com.laphayen.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.laphayen.board.config.BoardConfig;
import com.laphayen.board.controller.BoardController;

public class BoardMain {

	public static void main(String[] args) {

		// 스프링 컨텍스트 초기화
		ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
		
		// BoardController 빈 가져오기
		BoardController boardController = context.getBean(BoardController.class);
		
		boardController.printBoard();
		
	}

}

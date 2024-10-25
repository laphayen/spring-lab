package com.ssafy.edu.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

//@Configuration
//@ComponentScan("com.ssafy.edu")
//public class AppConfig {
//	@Bean
//	public DataSource basicDataSource() {
//		BasicDataSource ds = new BasicDataSource();
//		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/ssafylocalweb?serverTimezone=UTC");
//		ds.setUsername("ssafy");
//		ds.setPassword("ssafy");
//		return ds;
//	}
//}
//
//

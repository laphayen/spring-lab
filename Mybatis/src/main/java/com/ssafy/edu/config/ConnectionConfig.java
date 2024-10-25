package com.ssafy.edu.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// <beans>
@Configuration
public class ConnectionConfig {

	
	
	// <bean 
	@Bean
	public DataSource connectionDs () { // id="connectionMaker"
		return new BasicDataSource(); // class="com.ssafy.edu.config.BasicDataSource" />
	}
	
}

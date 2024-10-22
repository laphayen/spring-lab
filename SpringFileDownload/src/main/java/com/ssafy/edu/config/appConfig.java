package com.ssafy.edu.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.dbcp2.BasicDataSource;

@Configuration
public class appConfig {
    
    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Corrected the driver class name
        ds.setUrl("jdbc:mysql://localhost:3306/ssafylocalweb?serverTimezone=UTC");
        ds.setUsername("ssafy");
        ds.setPassword("ssafy");
        return ds;
    }
    
}

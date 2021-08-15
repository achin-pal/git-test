package com.spring.jdbc.SpringJDBC;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JavaConfig {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dms = new DriverManagerDataSource();
		dms.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dms.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dms.setUsername("SYSTEM");
		dms.setPassword("7128");
		return dms;
	}

	@Bean
	public JdbcTemplate getTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}
	
	@Bean
	public StudentDao getStudent() {
		StudentDaoImpl sd= new StudentDaoImpl();
		sd.setJdbc(getTemplate());
		return sd;
	}

}

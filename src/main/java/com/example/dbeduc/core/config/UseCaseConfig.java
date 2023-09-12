package com.example.dbeduc.core.config;

import com.example.dbeduc.core.mapper.StudentMapper;
import com.example.dbeduc.infrastructure.data.JdbcStudentDataSource;
import com.example.dbeduc.usecase.StudentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
	@Autowired
	private  JdbcStudentDataSource userDataSource;
	@Autowired
	private StudentMapper studentMapper;

	@Bean
	public StudentUseCase getUserUseCase() {
		return new StudentUseCase(userDataSource, studentMapper);
	}


}

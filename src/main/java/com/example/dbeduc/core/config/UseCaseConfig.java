package com.example.dbeduc.core.config;

import com.example.dbeduc.domain.model.Student;
import com.example.dbeduc.infrastructure.data.JdbcStudentDataSource;
import com.example.dbeduc.usecase.StudentUseCase;
import com.example.dbeduc.usecase.request.StudentRequest;
import com.example.dbeduc.usecase.request.StudentResponse;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
	@Autowired
	private  JdbcStudentDataSource userDataSource;
	@Autowired
	private  StudentMapper studentMapper;

	@Bean
	public StudentUseCase getUserUseCase() {
		return new StudentUseCase(userDataSource, studentMapper);
	}

	@Mapper(componentModel = "spring")
	public interface StudentMapper {

		Student mapToModel(StudentRequest studentRequest) ;
		StudentResponse mapToResponse(Student student) ;
	}
}

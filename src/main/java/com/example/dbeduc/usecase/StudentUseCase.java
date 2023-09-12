package com.example.dbeduc.usecase;

import com.example.dbeduc.core.config.UseCaseConfig;
import com.example.dbeduc.domain.model.Student;
import com.example.dbeduc.infrastructure.data.JdbcStudentDataSource;
import com.example.dbeduc.usecase.request.StudentRequest;
import com.example.dbeduc.usecase.request.StudentResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.List;

@Slf4j
public class StudentUseCase {

	private final JdbcStudentDataSource studentDataSource;
	private final UseCaseConfig.StudentMapper studentMapper;

	public StudentUseCase(JdbcStudentDataSource studentDataSource, UseCaseConfig.StudentMapper studentMapper) {
		this.studentDataSource = studentDataSource;
		this.studentMapper = studentMapper;
	}

	public StudentResponse create(StudentRequest studentRequest) {
		log.info("Creating user {}", studentRequest);
		Student student = studentMapper.mapToModel(studentRequest);
		return studentMapper.mapToResponse(studentDataSource.save(student));
	}

	public StudentResponse update(StudentRequest studentRequest) {
		log.info("Updating user {}", studentRequest);
		Student student = studentMapper.mapToModel(studentRequest);
		return studentMapper.mapToResponse(studentDataSource.save(student));
	}

	public StudentResponse findById(Long id) {
		log.info("Finding user by id : {}", id);
		return studentMapper.mapToResponse(studentDataSource.findById(id).orElseThrow());
	}

	public void delete(Long id) {
		log.info("Deleting user by id : {}", id);
		val isUserExist = studentDataSource.existsById(id);
		if (!isUserExist) {
			throw new RuntimeException("User not found");
		}
		studentDataSource.delete(Student.builder().id(id).build());
	}

	public List<StudentResponse> findAll() {
		log.info("Finding all users");
		List<Student> students = (List<Student>) studentDataSource.findAll();
		log.debug("Found {} users", students.size());
		return students.stream().map(studentMapper::mapToResponse).toList();
	}
}

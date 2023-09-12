package com.example.dbeduc.adapter.controller;

import com.example.dbeduc.usecase.StudentUseCase;
import com.example.dbeduc.usecase.request.StudentRequest;
import com.example.dbeduc.usecase.request.StudentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {
	private final StudentUseCase studentUseCase;

	@Autowired
	public StudentController(StudentUseCase studentUseCase) {
		this.studentUseCase = studentUseCase;
	}


	@GetMapping
	public List<StudentResponse> findAll() {
		log.info("Finding all users");
		return studentUseCase.findAll();
	}

	@GetMapping("/{id}")
	public StudentResponse findById(@PathVariable Long id) {
		log.info("Finding user by id : {}", id);
		return studentUseCase.findById(id);
	}

	@PostMapping
	public StudentResponse create(@RequestBody StudentRequest studentRequest) {
		log.info("Creating user {}", studentRequest);
		return studentUseCase.create(studentRequest);
	}

	@PatchMapping
	public StudentResponse update(@RequestBody StudentRequest studentRequest) {
		log.info("Updating user {}", studentRequest);
		return studentUseCase.update(studentRequest);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		log.info("Deleting user by id : {}", id);
		studentUseCase.delete(id);
	}
}

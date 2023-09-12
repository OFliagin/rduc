package com.example.dbeduc.core.mapper;

import com.example.dbeduc.domain.model.Student;
import com.example.dbeduc.usecase.request.StudentRequest;
import com.example.dbeduc.usecase.request.StudentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

	Student mapToModel(StudentRequest studentRequest) ;
	StudentResponse mapToResponse(Student student) ;
}
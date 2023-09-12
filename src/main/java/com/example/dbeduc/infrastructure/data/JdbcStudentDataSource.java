package com.example.dbeduc.infrastructure.data;

import com.example.dbeduc.domain.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface JdbcStudentDataSource extends CrudRepository<Student, Long> {


}

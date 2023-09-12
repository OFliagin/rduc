package com.example.dbeduc.domain.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "students")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column
	String name;

	@Column(nullable = false, unique = true)
	String lastName;

	@Temporal(TemporalType.DATE)
	Date birthDate;
}

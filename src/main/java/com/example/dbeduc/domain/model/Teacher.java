package com.example.dbeduc.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teachers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false)
	String name;
	@Column(nullable = false, unique = true)
	String lastName;
	@Column(nullable = false)
	String subject;
}

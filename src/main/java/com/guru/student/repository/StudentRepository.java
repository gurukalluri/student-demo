package com.guru.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.student.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

}

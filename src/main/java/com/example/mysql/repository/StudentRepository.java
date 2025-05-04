package com.example.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysql.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

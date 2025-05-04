package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.entity.Student;
import com.example.mysql.repository.StudentRepository;

@RestController
@RequestMapping("/api/mysql/students")
public class StudentController {

	@Autowired
    private StudentRepository studentRepository;

//    public StudentController(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @GetMapping
    public List<Student> getAllStudents() {
    	 List<Student> s =  studentRepository.findAll();
    	 return s;
    }
}

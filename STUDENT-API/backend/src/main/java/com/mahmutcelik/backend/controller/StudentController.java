package com.mahmutcelik.backend.controller;

import com.mahmutcelik.backend.dto.StudentDto;
import com.mahmutcelik.backend.service.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @CrossOrigin("http://localhost:4200")
    private List<StudentDto> getStudents(){
        return studentService.getStudents();
    }
}

package com.mahmutcelik.backend.service;

import com.mahmutcelik.backend.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();
}

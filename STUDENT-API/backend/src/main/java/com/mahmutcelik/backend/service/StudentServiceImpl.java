package com.mahmutcelik.backend.service;

import com.mahmutcelik.backend.dto.StudentDto;
import com.mahmutcelik.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentDto::convert)
                .toList();
    }
}

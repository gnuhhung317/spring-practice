package com.example.demo.sevice.imp;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;

import java.util.List;

public interface StudentServiceImp {
    boolean insertStudent(String name, int age);
    boolean insertStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudent();
}

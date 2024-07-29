package net.hung.sms.service;

import net.hung.sms.dto.StudentDto;

import java.util.List;

public interface StudentService {

    void save(StudentDto studentDto);
    List<StudentDto> getAllStudent();
    StudentDto getStudentById(Long id);
    void deleteStudentById(Long id);
    StudentDto updateStudent(StudentDto studentDto);
}

package com.example.demo.sevice;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.sevice.imp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService implements StudentServiceImp {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public boolean insertStudent(String name, int age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        studentRepository.save(student);
        return true;
    }

    @Override
    public boolean insertStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setAge(studentDTO.getAge());
        student.setName(studentDTO.getName());
        studentRepository.save(student);
        return true;
    }

    @Override
    public List<StudentDTO> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new LinkedList<>();
        for (Student student : students){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(student.getName());
            studentDTO.setAge(student.getAge());
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }
}

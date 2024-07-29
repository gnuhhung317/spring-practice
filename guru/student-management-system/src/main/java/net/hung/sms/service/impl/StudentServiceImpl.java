package net.hung.sms.service.impl;

import net.hung.sms.dto.StudentDto;
import net.hung.sms.entity.Student;
import net.hung.sms.mapper.StudentMapper;
import net.hung.sms.repository.StudentRepository;
import net.hung.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(StudentDto studentDto) {

        Student student = StudentMapper.toEntity(studentDto);
        studentRepository.save(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll() ;
        return students.stream().map(StudentMapper::toDto).toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentRepository.findById(id).map(StudentMapper::toDto).orElse(null);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = studentRepository.save(StudentMapper.toEntity(studentDto));
        return StudentMapper.toDto(student);
    }
}

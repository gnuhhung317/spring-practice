package net.hung.sms.mapper;

import net.hung.sms.dto.StudentDto;
import net.hung.sms.entity.Student;

public class StudentMapper {
    public static StudentDto toDto(Student student){
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail());
    }
    public static Student toEntity(StudentDto studentDto){
        return new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getEmail());
    }
}

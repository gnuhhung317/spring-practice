package com.springboot.sb_first_app.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.springboot.sb_first_app.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student= new Student(1,"Hung",20);
        return ResponseEntity.ok().header("custom-header","duchung").body(student);
    }
    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Hung",1));
        students.add(new Student(2,"Hong",2));
        students.add(new Student(3,"Hang",3));
        students.add(new Student(4,"Hong",4));
        return ResponseEntity.ok().body(students);
    }

    //Path variable
    @GetMapping("/student/{id}/{name}")
    public Student studentById(@PathVariable("id")  int id,@PathVariable(value = "name",required = false) String name){
        return new Student(id,name,20);
    }

    // request param
    @GetMapping("/students")
    public Student getStudent(@RequestParam int id){
        return new Student(id,"ngoan",20);
    }

    // post request
    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.toString());
        return student;
    }

    //put request
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.toString());
        return student;
     }

    //delete request
    @DeleteMapping("students/{id}/delete")
    public boolean deleteStudent(@PathVariable int id){

        return true;
    }
}

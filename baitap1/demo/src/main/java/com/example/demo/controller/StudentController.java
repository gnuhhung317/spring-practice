package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.sevice.imp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServiceImp studentServiceImp;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStudent(){
        return new ResponseEntity<>(studentServiceImp.getAllStudent(), HttpStatus.OK);
    }
    @PostMapping("insertBody")
    public ResponseEntity<?> insertStudent(@RequestBody StudentDTO studentDTO){
        return  new ResponseEntity<>(studentServiceImp.insertStudent(studentDTO),HttpStatus.OK);
    }
    @PostMapping("insertVar/{name}/{age}")
    public ResponseEntity<?> insertStudent(@PathVariable String name, @PathVariable int age){
        return  new ResponseEntity<>(studentServiceImp.insertStudent(name,age),HttpStatus.OK);
    }
}

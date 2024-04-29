package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.payloads.ResponseData;
import com.example.demo.service.imp.FileServiceImp;
import com.example.demo.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    FileServiceImp fileServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertUser(@RequestParam String email,
                                     @RequestParam String fullname,
                                     @RequestParam  String password,
                                     @RequestParam  MultipartFile avatar,
                                     @RequestParam  String phone,
                                     @RequestParam String address,
                                     @RequestParam  String website,
                                     @RequestParam  String facebook,
                                     @RequestParam  int roleId){
        ResponseData data = new ResponseData();
        boolean isSuccess = userServiceImp.createUser(email, fullname, password, avatar, phone, address, website, facebook, roleId);
        data.setSuccess(isSuccess);
        data.setData("Insert user");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getUser(@RequestParam int id){
        ResponseData data = new ResponseData();
        data.setData(userServiceImp.getUser(id));
        boolean isSuccess= data.getData()!=null;
        data.setSuccess(isSuccess);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        ResponseData data = new ResponseData();
        data.setData(userServiceImp.getAll());
        boolean isSuccess= data.getData()!=null;
        data.setSuccess(isSuccess);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id,
                                        @RequestBody UserDTO userDTO){

        ResponseData data = new ResponseData();
        data.setSuccess(userServiceImp.updateUser(id,userDTO));
        data.setData("update user");
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        ResponseData data = new ResponseData();
        data.setSuccess(userServiceImp.deleteUser(id));
        data.setData("delete user");
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
}

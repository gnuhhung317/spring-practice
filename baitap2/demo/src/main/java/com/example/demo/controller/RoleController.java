package com.example.demo.controller;

import com.example.demo.dto.RoleDTO;
import com.example.demo.payloads.ResponseData;
import com.example.demo.service.imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleServiceImp roleServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> addRole(@RequestParam String name,
                                     @RequestParam String description){
        ResponseData data = new ResponseData();
        data.setSuccess(roleServiceImp.createRole(name,description));
        data.setData("Insert role");
        return new ResponseEntity<>(data, HttpStatus.OK);

    }
    @GetMapping("/get")
    public ResponseEntity<?> getRole(@RequestParam int id){
        boolean isSuccess = false;
        ResponseData data = new ResponseData();
        data.setData( roleServiceImp.getRole(id));
        if (data.getData()!= null) isSuccess = true;
        data.setSuccess(isSuccess);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        boolean isSuccess = false;
        ResponseData data = new ResponseData();
        data.setData( roleServiceImp.getAll());
        if (data.getData()!= null) isSuccess = true;
        data.setSuccess(isSuccess);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRole(@PathVariable int id,
                                        @RequestBody RoleDTO roleDTO){
        boolean isSuccess = roleServiceImp.updateRole(id,roleDTO);
        ResponseData data = new ResponseData();
        data.setSuccess(isSuccess);
        data.setData("Update role");
        return  new ResponseEntity<>(data,HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable int id){
        boolean isSuccess = roleServiceImp.deleteRole(id);
        ResponseData data = new ResponseData();
        data.setSuccess(isSuccess);
        data.setData("Delete role");
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
}

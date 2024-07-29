package net.duchung.springboot_restful_webservices.controller;

import jakarta.validation.Valid;
import net.duchung.springboot_restful_webservices.dto.UserDto;
import net.duchung.springboot_restful_webservices.entity.User;
import net.duchung.springboot_restful_webservices.exception.ErrorDetails;
import net.duchung.springboot_restful_webservices.exception.ResourceNotFoundException;
import net.duchung.springboot_restful_webservices.mapper.AutoUserMapper;
import net.duchung.springboot_restful_webservices.mapper.UserMapper;
import net.duchung.springboot_restful_webservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){
        UserDto userDto1 = service.createUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
    }
    @GetMapping("getAll")
    public ResponseEntity<List<UserDto>> getAllUsers(){

        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }
    @PutMapping("{id}/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto userDto, @PathVariable Long id){
        userDto.setId(id);
        service.updateUser(userDto);
        return ResponseEntity.ok(userDto);
    }
    @DeleteMapping("{id}/delete")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteUser(id),HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),e.getMessage(),webRequest.getDescription(false),"USER_NOT_FOUND");
//
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//
//    }
}

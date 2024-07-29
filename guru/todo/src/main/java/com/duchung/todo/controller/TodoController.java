package com.duchung.todo.controller;

import com.duchung.todo.dto.TodoDto;
import com.duchung.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    //build Add Todo REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

        return new ResponseEntity<>(todoService.addTodo(todoDto), HttpStatus.CREATED);
    }

    //build Get Todo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id){

        return new ResponseEntity<>(todoService.getTodo(id),HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("getAll")
    public ResponseEntity<List<TodoDto>> getAll(){
        return ResponseEntity.ok(todoService.getAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto){

        todoDto.setId(id);
        return ResponseEntity.ok(todoService.updateTodo(todoDto));

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<TodoDto> deleteTodo(@PathVariable Long id){
        return ResponseEntity.ok(todoService.deleteTodo(id));
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> markComplete(@PathVariable Long id){
        return ResponseEntity.ok(todoService.completeTodo(id));
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("{id}/incomplete")
    public ResponseEntity<TodoDto> markIncomplete(@PathVariable Long id){
        return ResponseEntity.ok(todoService.incompleteTodo(id));
    }

}

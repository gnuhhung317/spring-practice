package com.duchung.todo.service;

import com.duchung.todo.dto.TodoDto;
import com.duchung.todo.entity.Todo;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodo(Long id);
    List<TodoDto> getAll();
    TodoDto updateTodo(TodoDto todoDto);
    TodoDto deleteTodo(Long id);
    TodoDto completeTodo(Long id);
    TodoDto incompleteTodo(Long id);

}

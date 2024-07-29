package com.duchung.todo.service.impl;

import com.duchung.todo.dto.TodoDto;
import com.duchung.todo.entity.Todo;
import com.duchung.todo.exception.ResourceNotFoundException;
import com.duchung.todo.repository.TodoRepository;
import com.duchung.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private TodoRepository repository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = modelMapper.map(todoDto,Todo.class);
        Todo savedTodo = repository.save(todo);

        todoDto = modelMapper.map(savedTodo,TodoDto.class);
        return todoDto;
    }

    @Override
    public List<TodoDto> getAll() {
        return         repository.findAll().stream().map(todo -> modelMapper.map(todo,TodoDto.class)).collect(Collectors.toList());

    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Todo not found with id: "+id)
        );

        TodoDto todoDto = modelMapper.map(todo,TodoDto.class);
        return todoDto;
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto) {
        repository.findById(todoDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Todo not Found with id:" + todoDto.getId()));

        Todo todo = modelMapper.map(todoDto,Todo.class);
        Todo saveTodo = repository.save(todo);
        return modelMapper.map(saveTodo,TodoDto.class);
    }

    @Override
    public TodoDto deleteTodo(Long id) {
        Todo todo =repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo not found with id: "+id));
        repository.deleteById(id);
        return modelMapper.map(todo,TodoDto.class);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo =repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo not found with id: "+id));
        todo.setCompleted(true);
        Todo savedTodo = repository.save(todo);
        return modelMapper.map(savedTodo,TodoDto.class);
    }

    @Override
    public TodoDto incompleteTodo(Long id) {
        Todo todo =repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo not found with id: "+id));
        todo.setCompleted(false);
        Todo savedTodo = repository.save(todo);
        return modelMapper.map(savedTodo,TodoDto.class);    }
}

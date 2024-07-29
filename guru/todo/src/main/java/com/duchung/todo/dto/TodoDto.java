package com.duchung.todo.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TodoDto
{
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}

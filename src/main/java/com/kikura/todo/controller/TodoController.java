package com.kikura.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kikura.todo.entity.Todo;
import com.kikura.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    
    private final TodoService todoService;

    @GetMapping
    public List<Todo> getAll(){
        return todoService.findAll();
    }
}

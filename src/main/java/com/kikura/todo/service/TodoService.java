package com.kikura.todo.service;

import java.util.List;
import com.kikura.todo.entity.Todo;

public interface TodoService {
    List<Todo> findAll();
    Todo save(Todo todo);
    
}
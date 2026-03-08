package com.kikura.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kikura.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

    
} 
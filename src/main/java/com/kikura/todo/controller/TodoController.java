package com.kikura.todo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Todo> getAll() {
        return todoService.findAll();
    }

@PostMapping
public ResponseEntity<Todo> add(@RequestBody Todo todo) {
    // repository.save() は保存後のエンティティ（IDが入っている）を返す
    Todo savedTodo = todoService.save(todo); 
    return ResponseEntity.ok(savedTodo); // ここでID付きのオブジェクトが帰る
}

    @PostMapping("/batch-delete")
    public ResponseEntity<Void> batchDelete(@RequestBody List<Long> ids) {
        todoService.deleteAll(ids);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Todo> update(@RequestBody Todo todo) {
        Todo updatedTodo = todoService.update(todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

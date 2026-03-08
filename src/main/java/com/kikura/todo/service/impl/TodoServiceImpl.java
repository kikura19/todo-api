package com.kikura.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kikura.todo.entity.Todo;
import com.kikura.todo.repository.TodoRepository;
import com.kikura.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        todoRepository.deleteByIdsInBatch(ids);
    }

    @Override
    public Todo update(Todo todo) {
        return todoRepository.findById(todo.getId())
                .map(existingTodo -> {
                    existingTodo.setTask(todo.getTask());
                    existingTodo.setIsCompleted(todo.getIsCompleted());
                    return todoRepository.save(existingTodo);
                })
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

}

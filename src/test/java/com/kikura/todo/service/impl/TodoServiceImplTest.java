package com.kikura.todo.service.impl;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kikura.todo.entity.Todo;
import com.kikura.todo.repository.TodoRepository;

@ExtendWith(MockitoExtension.class)
public class TodoServiceImplTest {
    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoServiceImpl todoService;

    @Test
    void testFindAll() {
        List<Todo> mockTodos = Arrays.asList(new Todo(1L, "テストタスク", false));
        when(todoRepository.findAll()).thenReturn(mockTodos);

        List<Todo> result = todoService.findAll();

        assertEquals(1, result.size());
        assertEquals("テストタスク", result.get(0).getTask());
        verify(todoRepository, times(1)).findAll();

    }
}

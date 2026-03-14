package com.kikura.todo.controller;

// ★ここが一番重要です。これらの静的インポートを追加してください
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; // Spring Boot 3.4+
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.kikura.todo.model.Category;
import com.kikura.todo.model.Todo;
import com.kikura.todo.service.TodoService;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TodoService todoService;

    @Test
    void getTodos_ShouldReturnList() throws Exception {
        // Mockの設定
        List<Todo> mockTodos = Arrays.asList(new Todo(1L, "Angularの勉強", Category.PERSONAL,false));
        given(todoService.findAll()).willReturn(mockTodos);

        // テスト実行
        mockMvc.perform(get("/todos"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].task").value("Angularの勉強"));
    }
}
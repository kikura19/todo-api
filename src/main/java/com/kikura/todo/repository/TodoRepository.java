package com.kikura.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kikura.todo.model.Todo;

import jakarta.transaction.Transactional;

public interface TodoRepository extends JpaRepository<Todo, Long>{

    @Modifying
    @Transactional
    @Query("DELETE FROM Todo t WHERE t.id in :ids")
    void deleteByIdsInBatch(@Param("ids") List<Long> ids);

    
} 
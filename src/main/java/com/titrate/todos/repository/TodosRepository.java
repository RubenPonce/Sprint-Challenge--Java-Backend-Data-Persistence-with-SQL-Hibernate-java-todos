package com.titrate.todos.repository;

import com.titrate.todos.model.Todos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodosRepository extends CrudRepository<Todos, Long> {

    @Query(value = "select * from todos where todos = :userid", nativeQuery = true )
    List<Todos> getAllById(long userid);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM todos WHERE todos = :userid", nativeQuery = true)
    void deleteAllByUserId(long userid);
}


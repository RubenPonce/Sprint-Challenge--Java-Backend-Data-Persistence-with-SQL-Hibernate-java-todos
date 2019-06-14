package com.titrate.todos.service;

import com.titrate.todos.model.Todos;

import java.util.List;

public interface TodosService {
    List<Todos> findAllById(long id);

    Todos findTodosById(long id);

    Todos save(Todos todo);

    void delete(long id);

    Todos update(Todos todo, long id);
}

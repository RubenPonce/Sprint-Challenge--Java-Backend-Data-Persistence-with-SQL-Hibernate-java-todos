package com.titrate.todos.service;

import com.titrate.todos.model.Todos;

import java.util.ArrayList;

public interface TodosService
{
    ArrayList<Todos> findAll();

    Todos findTodosById(long id);

    Todos findTodosByName(String name);

    void delete(long id);

    Todos save(Todos todo);

    Todos update(Todos todo, long id);

    void deleteTodos(long todosid);

    void saveTodos(long todosid);
}

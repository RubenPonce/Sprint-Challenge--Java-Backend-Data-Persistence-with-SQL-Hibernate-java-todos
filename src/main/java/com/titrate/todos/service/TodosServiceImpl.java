package com.titrate.todos.service;

import com.titrate.todos.model.Todos;
import com.titrate.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "todoservice")
public class TodosServiceImpl implements TodosService {

    @Autowired
    private TodosRepository killme;
    @Override
    public List<Todos> findAllById(long id) {
        List<Todos> todolist = new ArrayList<>();
        killme.getAllById(id).iterator().forEachRemaining(todolist::add);
        return todolist;
    }

    @Override
    public Todos findTodosById(long id) {
        return null;
    }

    @Override
    public Todos save(Todos todo) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Todos update(Todos todo, long id) {
        return null;
    }
}



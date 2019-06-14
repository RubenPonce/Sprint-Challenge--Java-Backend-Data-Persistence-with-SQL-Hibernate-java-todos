package com.titrate.todos.service;

import com.titrate.todos.model.Todos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class TodosServiceImpl implements TodosService {
    @Override
    public ArrayList<Todos> findAll() {
        private static final Logger logger = LoggerFactory.getLogger(ZooServiceImpl.class);

        @Autowired
        private TodosRepository todosepos;
        ArrayList<Todos> list = new ArrayList<>();
        todosrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Todos findTodosById(long id) {
        return null;
    }

    @Override
    public Todos findTodosByName(String name) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Todos save(Todos todo) {
        return null;
    }

    @Override
    public Todos update(Todos todo, long id) {
        return null;
    }

    @Override
    public void deleteTodos(long todosid) {

    }

    @Override
    public void saveTodos(long todosid) {

    }
}


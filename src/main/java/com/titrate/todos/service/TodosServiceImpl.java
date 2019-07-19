package com.titrate.todos.service;


import com.titrate.todos.model.Todos;
import com.titrate.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value="todoservice")
public class TodosServiceImpl implements TodosService{
    @Autowired
    private TodosRepository killme;
    @Override
    public List<Todos> findAllById(long id) {
        System.out.println(id);

        List<Todos> todoList = new ArrayList<>();
        System.out.println(killme);
        killme.getAllById(id).iterator().forEachRemaining(todoList::add);
        return todoList;
    }

    @Override
    public Todos findTodosById(long id) {
        System.out.println(killme.findById(id));
        return killme.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Todos save(Todos todo) {
        return killme.save(todo);
    }

    @Override
    public void delete(long id) {
            if (killme.findById(id).isPresent()){
                killme.deleteById(id);
            }else{
                throw new EntityNotFoundException();
            }
    }
    @Override
    public Todos update(Todos todo, long id) {
        Todos currentTodo = killme.findById(id).orElseThrow(EntityNotFoundException::new);
        if (todo.getDatestarted() != null){
            currentTodo.setDatestarted(todo.getDatestarted());
        }
        if (todo.getDescription() != null){
            currentTodo.setDescription(todo.getDescription());
        }
        if (todo.isCompleted()){
            currentTodo.setCompleted(true);
        }else{
            currentTodo.setCompleted(false);
        }
        killme.save(currentTodo);
        return currentTodo;
    }
}

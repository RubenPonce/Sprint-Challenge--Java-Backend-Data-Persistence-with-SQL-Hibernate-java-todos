package com.titrate.todos.controller;

import com.titrate.todos.model.Todos;
import com.titrate.todos.model.User;
import com.titrate.todos.service.TodosService;
import com.titrate.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodosController {
    @Autowired
    private TodosService todosService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/mine", produces = {"application/json"})
    public ResponseEntity<?> getMyTodos(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findUserByUsername(((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername());

        return new ResponseEntity<>(todosService.findAllById(currentUser.getUserid()), HttpStatus.OK);
    }


    @PostMapping(value = "/users/todos/{userid}", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> postNewTodo(@PathVariable long userid, @RequestBody Todos todos){
        todos.setUser(userService.findUserById(userid));
        return new ResponseEntity<>(todosService.save(todos), HttpStatus.OK);
    }

    @PutMapping(value = "/todoss/todosid/{todosid}", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@PathVariable long todosid, @RequestBody Todos todos){
        return new ResponseEntity<>(todosService.update(todos, todosid), HttpStatus.OK);
    }


}


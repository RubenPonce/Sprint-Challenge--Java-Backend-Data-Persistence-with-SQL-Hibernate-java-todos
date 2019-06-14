package com.titrate.todos.controller;

import com.lambdaschool.zoos.service.TodosService;
import com.titrate.todos.model.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    TodosService zooService;

    @PutMapping(value = "/todos/{id}",
                produces = {"application/json"},
                consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(
            @RequestBody
                    Todos updateTodo,
            @PathVariable
                    long id)
    {
        zooService.update(updateTodo, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/todos",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> addNewZoo(HttpServletRequest request, @Valid
    @RequestBody
            Todos newTodo) throws URISyntaxException
    {
        newTodo = zooService.save(newTodo);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        // URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{todoid}").buildAndExpand(newTodo.getZooid()).toUri();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromUriString(request.getServerName() + ":" + request.getLocalPort() + "/todos/todos/{todoid}").buildAndExpand(newTodo.getZooid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/todos/{todoid}")
    public ResponseEntity<?> deleteZooById(
            @PathVariable
                    long todoid)
    {
        zooService.delete(todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/todos/{todoid}/animals/{animalid}")
    public ResponseEntity<?> deleteZooAnimalCombo(
            @PathVariable("todoid")
                    long todoid,
            @PathVariable("animalid")
                    long animalid)
    {
        zooService.deleteTodos(todoid, animalid);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/todos/{todoid}/animals/{animalid}")
    public ResponseEntity<?> saveZooAnimalCombo(HttpServletRequest request,
                                                @PathVariable("todoid")
                    long todoid,
                                                @PathVariable("animalid")
                    long animalid)
    {
        zooService.saveZooAnimalCombo(todoid, animalid);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        // URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{todoid}").buildAndExpand(newTodo.getZooid()).toUri();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromUriString(request.getServerName() + ":" + request.getLocalPort() + "/todos/todos/{todoid}").buildAndExpand(todoid).toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

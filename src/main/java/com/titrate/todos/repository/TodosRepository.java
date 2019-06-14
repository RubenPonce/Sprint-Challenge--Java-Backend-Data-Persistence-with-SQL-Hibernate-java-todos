package com.titrate.todos.repository;

import com.titrate.todos.model.Todos;
import com.titrate.todos.view.JustTheCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TodosRepository {
    Todos findByTodosname(String name);

    @Modifying
    @Query(value = "DELETE FROM todosid WHERE todoid = :todoid", nativeQuery = true)
    void deleteTodos(long todoid);

//    @Modifying
//    @Query(value = "DELETE FROM todos WHERE todoid = :todoid", nativeQuery = true)
//    void deleteTodosAnimalCombo(long todoid);

    @Query(value = "SELECT COUNT(*) as count FROM zooanimals WHERE todoid = :todoid AND animalid = :animalid", nativeQuery = true)
    JustTheCount checkTodosAnimalCombo(long todoid, long animalid);


    @Modifying
    @Query(value = "INSERT INTO zooanimals (todoid, animalid) VALUES (:todoid, :animalid)", nativeQuery = true)
    void saveTodosAnimalCombo(long todoid, long animalid);
}

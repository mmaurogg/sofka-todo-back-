package org.sofka.todolist.repositories;

import org.sofka.todolist.model.ToDoModel;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoModel, Long> {

    
}
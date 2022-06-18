package org.sofka.todolist.repositories;

import org.sofka.todolist.model.ToDoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Método para acceso a la base de datos de los To Do
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @version 1.0.0 17 -junio 2022
 */
@Repository
public interface ToDoRepository extends CrudRepository<ToDoModel, Long> {

}
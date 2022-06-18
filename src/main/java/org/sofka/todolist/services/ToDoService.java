package org.sofka.todolist.services;

import java.util.ArrayList;
import java.util.Optional;

import org.sofka.todolist.model.ToDoModel;

import org.sofka.todolist.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Método para manipulación de la base de datos de los To Do
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @version 1.0.0 17 -junio 2022
 */
@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public ArrayList<ToDoModel> getToDos() {
        return (ArrayList<ToDoModel>) toDoRepository.findAll();
    }

    public ToDoModel saveToDo(ToDoModel toDo){
        return toDoRepository.save(toDo);
    }

    public Optional<ToDoModel> getToDoById(Long id){
        return toDoRepository.findById(id);
    }

    public Boolean updateToDo(Long id, ToDoModel toDo){
        toDo.setId(id);
        try {
            toDoRepository.save(toDo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteToDo(Long id){
        try {
            toDoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

package org.sofka.todolist.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sofka.todolist.model.ToDoModel;

import org.sofka.todolist.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public ArrayList<ToDoModel> getToDos() {
        return (ArrayList<ToDoModel>) toDoRepository.findAll();
    }

    public Optional<List<ToDoModel>> getByList(Long idList) {
        return toDoRepository.findByIdList(idList);
    }

    public ToDoModel saveToDo(ToDoModel toDo){
        return toDoRepository.save(toDo);
    }

    public Optional<ToDoModel> getToDoById(Long id){
        return toDoRepository.findById(id);
    }

    public Optional<List<ToDoModel>> getToDoByList(Long listId){
        return toDoRepository.findByIdList(listId);
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

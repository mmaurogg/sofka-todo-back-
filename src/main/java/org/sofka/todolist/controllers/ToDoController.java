package org.sofka.todolist.controllers;
import java.util.ArrayList;
import java.util.Optional;

import org.sofka.todolist.model.ToDoModel;
import org.sofka.todolist.services.ToDoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    ToDoService toDoService;

    @GetMapping()
    public ArrayList<ToDoModel> getToDos(){
        return toDoService.getToDos();
    }

    @GetMapping(path = "/{id}")
    public Optional<ToDoModel> getToDoId(@PathVariable("id") Long id){
        return this.toDoService.getToDoById(id);
    }

    @PostMapping()
    public ToDoModel saveToDo(@RequestBody ToDoModel toDo){
        return this.toDoService.saveToDo(toDo);
    }

    @PostMapping(path = "/{id}")
    public String updateToDo(@PathVariable("id") Long id, @RequestBody ToDoModel toDo) {
        boolean ok = this.toDoService.updateToDo(id, toDo);
        if (ok) {
            return "Se actualizó el ToDo con id " + id;
        } else {
            return "No pudo actualizar el ToDo con id" + id;
        }
    }

    @DeleteMapping(path = "/{id}")
    public String deleteToDo(@PathVariable("id") Long id) {
        boolean ok = this.toDoService.deleteToDo(id);
        if (ok) {
            return "Se eliminó el ToDo con id " + id;
        } else {
            return "No pudo eliminar el ToDo con id" + id;
        }
    }

}
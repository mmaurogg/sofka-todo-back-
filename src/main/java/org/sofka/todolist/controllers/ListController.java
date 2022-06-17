package org.sofka.todolist.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sofka.todolist.model.ListModel;
import org.sofka.todolist.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/list")
public class ListController {
    @Autowired
    ListService listService;

    @GetMapping()
    public ArrayList<ListModel> getLists(){
        return listService.getLists();
    }

    @GetMapping(path = "/{id}")
    public Optional<ListModel> getListId(@PathVariable("id") Long id){
        return this.listService.getListById(id);
    }

    @PostMapping()
    public ListModel saveList(@RequestBody ListModel list){
        String title = list.getTitle();
        ListModel newList = new ListModel(title);
        return this.listService.saveList(newList);
    }

    @PostMapping(path = "/{id}")
    public String updateList(@PathVariable("id") Long id, @RequestBody ListModel list) {
        boolean ok = this.listService.updateList(id, list);
        if (ok) {
            return "Se actualizó la lista con id " + id;
        } else {
            return "No pudo actualizar la lista con id" + id;
        }
    }

    @DeleteMapping(path = "/{id}")
    public String deleteList(@PathVariable("id") Long id) {
        boolean ok = this.listService.deleteList(id);
        if (ok) {
            return "Se eliminó la lista con id " + id;
        } else {
            return "No pudo eliminar la lista con id" + id;
        }
    }

    
}

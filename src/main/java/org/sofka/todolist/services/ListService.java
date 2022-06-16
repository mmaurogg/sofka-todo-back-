package org.sofka.todolist.services;

import java.util.ArrayList;
import java.util.Optional;

import org.sofka.todolist.model.ListModel;

import org.sofka.todolist.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {
    @Autowired
    ListRepository listRepository;

    public ArrayList<ListModel> getLists() {
        return (ArrayList<ListModel>) listRepository.findAll();
    }

    public ListModel saveList(ListModel list){
        return listRepository.save(list);
    }

    public Optional<ListModel> getListById(Long id){
        return listRepository.findById(id);
    }

    public Boolean updateList(Long id, ListModel list){
        list.setId(id);
        try {
            listRepository.save(list);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean deleteList(Long id){
        try {
            listRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}


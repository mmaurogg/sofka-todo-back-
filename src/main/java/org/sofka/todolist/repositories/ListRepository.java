package org.sofka.todolist.repositories;

import org.sofka.todolist.model.ListModel;
import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<ListModel, Long> {

    
}

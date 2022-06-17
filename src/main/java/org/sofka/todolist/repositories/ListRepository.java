package org.sofka.todolist.repositories;

import org.sofka.todolist.model.ListModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends CrudRepository<ListModel, Long> {

    
}

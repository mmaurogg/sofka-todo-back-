package org.sofka.todolist.repositories;

import java.util.List;
import java.util.Optional;

import org.sofka.todolist.model.ToDoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends CrudRepository<ToDoModel, Long> {

    //@Query(value = "SELECT * FROM todo_list WHERE id_list = ?", nativeQuery = true)
    public abstract Optional<List<ToDoModel>> findByIdList(Long idList);
}
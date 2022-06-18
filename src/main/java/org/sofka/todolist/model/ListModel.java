package org.sofka.todolist.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Modelos de bases de datos objetos para las listas
 * @author Mauricio Gómez - mmaurogg@gmail.com
 * @version 1.0.0 17 -junio 2022
 */
@Entity
@Table(name = "list")
public class ListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_list", unique = true, nullable = false)
    private Long id;

    private String title;

    private Date creation;

    private Date finished;

    private Boolean finish;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    private List<ToDoModel> toDos;


    public ListModel() {
    }

    public ListModel(String title) {
        this.title = title;
        this.creation = new Date();
        this.finish = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getFinished() {
        return finished;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public List<ToDoModel> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDoModel> toDos) {
        this.toDos = toDos;
    }



    
    
}

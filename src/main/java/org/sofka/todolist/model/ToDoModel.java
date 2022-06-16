package org.sofka.todolist.model;

import javax.persistence.*;

@Entity
@Table(name = "todo_list")
public class ToDoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_todo", unique = true, nullable = false)
    private Long id;

    @Column(name="id_list", nullable = false)
    private Long idList;

    private String toDo;

    private Boolean finish;

    @ManyToOne
    @JoinColumn(name = "id_list", insertable = false, updatable = false)
    private ListModel list;

    public ToDoModel() {
    }

    public ToDoModel(Long idList, String toDo) {
        this.idList = idList;
        this.toDo = toDo;
        this.finish = false;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdList() {
        return idList;
    }

    public void setIdList(Long idList) {
        this.idList = idList;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

}
package com.example.restapi.model;

import com.example.restapi.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity entity){
        Todo model = new Todo();
        model.setCompleted(entity.isCompleted());
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        return model;
    }
    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

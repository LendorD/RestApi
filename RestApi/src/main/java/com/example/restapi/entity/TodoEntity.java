package com.example.restapi.entity;

import jakarta.persistence.*;

@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public TodoEntity() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public UserEntity getUser() {
        return user;
    }
}

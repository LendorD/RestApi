package com.example.restapi.entity;

import com.example.restapi.model.Todo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todos;

    public UserEntity() {
    }

    public void setTodos(List<TodoEntity> todos) {
        this.todos = todos;
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

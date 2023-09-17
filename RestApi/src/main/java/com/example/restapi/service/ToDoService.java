package com.example.restapi.service;

import com.example.restapi.entity.TodoEntity;
import com.example.restapi.entity.UserEntity;
import com.example.restapi.model.Todo;
import com.example.restapi.repository.ToDoRepo;
import com.example.restapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    @Autowired
    private UserRepo userRepo;
    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(toDoRepo.save(todo));
    }

    public Todo completeTodo(Long id){
        TodoEntity todo = toDoRepo.findById(id).get();
        todo.setCompleted(!todo.isCompleted());
        return Todo.toModel(toDoRepo.save(todo));
    }
}

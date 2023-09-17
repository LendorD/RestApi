package com.example.restapi.controller;

import com.example.restapi.entity.TodoEntity;
import com.example.restapi.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private ToDoService toDoService;
    
    
    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId){
        try {
            return ResponseEntity.ok(toDoService.createTodo(todo, userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long userId){
        try {
            return ResponseEntity.ok(toDoService.completeTodo(userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}

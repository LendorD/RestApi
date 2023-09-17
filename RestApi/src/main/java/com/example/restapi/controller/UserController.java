package com.example.restapi.controller;

import com.example.restapi.entity.UserEntity;
import com.example.restapi.exception.UserAlreduExistException;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.repository.UserRepo;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registratiopn(@RequestBody UserEntity user){
        try{
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранён");
        }catch (UserAlreduExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try{
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body("Пользователь не был найден");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUesr(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

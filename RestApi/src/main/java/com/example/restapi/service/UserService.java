package com.example.restapi.service;

import com.example.restapi.entity.UserEntity;
import com.example.restapi.exception.UserAlreduExistException;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.model.User;
import com.example.restapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws UserAlreduExistException{
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw  new UserAlreduExistException("Пользователь с таким именем уже существует!");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw  new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}

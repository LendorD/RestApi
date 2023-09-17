package com.example.restapi.exception;

public class UserAlreduExistException extends Exception{
    public UserAlreduExistException(String message) {
        super(message);
    }
}

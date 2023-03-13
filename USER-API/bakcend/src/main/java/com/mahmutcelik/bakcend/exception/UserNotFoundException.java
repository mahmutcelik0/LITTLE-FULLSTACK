package com.mahmutcelik.bakcend.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("USER NOT FOUND");
    }
}

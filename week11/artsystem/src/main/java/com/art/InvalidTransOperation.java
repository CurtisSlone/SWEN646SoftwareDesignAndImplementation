package com.art;

public class InvalidTransOperation extends RuntimeException  {
    public InvalidTransOperation(String message){
        super(message);
    }
}

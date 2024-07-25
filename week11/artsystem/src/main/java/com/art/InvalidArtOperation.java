package com.art;

public class InvalidArtOperation extends RuntimeException {
    public InvalidArtOperation(String message){
        super(message);
    }
}

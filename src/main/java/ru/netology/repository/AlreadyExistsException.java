package ru.netology.repository;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String text){
        super(text);
    }
}

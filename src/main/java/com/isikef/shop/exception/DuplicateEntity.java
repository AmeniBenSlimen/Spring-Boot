package com.isikef.shop.exception;
//classe d'exception avec un constructeur
public class DuplicateEntity extends Exception{
    public DuplicateEntity(String message){
        super(message);
    }
}

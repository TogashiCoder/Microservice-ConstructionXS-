package com.microservices.descovery.exception;

public class RessourceNotFoundException extends RuntimeException{

    public RessourceNotFoundException(){
        super("ressource not found");
    }
}

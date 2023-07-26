package com.goupe2TP.tpAPI.Entity;

import lombok.Data;


public class utilisateurAlreadyExistsException extends RuntimeException{



public utilisateurAlreadyExistsException(){}
    public utilisateurAlreadyExistsException(String message){
        super(message);
    }
}

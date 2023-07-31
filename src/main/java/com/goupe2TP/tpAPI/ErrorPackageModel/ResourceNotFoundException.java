package com.goupe2TP.tpAPI.ErrorPackageModel;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

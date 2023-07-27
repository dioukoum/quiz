package com.goupe2TP.tpAPI.controller.controllerAdvice;

import com.goupe2TP.tpAPI.ErrorPackageModel.ErrorEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.rmi.AlreadyBoundException;


@ControllerAdvice
public class ControllerAdviceConfig {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody ErrorEntity handleException(EntityNotFoundException exception){
        return new ErrorEntity(null, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({RuntimeException.class})
    public @ResponseBody ErrorEntity handleRuntimeException(RuntimeException exception){
        return new ErrorEntity(null, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({BindException.class})
    public @ResponseBody ErrorEntity handleBindException(BindException exception){
        return new ErrorEntity(null, exception.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResourceAccessException.class)
    public @ResponseBody ErrorEntity handleResourceAccessException(ResourceAccessException ex) {
        return new ErrorEntity(null, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({AlreadyBoundException.class})
    public @ResponseBody ErrorEntity handleAlreadyBoundException(AlreadyBoundException ex){
        return new ErrorEntity(null, ex.getMessage());
    }


}

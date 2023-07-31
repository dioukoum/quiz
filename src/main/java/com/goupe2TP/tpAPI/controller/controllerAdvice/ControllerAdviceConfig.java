package com.goupe2TP.tpAPI.controller.controllerAdvice;

import com.goupe2TP.tpAPI.ErrorPackageModel.ErrorEntity;
import com.goupe2TP.tpAPI.ErrorPackageModel.ResourceNotFoundException;
import com.goupe2TP.tpAPI.model.Utilisateur;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.aspectj.bridge.MessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.NotAcceptableStatusException;
import org.webjars.NotFoundException;


@ControllerAdvice
public class ControllerAdviceConfig {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody ErrorEntity handleException(EntityNotFoundException exception){
        return new ErrorEntity("Erreur", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({RuntimeException.class})
    public @ResponseBody ErrorEntity handleRuntimeException(RuntimeException exception){
        return new ErrorEntity("Erreur", exception.getMessage());
    }
@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public @Valid
    @ResponseBody ErrorEntity handleHttpClientErrorException(HttpClientErrorException e) {
        // Log the error
        //logger.error(e);

        // Return a 404 Not Found response with a custom message
        return new  ErrorEntity("La ressource n'est pas trouvé : " , e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)


    @ExceptionHandler({Exception.class})
    public@Valid
    @ResponseBody ErrorEntity handleAllException(Exception exception){
        return new ErrorEntity("Erreur !", exception.getMessage());
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public@Valid
    @ResponseBody ErrorEntity handleNotFoundException(NotFoundException exception){
        return new ErrorEntity("Erreur !", exception.getMessage());
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({RequestRejectedException.class})
    public@Valid
    @ResponseBody ErrorEntity handleRequestRejectedException(RequestRejectedException exception){
        return new ErrorEntity("Erreur !", exception.getMessage());
    }
   

}

package br.com.autosoft.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RegisteredEntityException extends RuntimeException{

    public static final String MESSAGE = "Entity alread registered";

    public RegisteredEntityException (String message) {
        super(message);
    }
    
}

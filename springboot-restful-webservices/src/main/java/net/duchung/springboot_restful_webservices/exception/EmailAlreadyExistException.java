package net.duchung.springboot_restful_webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends RuntimeException{
    private String email;

    public EmailAlreadyExistException( String email) {
        super(String.format("Email %s existed!",email));
        this.email = email;
    }
}

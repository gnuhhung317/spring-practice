package net.duchung.springboot_restful_webservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),e.getMessage(),webRequest.getDescription(false),"USER_NOT_FOUND");

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyException(EmailAlreadyExistException e,WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),e.getMessage(),webRequest.getDescription(false),"EMAIL_EXISTED!");

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception e,WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),e.getMessage(),request.getDescription(false),"INTERNAL_ERROR_SERVER");
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @Override
    public ResponseEntity<Object>  handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        Map<String,String> errors = new HashMap<>();
        List<ObjectError> errorList =  e.getBindingResult().getAllErrors();
        errorList.forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = ((FieldError) error).getDefaultMessage();
            errors.put(fieldName,message);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}

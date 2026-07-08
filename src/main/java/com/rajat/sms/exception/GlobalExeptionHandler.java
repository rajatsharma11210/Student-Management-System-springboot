package com.rajat.sms.exception;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice


public class GlobalExeptionHandler {


@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){

 Map<String, String>errors=new HashMap<>();

 ex.getBindingResult().getFieldErrors().forEach(error -> {
errors.put(error.getField(), error.getDefaultMessage());

 });

return errors;

}

@ExceptionHandler(StudentNotFoundException.class)
public Map<String, String> handleStudentNotFoundException(StudentNotFoundException ex){

 Map<String, String>errors=new HashMap<>();

errors.put("message",ex.getMessage());

return errors;


}







}

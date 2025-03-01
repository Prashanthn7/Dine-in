package com.example.dio.exception.handler;

import com.example.dio.util.FieldErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

//        List<FieldErrorResponse.FieldError> errors = new ArrayList<>();
//        List<ObjectError> ObjectErrors = ex.getAllErrors();
//        for(ObjectError objectError: ObjectErrors){
//            FieldError fieldError = (FieldError)ObjectErrors;
//            FieldErrorResponse.FieldError error = FieldErrorResponse.createFieldError(objectError.getDefaultMessage(), fieldError.getRejectedValue(),fieldError.getField());
//            errors.add(error);
//        } or we can use lamda expression

        List<FieldErrorResponse.CustomFieldError> errors = ex.getAllErrors().stream()
                .map(error -> (FieldError) error)
                .map(this::createFieldError)
                .toList();

        FieldErrorResponse error = createFieldErrorResponse(status, errors);
         return ResponseEntity.status(status).body(error);
    }

    private FieldErrorResponse createFieldErrorResponse(HttpStatusCode status, List<FieldErrorResponse.CustomFieldError> errors) {
    FieldErrorResponse error = FieldErrorResponse.builder()
            .type(status.toString())
            .status(status.value())
            .message("Invalid message")
            .errors(errors)
            .build();
    return error;

    }

    private FieldErrorResponse.CustomFieldError createFieldError(FieldError fieldError) {
        FieldErrorResponse.CustomFieldError errorResponse = FieldErrorResponse.createFieldError(
                fieldError.getDefaultMessage(),
                fieldError.getRejectedValue(),
                fieldError.getField());
        return errorResponse;
    }


}

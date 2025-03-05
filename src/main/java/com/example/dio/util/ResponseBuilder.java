package com.example.dio.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseBuilder {

    /**
     * success() method
     * Helps creating the success response with data including the httpstatus
     * code, message and the data itself
     *
     * @param status     it specifies the status of the request
     * @param message    it specifies the success message of the status
     * @param data       it the data which is involed in the request.
     * @param <T>        it is the generic which is accepting the different types of data.
     * @return           it returns the ResponseEntity of type ResponseStructure of a specific data
     */
    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(status).body(structure);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, HttpHeaders headers, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .headers(headers)
                .body(structure);
    }


    /**
     * is mostly used in the project
     * is a Helper method which includes data and the message
     *
     * @param data     it is the specific data which is involed in the request operation
     * @param message  it sepcifies the success message of the status
     * @param <T>      it is the generic used to accept the data
     * @return         it returns success()[ResponseEntity of type ResponseStructure of Generic data]
     */
    public static <T> ResponseEntity<ResponseStructure<T>> ok(T data, String message) {
        return success(HttpStatus.OK, message, data);
    }

    public static <T> ResponseEntity<ResponseStructure<T>> created(T data, String message) {
        return success(HttpStatus.CREATED, message, data);
    }

    /**
     * It is the Helper method which invokes error() and returns it
     *
     * @param message it is the error message of the status
     * @return        it returns error()[ResponseEntity of type SimpleErrorResponse]
     * @param <T>     it is the generic used to accept the different types of data
     */
    public static <T> ResponseEntity<SimpleErrorResponse> notFound(String message) {
        return error(HttpStatus.NOT_FOUND, message);
    }

    /**
     * Helps creating the error response of the data including the HttpStatus and the error message
     *
     * @param status  it specifies the status of the specific request.
     * @param message it specifies the error message of the specified status
     * @return        it returns the ResponseEntity of type SimpleErrorResponse
     */

    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .status(status.value())
                .message(message)
                .build();

        return ResponseEntity.status(status).body(error);
    }

    /**
     * Helps creating the errorResponse for the group of fields including
     * HttpStatus message and the list of Field Error
     *
     * @param status  it specifies the status of the request
     * @param message it specifies the message of the status responded
     * @param errors  it is the list of Fields which is throwing the Error
     * @return        it returns ResponseEntity of type FieldErrorResponse
     */
    public static ResponseEntity<FieldErrorResponse> error(HttpStatus status, String message, List<FieldErrorResponse.CustomFieldError> errors) {
        FieldErrorResponse fieldErrorResponse = FieldErrorResponse.builder()
                .type(status.name())
                .status(status.value())
                .message(message)
                .errors(errors)
                .build();
        return ResponseEntity.status(status)
                .body(fieldErrorResponse);
    }
}

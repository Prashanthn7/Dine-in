package com.example.dio.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class FieldErrorResponse extends SimpleErrorResponse {


    private List<CustomFieldError> errors;

    /**
     * it creates and returns the CustomFieldError object which is the nested Class of FieldErrorResponse class included the message,
     * field and rejectedValue object
     *
     * @param message it specifies the error message of the particular field
     * @param rejectedValue it is the user entered value
     * @param field it is the field for the user to enter the Requirements
     * @return the CustomFieldError Object
     */
    public static CustomFieldError createFieldError(String message,Object rejectedValue,String field){
        CustomFieldError error = new CustomFieldError();
        error.message = message;
        error.field = field;
        error.rejectedValue = rejectedValue;
        return error;
    }

    @Getter
    public static class CustomFieldError{
        private String message;
        private Object rejectedValue;
        private String field;

    }

}

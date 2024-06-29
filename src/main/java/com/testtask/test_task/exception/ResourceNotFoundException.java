package com.testtask.test_task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final String fieldName1;
    private final String fieldValue1;
    private final String fieldName2;
    private final String fieldValue2;

    public ResourceNotFoundException(String resourceName, String fieldName1, String fieldValue1, String fieldName2, String fieldValue2) {
        super(String.format("%s not found with %s : '%s' and %s : '%s'", resourceName, fieldName1, fieldValue1, fieldName2, fieldValue2));
        this.resourceName = resourceName;
        this.fieldName1 = fieldName1;
        this.fieldValue1 = fieldValue1;
        this.fieldName2 = fieldName2;
        this.fieldValue2 = fieldValue2;
    }
}
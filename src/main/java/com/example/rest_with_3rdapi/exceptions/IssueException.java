package com.example.rest_with_3rdapi.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueException extends Exception {
    private String message;

    public IssueException(String mess) {
        this.message = mess;
    }
}
package de.ebf.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

 
public class ConstraintsViolationException extends Exception {
    public ConstraintsViolationException(String message) {
        super(message);
    }
}

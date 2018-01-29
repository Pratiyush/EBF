package de.ebf.employee.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

 
public class NoRecordFoundException extends Exception {

	private static final long serialVersionUID = 526918701921678800L;

	public NoRecordFoundException() {
        super();
    }

    public NoRecordFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRecordFoundException(String message) {
        super(message);
    }

    public NoRecordFoundException(Throwable cause) {
        super(cause);
    }
}

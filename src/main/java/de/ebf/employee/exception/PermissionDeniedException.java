package de.ebf.employee.exception;

public class PermissionDeniedException extends Exception {

    public PermissionDeniedException() {
        super();
    }

    public PermissionDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionDeniedException(String message) {
        super(message);
    }

    public PermissionDeniedException(Throwable cause) {
        super(cause);
    }
}

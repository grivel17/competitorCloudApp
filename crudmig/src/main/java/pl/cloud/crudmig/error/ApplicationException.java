package pl.cloud.crudmig.error;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {
    private final HttpStatus status;
    private final ErrorCode errorCode;
    
    public ApplicationException(String message, HttpStatus status, ErrorCode errorCode) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }
    
    public HttpStatus getStatus() {
        return status;
    }
    
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

package pl.cloud.crudmig.error;

import org.springframework.http.HttpStatus;

public class CompetitorAlreadyExistsException extends ApplicationException {
    public CompetitorAlreadyExistsException(String message, ErrorCode errorCode) {
        super(message, HttpStatus.CONFLICT, errorCode);
    }
}

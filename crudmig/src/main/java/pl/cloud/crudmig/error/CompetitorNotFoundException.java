package pl.cloud.crudmig.error;

import org.springframework.http.HttpStatus;

public class CompetitorNotFoundException extends ApplicationException {
    public CompetitorNotFoundException(String message, ErrorCode errorCode) {
        super(message, HttpStatus.NOT_FOUND, errorCode);
    }
}

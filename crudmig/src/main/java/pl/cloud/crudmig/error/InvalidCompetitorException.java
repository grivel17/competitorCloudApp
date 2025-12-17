package pl.cloud.crudmig.error;

import org.springframework.http.HttpStatus;

public class InvalidCompetitorException extends ApplicationException {
    public InvalidCompetitorException(String message, ErrorCode errorCode) {
        super(message, HttpStatus.BAD_REQUEST, errorCode);
    }
}

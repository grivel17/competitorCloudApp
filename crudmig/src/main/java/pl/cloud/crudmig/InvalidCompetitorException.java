package pl.cloud.crudmig;

import org.springframework.http.HttpStatus;

public class InvalidCompetitorException extends ApplicationException {
    public InvalidCompetitorException(String message, HttpStatus status) {
        super(message, status);
    }
}

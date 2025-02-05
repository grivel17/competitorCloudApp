package pl.cloud.crudmig;

import org.springframework.http.HttpStatus;

public class CompetitorNotFoundException extends ApplicationException {
    public CompetitorNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

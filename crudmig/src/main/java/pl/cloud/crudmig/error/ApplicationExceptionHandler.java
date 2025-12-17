package pl.cloud.crudmig.error;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
    
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(
            ApplicationException exception,
            HttpServletRequest request) {
        
        logger.error("Application exception [{}]: {}", 
                    exception.getErrorCode().getCode(), 
                    exception.getMessage(), 
                    exception);
        
        ErrorResponse errorResponse = ErrorResponseFactory.createErrorResponse(exception, request);
        
        return new ResponseEntity<>(errorResponse, exception.getStatus());
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception exception,
            HttpServletRequest request) {
        
        logger.error("Unexpected exception: {}", exception.getMessage(), exception);
        
        ErrorResponse errorResponse = ErrorResponseFactory.createErrorResponse(
            exception, 
            request, 
            HttpStatus.INTERNAL_SERVER_ERROR
        );
        
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

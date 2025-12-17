package pl.cloud.crudmig.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class ErrorResponseFactory {
    
    public static ErrorResponse createErrorResponse(
            ApplicationException exception,
            HttpServletRequest request) {
        return new ErrorResponse(
            LocalDateTime.now(),
            exception.getStatus().value(),
            exception.getStatus().getReasonPhrase(),
            exception.getMessage(),
            exception.getErrorCode().getCode(),
            request.getRequestURI()
        );
    }
    
    public static ErrorResponse createErrorResponse(
            Exception exception,
            HttpServletRequest request,
            HttpStatus status) {
        return new ErrorResponse(
            LocalDateTime.now(),
            status.value(),
            status.getReasonPhrase(),
            "Wystąpił nieoczekiwany błąd: " + exception.getMessage(),
            ErrorCode.INTERNAL_ERROR.getCode(),
            request.getRequestURI()
        );
    }
}

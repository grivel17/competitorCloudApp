package pl.cloud.crudmig.error;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseFactoryTest {

    @Test
    void testCreateErrorResponseFromApplicationException() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/competitors/123");
        
        ApplicationException exception = new CompetitorNotFoundException(
            "Zawodnik nie został znaleziony", 
            ErrorCode.COMPETITOR_NOT_FOUND
        );
        
        ErrorResponse response = ErrorResponseFactory.createErrorResponse(exception, request);
        
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
        assertEquals("Zawodnik nie został znaleziony", response.getMessage());
        assertEquals(ErrorCode.COMPETITOR_NOT_FOUND.getCode(), response.getErrorCode());
        assertEquals("/api/competitors/123", response.getPath());
        assertEquals(HttpStatus.NOT_FOUND.getReasonPhrase(), response.getError());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void testCreateErrorResponseFromGenericException() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/test");
        
        Exception exception = new RuntimeException("Nieoczekiwany błąd");
        
        ErrorResponse response = ErrorResponseFactory.createErrorResponse(
            exception, 
            request, 
            HttpStatus.INTERNAL_SERVER_ERROR
        );
        
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
        assertTrue(response.getMessage().contains("Wystąpił nieoczekiwany błąd"));
        assertTrue(response.getMessage().contains("Nieoczekiwany błąd"));
        assertEquals(ErrorCode.INTERNAL_ERROR.getCode(), response.getErrorCode());
        assertEquals("/api/test", response.getPath());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), response.getError());
        assertNotNull(response.getTimestamp());
    }

    @Test
    void testErrorResponseGettersAndSetters() {
        ErrorResponse response = new ErrorResponse();
        LocalDateTime now = LocalDateTime.now();
        
        response.setTimestamp(now);
        response.setStatus(404);
        response.setError("Not Found");
        response.setMessage("Test message");
        response.setErrorCode("TEST-001");
        response.setPath("/test/path");
        
        assertEquals(now, response.getTimestamp());
        assertEquals(404, response.getStatus());
        assertEquals("Not Found", response.getError());
        assertEquals("Test message", response.getMessage());
        assertEquals("TEST-001", response.getErrorCode());
        assertEquals("/test/path", response.getPath());
    }

    @Test
    void testErrorResponseConstructor() {
        LocalDateTime now = LocalDateTime.now();
        
        ErrorResponse response = new ErrorResponse(
            now,
            404,
            "Not Found",
            "Resource not found",
            "RES-001",
            "/api/resource"
        );
        
        assertEquals(now, response.getTimestamp());
        assertEquals(404, response.getStatus());
        assertEquals("Not Found", response.getError());
        assertEquals("Resource not found", response.getMessage());
        assertEquals("RES-001", response.getErrorCode());
        assertEquals("/api/resource", response.getPath());
    }
}

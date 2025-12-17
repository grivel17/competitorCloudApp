package pl.cloud.crudmig.error;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionFactoryTest {

    @Test
    void testCompetitorNotFound() {
        Long id = 123L;
        var exception = ExceptionFactory.competitorNotFound(id);
        
        assertNotNull(exception);
        assertEquals(ErrorCode.COMPETITOR_NOT_FOUND, exception.getErrorCode());
        assertTrue(exception.getMessage().contains("123"));
        assertTrue(exception.getMessage().contains("Zawodnik o ID"));
    }

    @Test
    void testCompetitorsNotFound() {
        Set<Long> ids = Set.of(1L, 2L, 3L);
        var exception = ExceptionFactory.competitorsNotFound(ids);
        
        assertNotNull(exception);
        assertEquals(ErrorCode.COMPETITOR_NOT_FOUND, exception.getErrorCode());
        assertTrue(exception.getMessage().contains("Nie można usunąć zawodników"));
    }

    @Test
    void testInvalidCompetitorData() {
        String reason = "Wiek nie może być ujemny";
        var exception = ExceptionFactory.invalidCompetitorData(reason);
        
        assertNotNull(exception);
        assertEquals(ErrorCode.INVALID_COMPETITOR_DATA, exception.getErrorCode());
        assertTrue(exception.getMessage().contains(reason));
        assertTrue(exception.getMessage().contains("Nieprawidłowe dane zawodnika"));
    }

    @Test
    void testMissingRequiredFields() {
        List<String> missingFields = Arrays.asList("imię", "nazwisko");
        var exception = ExceptionFactory.missingRequiredFields(missingFields);
        
        assertNotNull(exception);
        assertEquals(ErrorCode.MISSING_REQUIRED_FIELDS, exception.getErrorCode());
        assertTrue(exception.getMessage().contains("imię"));
        assertTrue(exception.getMessage().contains("nazwisko"));
        assertTrue(exception.getMessage().contains("Brakujące wymagane pola"));
    }

    @Test
    void testCompetitorAlreadyExists() {
        String name = "Jan";
        String surname = "Kowalski";
        var exception = ExceptionFactory.competitorAlreadyExists(name, surname);
        
        assertNotNull(exception);
        assertEquals(ErrorCode.COMPETITOR_ALREADY_EXISTS, exception.getErrorCode());
        assertTrue(exception.getMessage().contains(name));
        assertTrue(exception.getMessage().contains(surname));
        assertTrue(exception.getMessage().contains("już istnieje w systemie"));
    }
}

package pl.cloud.crudmig.error;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExceptionFactory {
    
    public static CompetitorNotFoundException competitorNotFound(Long id) {
        String message = String.format("Zawodnik o ID %d nie został znaleziony", id);
        return new CompetitorNotFoundException(message, ErrorCode.COMPETITOR_NOT_FOUND);
    }
    
    public static CompetitorNotFoundException competitorsNotFound(Set<Long> ids) {
        String message = String.format(
            "Nie można usunąć zawodników. Następujące ID nie istnieją: %s",
            ids.stream().map(String::valueOf).collect(Collectors.joining(", "))
        );
        return new CompetitorNotFoundException(message, ErrorCode.COMPETITOR_NOT_FOUND);
    }
    
    public static InvalidCompetitorException invalidCompetitorData(String reason) {
        String message = "Nieprawidłowe dane zawodnika: " + reason;
        return new InvalidCompetitorException(message, ErrorCode.INVALID_COMPETITOR_DATA);
    }
    
    public static InvalidCompetitorException missingRequiredFields(List<String> missingFields) {
        String message = String.format(
            "Brakujące wymagane pola: %s",
            String.join(", ", missingFields)
        );
        return new InvalidCompetitorException(message, ErrorCode.MISSING_REQUIRED_FIELDS);
    }
    
    public static CompetitorAlreadyExistsException competitorAlreadyExists(String name, String surname) {
        String message = String.format(
            "Zawodnik %s %s już istnieje w systemie",
            name, surname
        );
        return new CompetitorAlreadyExistsException(message, ErrorCode.COMPETITOR_ALREADY_EXISTS);
    }
}

package pl.cloud.crudmig;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CompetitorValidatorImpl implements CompetitorValidator {
    @Override
    public void validateCompetitor(CompetitorDTO competitorDTO) throws InvalidCompetitorException {
        List<String> fieldsToValidate = Arrays.asList(
                competitorDTO.getName(),
                competitorDTO.getSurname()
        );

        if (isAnyFieldInvalid(fieldsToValidate)) {
            throw new InvalidCompetitorException("Uzupełnij poprawnie dane zawodnika. Dodaj pełne imię i nazwisko", HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isAnyFieldInvalid(List<String> fieldsToValidate) {
        return fieldsToValidate.stream().anyMatch(field -> Objects.isNull(field) || field.isBlank());
    }
}

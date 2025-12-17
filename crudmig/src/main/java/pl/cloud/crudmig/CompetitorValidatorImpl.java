package pl.cloud.crudmig;

import org.springframework.stereotype.Component;
import pl.cloud.crudmig.error.ExceptionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CompetitorValidatorImpl implements CompetitorValidator {
    
    @Override
    public void validateCompetitor(CompetitorDTO competitorDTO) {
        List<String> missingFields = new ArrayList<>();
        
        if (Objects.isNull(competitorDTO.getName()) || competitorDTO.getName().isBlank()) {
            missingFields.add("imię");
        }
        
        if (Objects.isNull(competitorDTO.getSurname()) || competitorDTO.getSurname().isBlank()) {
            missingFields.add("nazwisko");
        }
        
        if (!missingFields.isEmpty()) {
            throw ExceptionFactory.missingRequiredFields(missingFields);
        }
    }
}

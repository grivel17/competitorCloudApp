package pl.cloud.crudmig;

import org.springframework.http.ResponseEntity;

public interface CompetitorReadOnlyService {
    ResponseEntity<CompetitorViewDTO> getCompetitorResponseById(long id);
}

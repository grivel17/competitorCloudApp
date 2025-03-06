package pl.cloud.crudmig;

import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CompetitorReadOnlyService {
    ResponseEntity<CompetitorViewDTO> getCompetitorById(long id);

    Set<CompetitorViewDTO> getAllCompetitors();
}

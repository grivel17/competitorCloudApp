package pl.cloud.crudmig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CompetitorReadOnlyServiceImpl implements CompetitorReadOnlyService {
    private Set<CompetitorViewDTO> competitorMockData;
    private final static String NOT_FOUND_COMPETITOR = "Not found";

    public CompetitorReadOnlyServiceImpl() {
        this.competitorMockData = createMockCompetitorsData();
    }

    @Override
    public ResponseEntity<CompetitorViewDTO> getCompetitorResponseById(long id) {
        Optional<CompetitorViewDTO> competitorViewDTO = findCompetitorById(id);
        if (competitorViewDTO.isPresent()) {
            return new ResponseEntity<>(competitorViewDTO.get(), HttpStatus.OK);
        } else {
            throw new CompetitorNotFoundException(NOT_FOUND_COMPETITOR);
        }
    }

    private Optional<CompetitorViewDTO> findCompetitorById(long id) {
        return competitorMockData.stream().filter(competitor -> competitor.getId() == id).findFirst();
    }

    private Set<CompetitorViewDTO> createMockCompetitorsData() {
        Set<CompetitorViewDTO> mockCompetitorsData = new HashSet<>();
        mockCompetitorsData.add(new CompetitorViewDTO(1L, "Jan", "Paweł II", "KuriaFuria"));
        mockCompetitorsData.add(new CompetitorViewDTO(2L, "Adam", "Słodowy", "Blok mieszkalny"));
        return mockCompetitorsData;
    }
}

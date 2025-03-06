package pl.cloud.crudmig;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CompetitorReadOnlyServiceImpl implements CompetitorReadOnlyService {

    private final CompetitorMockData competitorMockData;

    public CompetitorReadOnlyServiceImpl(CompetitorMockData competitorMockData) {
        this.competitorMockData = competitorMockData;
    }

    @Override
    public ResponseEntity<CompetitorViewDTO> getCompetitorById(long id) {
        Optional<CompetitorViewDTO> competitorViewDTO = CompetitorMockData.findCompetitorById(id);
        if (competitorViewDTO.isPresent()) {
            return new ResponseEntity<>(competitorViewDTO.get(), HttpStatus.OK);
        } else {
            throw new CompetitorNotFoundException("W naszej bazie nie istnieje zawodnik o podanym numerze");
        }
    }

    @Override
    public Set<CompetitorViewDTO> getAllCompetitors() {
        return CompetitorMockData.findAllCompetitors();
    }
}

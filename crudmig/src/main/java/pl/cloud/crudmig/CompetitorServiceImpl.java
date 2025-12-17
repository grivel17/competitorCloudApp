package pl.cloud.crudmig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.cloud.crudmig.error.ExceptionFactory;

import java.util.Set;
import java.util.stream.Collectors;


@Service
//@Transactional
public class CompetitorServiceImpl implements CompetitorService {

    private final CompetitorMockData competitorMockData;
    private static final Logger loggerInfo = LoggerFactory.getLogger(CrudmigApplication.class);
    private final CompetitorValidator competitorValidator;

    public CompetitorServiceImpl(CompetitorValidator competitorValidator, CompetitorMockData competitorMockData) {
        this.competitorValidator = competitorValidator;
        this.competitorMockData = competitorMockData;
    }

    @Override
    public void createCompetitor(CompetitorDTO competitorDTO) {
        competitorValidator.validateCompetitor(competitorDTO);
        loggerInfo.info("Metoda została wywołana! Name {} Klub {}", competitorDTO.getName(), competitorDTO.getClubName());
    }

    @Override
    public void removeCompetitorsByIds(Set<Long> competitorIds) {
        Set<Long> existingIds = CompetitorMockData.findAllCompetitors().stream()
                .map(CompetitorViewDTO::getId)
                .collect(Collectors.toSet());
        
        Set<Long> nonExistingIds = competitorIds.stream()
                .filter(id -> !existingIds.contains(id))
                .collect(Collectors.toSet());
        
        if (!nonExistingIds.isEmpty()) {
            throw ExceptionFactory.competitorsNotFound(nonExistingIds);
        }
        
        loggerInfo.info("Udało się skasować zawodników o numerach: {}", 
            competitorIds.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
